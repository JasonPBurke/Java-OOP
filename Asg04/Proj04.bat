echo off

del *.class
javac -cp .;C:\bookClasses Proj04.java
java -cp .;C:\bookClasses Proj04
pause