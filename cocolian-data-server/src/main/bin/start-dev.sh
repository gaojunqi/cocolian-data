 #!/bin/bash
 #
 # Author: Shamphone Lee

WORKING_DIR=$(cd `dirname $0`; pwd)
 
WORKING_DIR="$(dirname ${WORKING_DIR})"

if [ "$(expr substr $(uname -s) 1 9)" == "CYGWIN_NT" ]; then
	echo "Cygwin detected"
	WORKING_DIR="$(cygpath -m ${WORKING_DIR})"  
fi

echo "running in ${WORKING_DIR}"
 

MAIN_CLASS="org.cocolian.data.server.DataServer"

JAR_LIB=$WORKING_DIR/${project.build.finalName}.jar
JAR_LIB="${JAR_LIB};${WORKING_DIR}/lib/*"

# JAVA_JVM_OPTION="-Xmx25g -Xms25g -XX:NewSize=15g -XX:MaxNewSize=15g -XX:SurvivorRatio=17 -XX:PermSize=256m -XX:MaxPermSize=256m"

JAVA_JVM_OPTION="-Xmx1g -Xms1g"
JAVA_JVM_OPTION="${JAVA_JVM_OPTION} -Duser.timezone=\"GMT+8\" -Dcocolian.log.path=\"${WORKING_DIR}/logs\""


JAVA_JVM_OPTION="${JAVA_JVM_OPTION} -cp \"${JAR_LIB}\" ${MAIN_CLASS}  "

echo "java  ${JAVA_JVM_OPTION}   2>&1 < /dev/null"

java ${JAVA_JVM_OPTION}  2>&1 < /dev/null
    
      
