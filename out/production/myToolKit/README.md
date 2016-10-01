myToolKit
======

## introduction

It's a collection of small tools, which you can look for some tiny basic information or do some tiny tests.
For example, you can translate a ipv4 address like x.x.x.x to an integer number or the otherwise.

## run

Just enter ```java -jar myToolKit.jar``` to run the program.
For convenient, you may write a shell script in you execution path as below:

```
#! /bin/bash

java -jar /..../myToolKit-1.0-SNAPSHOT.jar
```

## develop

It's convenient for any others to add new functions to myToolKit and you may found it's very easy.

1. Add your own command line key words in myToolKit/src/main/java/com.zhulinfeng.toolKit/api/CommandKeyWord.java
2. Implement you own function in myToolKit/src/main/java/com.zhulinfeng.toolKit/impl.
   You may quickly get started by view other implements, and please keep the files well organized.
3. Register you own command line in myToolKit/src/main/java/com.zhulinfeng.toolKit/impl/CommandLineFetcher.java.
4. Build it. Run ```mvn clean install``` on root directory of project myToolKit.

## todo list

1. Add tregex verify
2. Add hashcode generations
3. Add file manipulations
4. ...