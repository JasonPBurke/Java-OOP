echo off

del *.class

javac -cp .;C:\bookClasses Proj08.java
java -cp .;C:\bookClasses Proj08
pause