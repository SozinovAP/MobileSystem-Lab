cmake_minimum_required(VERSION 3.6.0)

SET(PROJECT_HEADERS
        src/main/cpp/Counter.h
        src/main/cpp/Dictionary.h
        )

SET(PROJECT_SOURCES
        src/main/cpp/Counter.cpp
        src/main/cpp/Dictionary.cpp
        )

add_library(counter-c
    SHARED
${PROJECT_HEADERS} ${PROJECT_SOURCES}
    )