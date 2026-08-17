cmake_minimum_required(VERSION 3.16)
project(LLD_CPP)

set(CMAKE_CXX_STANDARD 14)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

add_executable(document_editor
        "1) Document Editor/src/DocumentElementClient.cpp"
        "1) Document Editor/src/core/DocumentEditor.cpp"
)

target_include_directories(document_editor PRIVATE
        "1) Document Editor/src"
)
