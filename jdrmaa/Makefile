# Java
JAVA_SOURCES = \
	org/ggf/drmaa/DefaultContactStringException.java \
	org/ggf/drmaa/DeniedByDrmException.java \
	org/ggf/drmaa/DrmaaException.java \
	org/ggf/drmaa/DrmCommunicationException.java \
	org/ggf/drmaa/DrmsExitException.java \
	org/ggf/drmaa/DrmsInitException.java \
	org/ggf/drmaa/ExitTimeoutException.java \
	org/ggf/drmaa/FileTransferMode.java \
	org/ggf/drmaa/HoldInconsistentStateException.java \
	org/ggf/drmaa/InconsistentStateException.java \
	org/ggf/drmaa/InternalException.java \
	org/ggf/drmaa/InvalidAttributeFormatException.java \
	org/ggf/drmaa/InvalidAttributeValueException.java \
	org/ggf/drmaa/InvalidContactStringException.java \
	org/ggf/drmaa/InvalidJobException.java \
	org/ggf/drmaa/InvalidJobTemplateException.java \
	org/ggf/drmaa/JobInfo.java \
	org/ggf/drmaa/JobTemplate.java \
	org/ggf/drmaa/NoActiveSessionException.java \
	org/ggf/drmaa/NoDefaultContactStringException.java \
	org/ggf/drmaa/PartialTimestampFormat.java \
	org/ggf/drmaa/PartialTimestamp.java \
	org/ggf/drmaa/ReleaseInconsistentStateException.java \
	org/ggf/drmaa/ResumeInconsistentStateException.java \
	org/ggf/drmaa/SessionFactory.java \
	org/ggf/drmaa/Session.java \
	org/ggf/drmaa/SimpleJobTemplate.java \
	org/ggf/drmaa/SuspendInconsistentStateException.java \
	org/ggf/drmaa/TryLaterException.java \
	org/ggf/drmaa/UnsupportedAttributeException.java \
	org/ggf/drmaa/Version.java

all: jdrmaa.jar

jdrmaa.jar: ${JAVA_SOURCES}
	javac -g -Xlint:deprecation ${JAVA_SOURCES}
	jar cf jdrmaa.jar org/ggf/drmaa/*.class

clean:
	rm -f *.class
	rm -f org/ggf/drmaa/*.class
	rm -f jdrmaa.jar

wc:
	wc org/ggf/drmaa/*.java | sort
