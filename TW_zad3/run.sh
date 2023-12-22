#!/bin/bash
if [ $# -ge 1 ] ; then
  a=$1
else
  a=test1.txt
fi
python3.12 ./order_generator/zad2.py $a
cp tests/$a ./gauss/src/main/resources/test.txt
cp order_output/foata.txt ./gauss/src/main/resources
cd ./gauss 
./gradlew run
