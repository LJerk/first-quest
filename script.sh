#!/bin/sh
rm trainmyself.jar
kotlinc -verbose src/pack/Main.kt -include-runtime -d trainmyself.jar
var="the quick brown fox jumps over the lazy dog "
echo "Input: $var"
echo "Expected output:
brown  1
dog  1
fox  1
jumps  1
lazy  1
over  1
quick  1
the  2"
echo "Actual output:"
java -jar trainmyself.jar $var
