# Kiptionary
Kiptionary is a set of amazon echo skills, intents, and utternaces for my wonderful fiance!


##Alexa Skill: Kiptionary
To start the Kiptionary, simply say "Alexa, launch Kiptionary"


##Developer notes:
To build a standalone jar, run ```mvn assembly:assembly -DdescriptorId=jar-with-dependencies package``` from the root directory
It requires using jdk 1.7, so you may need to run ```export JAVA_HOME=$(/usr/libexec/java_home -v 1.7)``` if on MACOSX

You will have to specify an app id in the RequestStreamHandler to make this work accordingly with your device/account.