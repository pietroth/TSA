target_sources(main
    PUBLIC
        FILE_SET CXX_MODULES
        BASE_DIRS "${PROJECT_SOURCE_DIR}"
        FILES
          tile.cppm
          chunk.cppm
)
