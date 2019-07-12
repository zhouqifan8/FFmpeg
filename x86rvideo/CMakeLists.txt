cmake_minimum_required(VERSION 3.4.1)

file(GLOB my_source src/main/cpp/*.cpp src/main/cpp/*.c)
set(distribution_DIR ../../../../libs/${ANDROID_ABI})
add_library( native-lib
             SHARED
             ${my_source}
              )
add_library( avcodec
             SHARED
             IMPORTED)
set_target_properties( avcodec
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/libavcodec.so)
add_library( avdevice
             SHARED
             IMPORTED)
set_target_properties( avdevice
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/libavdevice.so)
add_library( avfilter
             SHARED
             IMPORTED)
set_target_properties( avfilter
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/libavfilter.so)

add_library( avformat
             SHARED
             IMPORTED)
set_target_properties( avformat
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/libavformat.so)

add_library( avutil
             SHARED
             IMPORTED)
set_target_properties( avutil
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/libavutil.so)

add_library( swresample
             SHARED
             IMPORTED)
set_target_properties( swresample
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/libswresample.so)

add_library( swscale
             SHARED
             IMPORTED)
set_target_properties( swscale
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/libswscale.so)
include_directories(libs/${ANDROID_ABI}/include)
target_link_libraries( native-lib
                       avcodec
                       avdevice
                       avfilter
                       avformat
                       avutil
                       swresample
                       swscale
                       log
                       android
                       OpenSLES
                        )