

cmake_minimum_required(VERSION 3.4.1)



add_library( # Sets the name of the library.
             player

             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/player.cpp )

include_directories(src/main/cpp/include)

# 编解码库
add_library(
    avcodec-lib
    SHARED
    IMPORTED
)
set_target_properties(
    avcodec-lib
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/armeabi/libavcodec-57.so
)

# 滤镜库 暂时没用上
add_library(
    avfilter-lib
    SHARED
    IMPORTED
)
set_target_properties(
    avfilter-lib
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/armeabi/libavfilter-6.so
)

# 文件格式库 大部分操作都需要这个库
add_library(
    avformat-lib
    SHARED
    IMPORTED
)
set_target_properties(
    avformat-lib
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/armeabi/libavformat-57.so
)

# 工具库
add_library(
    avutil-lib
    SHARED
    IMPORTED
)
set_target_properties(
    avutil-lib
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/armeabi/libavutil-55.so
)

# 重采样库 主要用于音频的转换
add_library(
    swresample-lib
    SHARED
    IMPORTED
)
set_target_properties(
    swresample-lib
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/armeabi/libswresample-2.so
)

# 视频格式转换库 主要用于视频的转换
add_library(
    swscale-lib
    SHARED
    IMPORTED
)
set_target_properties(
    swscale-lib
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/armeabi/libswscale-4.so
)

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )



target_link_libraries( # Specifies the target library.
                       player
                       android
                       avcodec-lib
                       avfilter-lib
                       avformat-lib
                       avutil-lib
                       swresample-lib
                       swscale-lib

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )