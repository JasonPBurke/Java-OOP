echo off

del *.class

javac -cp .;C:\bookClasses Proj12.java
java -cp .;C:\bookClasses Proj12 1
pause