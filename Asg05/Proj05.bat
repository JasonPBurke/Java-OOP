echo off

del *.class

javac -cp .;C:\bookClasses Proj05.java
java -cp .;C:\bookClasses Proj05
pause