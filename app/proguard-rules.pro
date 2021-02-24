# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#-------------------------------------------------
# JetPack Navigation
# This fixes:
# Caused by: androidx.fragment.app.Fragment$InstantiationException: Unable to instantiate fragment androidx.navigation.fragment.NavHostFragment: make sure class name exists
# Caused by: androidx.fragment.app.Fragment$InstantiationException: Unable to instantiate fragment androidx.fragment.app.Fragment: make sure class name exists
#-------------------------------------------------

-keep class androidx.navigation.fragment.NavHostFragment
-keep class * extends androidx.fragment.app.Fragment{}

#-------------------------------------------------
# Hawk
# This fixes:
# Caused by: java.lang.AssertionError: illegal type variable reference only happend on Android N or higher versions
#-------------------------------------------------
-keep class com.orhanobut.hawk.** { *; }
