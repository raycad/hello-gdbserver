LOCAL_PATH := $(call my-dir)

APP_ABI := armeabi
APP_PLATFORM := android-15

include $(CLEAR_VARS)

LOCAL_MODULE    := hello-gdbserver
LOCAL_SRC_FILES := hello-gdbserver.c

LOCAL_CFLAGS    := -Werror -g

include $(BUILD_SHARED_LIBRARY)
