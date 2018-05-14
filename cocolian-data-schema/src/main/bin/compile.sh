#!/bin/bash
 #
 # Author: Shamphone Lee

echo "Delete folder : ${basedir}/src/main/gen"
rm -rf "${basedir}/src/main/gen" 
echo "Create folder : ${basedir}/src/main/gen"
mkdir ${basedir}/src/main/gen
echo "Compiling **/*.proto files..."
protoc --proto_path=${basedir}/src/main/resources --java_out=${basedir}/src/main/gen ${basedir}/src/main/resources/*.proto 
  