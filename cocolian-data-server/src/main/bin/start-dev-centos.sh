#!/bin/bash
# Run in centos
# Author: Shamphone Lee

JAVA="$JAVA_HOME/bin/java"
WORKING_DIR=$(cd `dirname $0`; pwd)
 
WORKING_DIR="$(dirname ${WORKING_DIR})"


echo "running in ${WORKING_DIR}"
 

MAIN_CLASS="org.cocolian.data.server.DataServer"

JAR_LIB="$WORKING_DIR/${project.build.finalName}.jar"
JAR_LIB="${JAR_LIB}:${WORKING_DIR}/lib/*"

LOG_PATH="${WORKING_DIR}/logs"

# JAVA_JVM_OPTION="-Xmx25g -Xms25g -XX:NewSize=15g -XX:MaxNewSize=15g -XX:SurvivorRatio=17 -XX:PermSize=256m -XX:MaxPermSize=256m"

JAVA_JVM_OPTION="-Xmx1g -Xms1g"
JAVA_JVM_OPTION="${JAVA_JVM_OPTION} -Duser.timezone=GMT+8 -Dcocolian.log.path=${LOG_PATH}"


JAVA_JVM_OPTION="${JAVA_JVM_OPTION} -cp ${JAR_LIB} ${MAIN_CLASS}  "

echo "${JAVA}  ${JAVA_JVM_OPTION} "

${JAVA} ${JAVA_JVM_OPTION} 
    
      
