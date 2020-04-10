//
// Created by XQSKKFJ on 2020/4/10.
//

#include "yml_minla_jnitest_jnipack_JniTest.h"
#include <string>
extern "C"
JNIEXPORT jstring JNICALL
JNICALL Java_yml_minla_jnitest_jnipack_JniTest_getJniLibraryName(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "minla_core: Hello from C++";
    return env->NewStringUTF(hello.c_str());
}