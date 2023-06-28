# Windows uses backward slashes (ie. '\') and del
# Linux uses forward slashes (ie. '/') and rm

common:
	javac common\*.java
#	javac common/*.java
        
alarmclient: common
	javac alarmclient\*.java
#	javac alarmclient/*.java

networkclient: common
	javac networkclient\*.java
#	javac networkclient/*.java

runnet:
	java networkclient.NetworkClientMain

runalarm:
	java alarmclient.AlarmClientMain

clean:
	del common\*.class
	del alarmclient\*.class
	del networkclient\*.class
#	rm common/*.class
#	rm alarmclient/*.class
#	rm networkclient/*.class