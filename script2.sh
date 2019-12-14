#!/bin/sh
echo "begin compile"
kotlinc -verbose src -include-runtime  -d test2.jar
echo "end compile"

echo "Expected output: 255"
java -cp test2.jar pack.LoginKt  -h
echo "Actual output: $?"

echo "Expected output: 0"
java -cp test2.jar pack.LoginKt  -login user1 -pass user -res AB.CD.E -role READ
echo "Actual output: $?"

echo "Expected output: 2"
java -cp test2.jar pack.LoginKt   -login @ -pass admin -res AB -role WRITE
echo "Actual output: $?"

echo "Expected output: 3"
java -cp test2.jar pack.LoginKt   -login addmin -pass admin -res AB -role WRITE
echo "Actual output: $?"

echo "Expected output: 4"
java -cp test2.jar pack.LoginKt  -login admin -pass dsa2 -res AB -role WRITE
echo "Actual output: $?"

echo "Expected output: 5"
java -cp test2.jar pack.LoginKt  -login user1 -pass user -res AB.CD.E -role WRITE
echo "Actual output: $?"
