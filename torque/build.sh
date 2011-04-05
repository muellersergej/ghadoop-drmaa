#!/usr/bin/env bash

# Please set these variables
export JAVA_HOME=/usr/java/default
export TORQUE_HOME=/root/install/torque-2.5.0
export CLASSPATH=$CLASSPATH:../jdrmaa/jdrmaa.jar
export CPLUS_INCLUDE_PATH=${TORQUE_HOME}/src/drmaa/src

make

# cp hadoop-gfarm.jar ${HADOOP_HOME}/lib/
# cp libGfarmFSNative.so ${HADOOP_HOME}/lib/native/Linux-amd64-64/
# cp libGfarmFSNative.so ${HADOOP_HOME}/lib/native/Linux-i386-32/
