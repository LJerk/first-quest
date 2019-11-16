#!/bin/sh
echo "begin compile"
kotlinc -verbose src/pack/Login.kt src/pack/User.kt src/pack/Params.kt src/pack/Validate.kt -include-runtime  -d test2.jar
echo "end compile"

echo "Expected output: 255"
java -jar test2.jar -h
echo "Actual output: $?"
