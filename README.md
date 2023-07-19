# Wireless Network Management Systems

The wireless network management system will be broken down between a server and multiple clients.

## Dependencies

- java sdk
- git

## Network Manager Server

### Build

```bash
- cd server/

Linux
- rm common/*.class networkmanagement/*.class rusystem/*.class connections/*.class
- javac common/*.java networkmanagement/*.java rusystem/*.java connections/*.java
Windows
- del common\*.class networkmanagement\*.class rusystem\*.class connections\*.class
- javac common\*.java networkmanagement\*.java rusystem\*.java connections\*.java

- java networkmanagement.NetworkMain
```

## Network Management Client

Socket communication to server

### Build

```bash
- cd clients/

Linux
- rm common/*.class networkclient/*.class
- javac common/*.java networkclient/*.java
Windows
- del common\*.class networkclient\*.class
- javac common\*.java networkclient\*.java

- java networkclient.NetworkClientMain
```

## Alarm Monitoring Client

Socket communication to server

### Build

```bash
- cd clients/

Linux
- rm common/*.class alarmclient/*.class
- javac common/*.java alarmclient/*.java
Windows
- del common\*.class alarmclient\*.class
- javac common\*.java alarmclient\*.java

- java alarmclient.AlarmClientMain
```

### Team Members

- Akira Aida
- Daksh Joshi
- Nathan Ingram
- Shriya Satish
- Sihao Shen