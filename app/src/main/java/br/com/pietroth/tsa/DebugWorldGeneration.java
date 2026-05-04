package br.com.pietroth.tsa;

import br.com.pietroth.tsa.core.game.world.chunk.*;
import br.com.pietroth.tsa.core.game.world.chunk.generation.*;
import br.com.pietroth.tsa.core.game.world.biome.*;
import br.com.pietroth.tsa.core.game.world.generation.*;
import br.com.pietroth.tsa.core.game.world.WorldConstants;
import br.com.pietroth.tsa.infrastructure.worldgeneration.simplexnoise.SimplexNoiseAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DebugWorldGeneration {
    private static final int WIDTH = 800, HEIGHT = 800;
    private ChunkManager manager;
    private NoiseLayer temperatureLayer, elevationLayer, humidityLayer, lakeNoiseLayer;
    private int blocksPerChunk;
    private int cameraX = 0, cameraY = 0;
    private float zoom = 0.25f;
    private int viewMode = 4; // 1=elevation, 2=temperature, 3=humidity, 4=chunk biome, 5=RGB, 6=biome colors, 7=lake map, 8=chunk border

    public DebugWorldGeneration() {
        setupWorld(new Random().nextLong());
    }

    public DebugWorldGeneration(long seed) {
        setupWorld(seed);
    }

    public DebugWorldGeneration(ChunkManager manager, NoiseLayer temperatureLayer, 
                                NoiseLayer elevationLayer, NoiseLayer humidityLayer, 
                                NoiseLayer lakeNoiseLayer, int blocksPerChunk) {
        this.manager = manager;
        this.temperatureLayer = temperatureLayer;
        this.elevationLayer = elevationLayer;
        this.humidityLayer = humidityLayer;
        this.lakeNoiseLayer = lakeNoiseLayer;
        this.blocksPerChunk = blocksPerChunk;
    }

    private void setupWorld(long seed) {
        Random seedRandom = new Random(seed);
        temperatureLayer = new TemperatureNoiseLayer(new SimplexNoiseAlgorithm(seedRandom.nextLong()));
        elevationLayer = new ElevationNoiseLayer(new SimplexNoiseAlgorithm(seedRandom.nextLong()));
        humidityLayer = new HumidityNoiseLayer(new SimplexNoiseAlgorithm(seedRandom.nextLong()));
        lakeNoiseLayer = new LakeNoiseLayer(new SimplexNoiseAlgorithm(seedRandom.nextLong()));

        BiomeRegister biomeRegister = new MemoryBiomeRegister(16);
        new Biomes(biomeRegister);
        BiomePicker biomePicker = new BiomePicker(biomeRegister);

        ChunkLoader loader = new MemoryChunkLoader();
        ChunkFiller filler = new NoiseChunkFiller(biomePicker, temperatureLayer, elevationLayer, humidityLayer, lakeNoiseLayer);

        manager = new ChunkManager(loader, filler);
        blocksPerChunk = WorldConstants.BLOCKS_PER_CHUNK;
    }

    public void start() {
        JFrame frame = new JFrame("TSA World Debug");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel();
        frame.add(label);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);

        Runnable refresh = () -> {
            BufferedImage img = renderWorld();
            label.setIcon(new ImageIcon(img));
            label.repaint();
        };

        frame.addKeyListener(new KeyAdapter() {
            private final int speed = 64;
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> cameraY -= speed;
                    case KeyEvent.VK_S -> cameraY += speed;
                    case KeyEvent.VK_A -> cameraX -= speed;
                    case KeyEvent.VK_D -> cameraX += speed;
                    case KeyEvent.VK_EQUALS -> zoom = Math.min(16.0f, zoom * 1.25f);
                    case KeyEvent.VK_MINUS -> zoom = Math.max(0.25f, zoom / 1.25f);
                    case KeyEvent.VK_1 -> viewMode = 1;
                    case KeyEvent.VK_2 -> viewMode = 2;
                    case KeyEvent.VK_3 -> viewMode = 3;
                    case KeyEvent.VK_4 -> viewMode = 4;
                    case KeyEvent.VK_5 -> viewMode = 5;
                    case KeyEvent.VK_6 -> viewMode = 6;
                    case KeyEvent.VK_7 -> viewMode = 7;
                    case KeyEvent.VK_8 -> viewMode = 8;
                }
                refresh.run();
            }
        });

        refresh.run();
        frame.setVisible(true);
        frame.requestFocus();
    }

    private BufferedImage renderWorld() {
        int visibleBlocksX = (int)(WIDTH / zoom), visibleBlocksY = (int)(HEIGHT / zoom);
        int startBlockX = cameraX - visibleBlocksX / 2, startBlockY = cameraY - visibleBlocksY / 2;
        int startChunkX = floorDiv(startBlockX, blocksPerChunk), startChunkY = floorDiv(startBlockY, blocksPerChunk);
        int chunksX = visibleBlocksX / blocksPerChunk + 3, chunksY = visibleBlocksY / blocksPerChunk + 3;

        BufferedImage img = new BufferedImage(visibleBlocksX, visibleBlocksY, BufferedImage.TYPE_INT_RGB);
        int[] pixels = ((java.awt.image.DataBufferInt) img.getRaster().getDataBuffer()).getData();

        for (int cx = 0; cx < chunksX; cx++) {
            for (int cy = 0; cy < chunksY; cy++) {
                int chunkX = startChunkX + cx, chunkY = startChunkY + cy;
                Chunk chunk = manager.getChunk(chunkX, chunkY);
                if (chunk == null) {
                    manager.generateChunk(chunkX, chunkY);
                    chunk = manager.getChunk(chunkX, chunkY);
                }

                for (int x = 0; x < blocksPerChunk; x++) {
                    for (int y = 0; y < blocksPerChunk; y++) {
                        int worldX = chunkX * blocksPerChunk + x;
                        int worldY = chunkY * blocksPerChunk + y;
                        int px = worldX - startBlockX, py = worldY - startBlockY;
                        if (px < 0 || py < 0 || px >= visibleBlocksX || py >= visibleBlocksY) continue;

                        int rgb;
                        switch (viewMode) {
                            case 1 -> rgb = grayInt(elevationLayer.getNoise(worldX, worldY));
                            case 2 -> rgb = grayInt(temperatureLayer.getNoise(worldX, worldY));
                            case 3 -> rgb = grayInt(humidityLayer.getNoise(worldX, worldY));
                            case 5 -> { // RGB composite
                                int r = clampInt(elevationLayer.getNoise(worldX, worldY));
                                int g = clampInt(temperatureLayer.getNoise(worldX, worldY));
                                int b = clampInt(humidityLayer.getNoise(worldX, worldY));
                                rgb = (255<<24)|(r<<16)|(g<<8)|b;
                            }
                            case 6 -> { // biome map
                                float e = (float) elevationLayer.getNoise(worldX, worldY);
                                float t = (float) temperatureLayer.getNoise(worldX, worldY);
                                float h = (float) humidityLayer.getNoise(worldX, worldY);
                                if (e < -0.15f) rgb = (255<<24)|(30<<16)|(60<<8)|170;
                                else if (t > 0.35f && h < -0.1f) rgb = (255<<24)|(230<<16)|(220<<8)|130;
                                else rgb = (255<<24)|(110<<16)|(180<<8)|90;
                            } 
                            case 7 -> { // lake map
                                float r = lakeNoiseLayer.getNoise(worldX, worldY);
                                int blue = (int)(r * 255);
                                int green = (int)(r * 180);
                                rgb = (255<<24) | (0<<16) | (green<<8) | blue;
                            }
                            case 8 -> { // chunk borders
                                if (x == 0 || y == 0 || x == blocksPerChunk - 1 || y == blocksPerChunk - 1) {
                                    rgb = (255<<24) | (255<<16) | (0<<8) | 0;
                                } else {
                                    short encoded = chunk.getBlock(x, y);
                                    int id = encoded >> 4;
                                    rgb = switch (id) {
                                        case 1 -> (255<<24)|(200<<16)|(230<<8)|255;
                                        case 2 -> (255<<24)|(30<<16)|(80<<8)|200;
                                        case 3 -> (255<<24)|(150<<16)|(200<<8)|255; // light water
                                        case 10 -> (255<<24)|(40<<16)|(160<<8)|40;
                                        case 11 -> (255<<24)|(120<<16)|(72<<8)|32;
                                        case 12 -> (255<<24)|(220<<16)|(210<<8)|120;
                                        case 20 -> (255<<24)|(130<<16)|(130<<8)|130;
                                        default -> (255<<24)|(255<<16)|(0<<8)|255;
                                    };
                                }
                            }
                            default -> { // chunk block colors
                                short encoded = chunk.getBlock(x, y);
                                int id = encoded >> 4;
                                rgb = switch (id) {
                                    case 1 -> (255<<24)|(200<<16)|(230<<8)|255;
                                    case 2 -> (255<<24)|(30<<16)|(80<<8)|200;
                                    case 3 -> (255<<24)|(150<<16)|(200<<8)|255; // light water
                                    case 10 -> (255<<24)|(40<<16)|(160<<8)|40;
                                    case 11 -> (255<<24)|(120<<16)|(72<<8)|32;
                                    case 12 -> (255<<24)|(220<<16)|(210<<8)|120;
                                    case 20 -> (255<<24)|(130<<16)|(130<<8)|130;
                                    default -> (255<<24)|(255<<16)|(0<<8)|255;
                                };
                            }
                        }

                        pixels[py * visibleBlocksX + px] = rgb;
                    }
                }
            }
        }

        return scale(img);
    }

    private int grayInt(float n) {
        int g = Math.max(0, Math.min(255, (int)(n * 255)));
        return (255<<24)|(g<<16)|(g<<8)|g;
    } 

    private int clampInt(float n) {
        return Math.max(0, Math.min(255, (int)((n*0.5+0.5)*255)));
    }

    private int floorDiv(int a, int b) {
        int r = a/b; if ((a^b)<0 && r*b!=a) r--; return r;
    }

    private BufferedImage scale(BufferedImage image) {
        int w = Math.max(1,(int)Math.round(image.getWidth()*zoom));
        int h = Math.max(1,(int)Math.round(image.getHeight()*zoom));
        BufferedImage scaled = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = scaled.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g.drawImage(image,0,0,w,h,null);
        g.dispose();
        return scaled;
    }
}