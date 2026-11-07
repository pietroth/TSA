cmake_minimum_required(VERSION 4.2)

set(CMAKE_EXPERIMENTAL_CXX_IMPORT_STD
    "d0edc3af-4c50-42ea-a356-e2862fe7a444"
)

set(CMAKE_CXX_MODULE_STD ON)

project(TSA LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 26)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

set(CMAKE_EXPORT_COMPILE_COMMANDS ON)

add_subdirectory(external/LightnerX)

add_executable(main
    src/main.cpp
)

add_subdirectory(src/world)

target_link_libraries(main
    PRIVATE
        LightnerX
)
