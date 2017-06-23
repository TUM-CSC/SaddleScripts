#!/bin/bash

in_file=$1


declare -a COUNTERS

while read p; do
	#TODO intialize
	#echo $p
	for num in $p; do
		#echo $num
		((COUNTERS[$num]++))
		#echo "Counter incremented to $COUNTERS[$num]"
	done

	#TODO string zerlegen

done <$1
#done <'counter.txt'

echo ${COUNTERS[@]}

