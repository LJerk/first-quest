#!/bin/sh
echo "begin compile"
kotlinc -verbose src/pack/Login.kt src/pack/User.kt src/pack/Params.kt src/pack/Validate.kt -include-runtime  -d test2.jar
echo "end compile"

echo "Expected output: 255"
java -jar test2.jar -h
echo "Actual output: $?"

echo "Expected output: 0"
java -jar test2.jar -login admin -pass admin
echo "Actual output: $?"

echo "Expected output: 2"
java -jar test2.jar -login @ -pass admin
echo "Actual output: $?"

echo "Expected output: 3"
java -jar test2.jar -login addmin -pass admin
echo "Actual output: $?"

echo "Expected output: 4"
java -jar test2.jar -login admin -pass dsa2
echo "Actual output: $?"
