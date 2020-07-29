
# Unity in Android

This is a simple project that demonstrates how to include Unity in an Android app in a separate activity.
The Unity app is also working with the camera texture through C++ and Kotlin.

# Inspiration

This project is a derivative of https://github.com/noncom/CameraCaptureNative so please refer to the
**Inspiration** section there.

The key differences of this project from CameraCaptureNative are:

- No libraries are required to be built and put in the Unity project at all (though usage of
CameraPluginWrapper.cs is still the main interface with the Unity project)
- The Unity project has to be turned into a library itself
- The Unity project library is used in this project as one of the activities
- All else is pretty much the same except for some additional permission handling and maybe some other minor things

# To use this project:

1. In Unity

- Make use of the CameraPluginWrapper.cs script in your Unity Project
- Set Scripting Backend to IL2CPP in Unity Player Settings
- Set Api Compatibility Level to .NET 4.x
- Check both the ARMv7 and ARM64 Target Architectures in Unity Player Settings
- Set the minimum AP level to API Level 22.
- Export the project as Android Project

2. In the exported Android project

- Open the exported project in Android Studio, choose the newer SDK version if asked
- Update the Gradle plugin if asked
- Remove the "launcher" module from `settings.gradle`
- Build the project and collect the *aar* artifact

3. Preparing for build

- Put the *aar* artifact in the "unityLibrary-debug" module folder of this project (notice: it's gitignored by default)
