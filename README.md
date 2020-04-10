# JNIMinlaCore
一个测试JNI使用的项目，生成的jnilib名字是minla_core。

# 开发步骤

## 一、 生成.h文件

1. 编写xxx.java文件

项目中为 `yml.minla.jnitest.jnipack.JniTest.java` 文件，注意文件中

    static {
        System.loadLibrary("minla_core");
    }

这里已经定义了加载的 JNI library 的名字为 "minla_core"，再之后的 CMakeLists.txt 的打包配置中名字就要一致。

2. 根据java文件生成对应 .class 文件

Terminal 中执行命令 `javac xxx.java`。

3. 根据class文件生成对应 .h 文件

Terminal 中执行命令 `javah 包名.xxx.class` ，执行这一命令需要将目录切换到src/main/java中。

4. 将生成 .h 文件放入正确目录下

选中app目录，右键 new -> Folder -> JNI Folder, 在app/src/main下将生成jni文件夹，将 .h 文件放入其中。

## 二、 编写cpp文件来实现native方法

1. 在jni目录中新建 xxx.cpp 文件

2. #include 在第一步中生成的 .h 文件

3. 实现native方法

## 三、 配置CMakeLists.txt

1. 在app/src/下的任意位置新建 `CMakeLists.txt` 文件

2. 在其中

    add_library( # 这个名字一定要和第一步中的System.loadLibrary中的名字一样
                   minla_core

                   # 设置添加的这个Library是分享的
                   SHARED

                   # 指定第二步中的.cpp文件路径
                   ../jni/version.cpp )

3. 利用 target_link_libraries 可以向 minla_core 库中添加别的库

4. 在app模块的build.gradle文件中配置CMakeLists.txt，android节点下添加externalNativeBuild，代码如下

        externalNativeBuild {
                cmake {
                    path "src/main/java/CMakeLists.txt"
                    version "3.10.2"
                }
            }

5. 编译测试，可在MainActivity中获取到 .cpp 文件返回的结果

## 四、 打包生成 .so 文件

应该是在jni目录中新建Application.mk文件，然后在其中进行配置，这里还没有实验