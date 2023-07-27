#include "cn_pandaoen_timer_Timer.h"
#include <windows.h>

JNIEXPORT jlong JNICALL
Java_cn_pandaoen_timer_Timer_QueryPerformanceFrequency(JNIEnv *e, jclass cls)
{
    LARGE_INTEGER frequency;
    QueryPerformanceFrequency(&frequency);
    return (jlong)frequency.QuadPart;
}

JNIEXPORT jlong JNICALL
Java_cn_pandaoen_timer_Timer_QueryPerformanceCounter(JNIEnv *e, jclass cls)
{
    LARGE_INTEGER counter;
    QueryPerformanceCounter(&counter);
    return (jlong)counter.QuadPart;
}