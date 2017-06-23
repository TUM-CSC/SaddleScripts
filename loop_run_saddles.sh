#!/bin/bash

no_actions=$1
iterations=$2
game_type=$3

#for i in $(seq 1 10); do
while true; do

	sh run_gambit_symmetric.sh $no_actions $iterations $game_type
	sleep 1

done

#done
