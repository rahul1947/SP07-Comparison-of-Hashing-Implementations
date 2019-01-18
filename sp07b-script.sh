#! /bin/bash

javac rsn170330/*.java
echo "---------- 1 Million ----------"
java rsn170330.HashingDriver2 1000000 0
echo ''
java rsn170330.HashingDriver2 1000000 1
echo ''
java rsn170330.HashingDriver2 1000000 2
echo ''
java rsn170330.HashingDriver2 1000000 3
echo ''
echo "---------- 2 Million ----------"
java rsn170330.HashingDriver2 2000000 0
echo ''
java rsn170330.HashingDriver2 2000000 1
echo ''
java rsn170330.HashingDriver2 2000000 2
echo ''
java rsn170330.HashingDriver2 2000000 3
echo ''
echo "---------- 3 Million ----------"
java rsn170330.HashingDriver2 3000000 0
echo ''
java rsn170330.HashingDriver2 3000000 1
echo ''
java rsn170330.HashingDriver2 3000000 2
echo ''
java rsn170330.HashingDriver2 3000000 3
echo ''
echo "---------- 4 Million ----------"
java -Xms2g rsn170330.HashingDriver2 4000000 0
echo ''
java -Xms2g rsn170330.HashingDriver2 4000000 1
echo ''
java -Xms2g rsn170330.HashingDriver2 4000000 2
echo ''
java -Xms2g rsn170330.HashingDriver2 4000000 3
echo ''
echo "---------- 5 Million ----------"
java -Xms2g rsn170330.HashingDriver2 5000000 0
echo ''
java -Xms2g rsn170330.HashingDriver2 5000000 1
echo ''
java -Xms2g rsn170330.HashingDriver2 5000000 2
echo ''
java -Xms2g rsn170330.HashingDriver2 5000000 3
echo ''
echo "---------- 8 Million ----------"
java -Xms2g rsn170330.HashingDriver2 8000000 0
echo ''
java -Xms2g rsn170330.HashingDriver2 8000000 1
echo ''
java -Xms2g rsn170330.HashingDriver2 8000000 2
echo ''
java -Xms2g rsn170330.HashingDriver2 8000000 3
echo ''
echo "---------- 10 Million ----------"
java -Xms3g rsn170330.HashingDriver2 10000000 0
echo ''
java -Xms3g rsn170330.HashingDriver2 10000000 1
echo ''
java -Xms3g rsn170330.HashingDriver2 10000000 2
echo ''
java -Xms3g rsn170330.HashingDriver2 10000000 3
echo "-------------------------------"

exit 0