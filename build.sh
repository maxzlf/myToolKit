#!/bin/bash

echo "Compiling java files..."
javac -target 1.8 `find . -name "*.java"`

echo "Creating jar files..."
jar cfm release/myToolKit.jar manifests/MANIFEST.mf\
        `find . -name "*.class"`

echo "Creating jar source files..."
jar cfm release/myToolKit-source.jar manifests/MANIFEST.mf\
        README.md\
        build.sh\
        `find . -name "*.java"`

echo "Deleting class files..."
rm `find . -name "*.class"`

echo "Export to target path..."
sudo cp release/myToolKit.jar /opt/
sudo cp myToolKit.sh /opt/
sudo chmod +x /opt/myToolKit.sh
