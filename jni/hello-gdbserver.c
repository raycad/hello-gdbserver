#include <string.h>
#include <jni.h>
#include <stdio.h>

/*
 * Class:    	com_example_hellogdbserver_HelloGdbServer
 * Method:    	invokeCrash
 * Signature: 	()V
 */
JNIEXPORT void JNICALL Java_com_example_hellogdbserver_HelloGdbServer_invokeCrash
(JNIEnv *env, jclass clazz)
{
	int *crasher = 0x0;
	*crasher = 0xdeaddead;
}

/*
 * Class:     	com_example_hellogdbserver_HelloGdbServer
 * Method:    	sayHello
 * Params: 		name: person's name to say hello
 * Return:		greeting string
 * Signature: ()V
 */
JNIEXPORT jstring JNICALL Java_com_example_hellogdbserver_HelloGdbServer_sayHello
(JNIEnv *env, jobject obj, jstring name)
{
	/*const char *str = (*env)->GetStringUTFChars(env, name, 0);
	// Need to release this string when done with it in order to avoid memory leak
	(*env)->ReleaseStringUTFChars(env, name, str);
	char ret[100];
	sprintf(ret, "Hello %s", str);
	return (*env)->NewStringUTF(env, ret);*/
	return "Hello RAYCAD";
}
