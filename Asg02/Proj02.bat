echo off

del *.class

javac -cp .;C:\bookClasses Proj02.java
java -cp .;C:\bookClasses Proj02
pause