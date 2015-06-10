Debug native code in Android project with NDK in Eclipse

1. Install CDT from Eclipse update site.
	Help -> Install New Software -> Select Eclipse update -> Programming Language -> C/C++ Development Tools -> Next ... -> Finish
	
2. Download and extract Android NDK.
	https://developer.android.com/tools/sdk/ndk/index.html
		
3. Import your C/C++ source code to Eclipse.

4. Set Android NDK path.
	Window -> Preferences -> Android -> NDK  -> Set path to the NDK
	
5. Right click on an Android project and select Android Tools -> Add native support.
	Note that you will not be able to add native support if the project already has C/C++ nature.

6. Right click project -> Properties -> C/C++ Build then add the following line to the "Build command": 
	ndk-build NDK_DEBUG=1
	
7. Add more line to application tag of the AndroidManifest.xml file:
	android:debuggable="true"
		
8. Set breakpoint in your C/C++ code.

9. Right click on your project, select Debug As -> Android Native Application. 

KNOWN ISSUES:
- Error when debugging: Unable to detect application ABI's
To fix this, add more information to your Android.mk file, e.g:
	APP_ABI := armeabi
	APP_PLATFORM := android-15

- It is recommended to introduce delay (about 5 seconds) in the application code between loading the native code library and calling any native functions (to be debugged), e.g:

try {
	System.loadLibrary("some_native_lib.so");
} catch (UnsatisfiedLinkError e) {
	return -1;
}

// Wait for GDB init
if ((getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0) {
	try {
		Thread.sleep(5000);
        } catch (InterruptedException e) { }
}

// Start calling native functions here
// ...
	
		
	