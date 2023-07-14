# Wireless Network Management Systems

The wireless network management system will be broken down between a server and multiple clients.

## Dependencies

- java sdk
- make
- git

## Server (Network Management, Deployed Network, Network Alarm Monitor)

### Build

#### Option #1

```bash
- cd server/
- make networkmanagement
- make run
```

#### Option #2

```bash
- cd server/

Linux
- rm common/*.class networkmanagement/*.class rusystem/*.class alarmmonitor/*.class connections/*.class
- javac common/*.java networkmanagement/*.java rusystem/*.java alarmmonitor/*.java connections/*.java
Windows
- del common\*.class networkmanagement\*.class rusystem\*.class alarmmonitor\*.class connections\*.class
- javac common\*.java networkmanagement\*.java rusystem\*.java alarmmonitor\*.java connections\*.java

- java networkmanagement.NetworkMain
```

## Network Management Client

Socket communication to server

### Build

#### Option #1

```bash
- cd clients/
- make networkclient
- make runnet
```

#### Option #2

```bash
- cd clients/

Linux
- rm common/*.class networkclient/*.class alarmclient/*.class
- javac common/*.java networkclient/*.java alarmclient/*.java
Windows
- del common\*.class networkclient\*.class alarmclient\*.class
- javac common\*.java networkclient\*.java alarmclient\*.java

- java networkclient.NetworkClientMain
```

## Alarm Monitoring Client

Socket communication to server

### Build

#### Option #1

```bash
- cd clients/
- make alarmclient
- make runalarm
```

#### Option #2

```bash
- cd clients/

Linux
- rm common/*.class networkclient/*.class alarmclient/*.class
- javac common/*.java networkclient/*.java alarmclient/*.java
Windows
- del common\*.class networkclient\*.class alarmclient\*.class
- javac common\*.java networkclient\*.java alarmclient\*.java

- java alarmclient.AlarmClientMain
```

### Team Members

- Akira Aida
- Daksh Joshi
- Nathan Ingram
- Shriya Satish
- Sihao Shen