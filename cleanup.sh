#!/bin/sh
rm -rf .idea
./gradlew clean
rm -rf .gradle
rm -rf build
rm -rf */build
rm -rf ios/ChatBuilder.xcworkspace
rm -rf ios/Pods
rm -rf ios/ChatBuilder.xcodeproj/project.xcworkspace
rm -rf ios/ChatBuilder.xcodeproj/xcuserdata
