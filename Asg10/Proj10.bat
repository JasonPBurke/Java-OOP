echo off

del *.class

javac -cp .;C:\bookClasses Proj10.java
java -cp .;C:\bookClasses Proj10 5
pause