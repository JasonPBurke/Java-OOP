echo off

del *.class
javac -cp .;C:\bookClasses Prob01.java
java -cp .;C:\bookClasses Prob01
pause