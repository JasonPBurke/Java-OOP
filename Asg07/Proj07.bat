echo off

del *.class

javac -cp .;C:\bookClasses Proj07.java
java -cp .;C:\bookClasses Proj07
pause