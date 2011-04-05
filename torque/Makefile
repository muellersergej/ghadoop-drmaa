# Java
JAVA_SOURCES = \
	edu/kit/torque/drmaa/JobInfoImpl.java \
	edu/kit/torque/drmaa/JobTemplateImpl.java \
	edu/kit/torque/drmaa/SessionImpl.java \
	edu/kit/torque/drmaa/SessionFactoryImpl.java \

JNI_CLASSES = \
	edu.kit.torque.drmaa.SessionImpl

# GCC
CXXFLAGS = -Wall -O2 -g -D_REENTRANT -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux
LDFLAGS  = -ldrmaa

all: jdrmaa-torque.jar

jdrmaa-torque.jar: libJdrmaaTroqueNative.so
	jar cmf manifest.cf jdrmaa-torque.jar edu/kit/torque/drmaa/*.class libJdrmaaTroqueNative.so

libJdrmaaTroqueNative.so: edu_kit_torque_drmaa_SessionImpl.h edu_kit_torque_drmaa_SessionImpl.c
	gcc ${CXXFLAGS} -shared -fPIC edu_kit_torque_drmaa_SessionImpl.c -o libJdrmaaTroqueNative.so ${LDFLAGS} -L ${TORQUE_HOME}/src/drmaa/src

edu_kit_torque_drmaa_SessionImpl.h: ${JAVA_SOURCES}
	javac -g -Xlint:deprecation -classpath ${CLASSPATH} ${JAVA_SOURCES}
	javah -classpath ${CLASSPATH} -jni ${JNI_CLASSES}

clean:
	rm -f *.class
	rm -f edu/kit/torque/drmaa/*.class
	rm -f edu_kit_torque_drmaa_SessionImpl.h
	rm -f libJdrmaaTroqueNative.so
	rm -f jdrmaa-torque.jar

test: TestJob.java
	javac -g -Xlint:deprecation -classpath ../jdrmaa/jdrmaa.jar TestJob.java
	LD_LIBRARY_PATH=.:/usr/local/lib java -classpath .:jdrmaa-torque.jar:../jdrmaa/jdrmaa.jar -Dorg.ggf.drmaa.SessionFactory="edu.kit.torque.drmaa.SessionFactoryImpl" TestJob ./testjob.sh

wc:
	wc edu/kit/torque/drmaa/*.java *.c | sort
