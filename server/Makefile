# Windows uses backward slashes (ie. '\') and del
# Linux uses forward slashes (ie. '/') and rm

common:
	javac common\*.java
#	javac common/*.java
        
alarmmonitor:
	javac alarmmonitor\*.java
#	javac alarmmonitor/*.java

rusystem:
	javac rusystem\*.java
#	javac rusystem/*.java

networkmanagement: common
	javac networkmanagement\*.java
#	javac networkmanagement/*.java

run:
	java networkmanagement.NetworkMain

clean:
	del common\*.class
	del networkmanagement\*.class
	del rusystem\*.class
	del alarmmonitor\*.class
#	rm common/*.class
#	rm networkmanagement/*.class
#	rm rusystem/*.class
#	rm alarmmonitor/*.class