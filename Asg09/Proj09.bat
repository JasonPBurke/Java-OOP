echo off

del *.class

javac -cp .;C:\bookClasses Proj09.java
java -cp .;C:\bookClasses Proj09 2
pause