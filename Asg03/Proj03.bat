echo off

del *.class

javac -cp .;C:\bookClasses Proj03.java
java -cp .;C:\bookClasses Proj03
pause