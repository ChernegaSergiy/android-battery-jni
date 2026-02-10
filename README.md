# BatteryJNI

Android application that provides battery data via JNI for use by PHP extensions.

## Purpose

This Android app runs as a service and exposes battery information through JNI,
allowing PHP extensions to obtain battery data on Android devices where SELinux
policies would otherwise block direct access.

## Requirements

- Android Studio (for development)
- Android NDK
- Android SDK 24+
- Target SDK 34+

## Building

1. Open in Android Studio
2. Build -> Make Project

## License

MIT
