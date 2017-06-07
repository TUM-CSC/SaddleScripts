
#!/bin/bash

cd GAMUT

timestamp=$(date +"%Y-%m-%d_%H-%M-%S")
for i in 1 2 3 4; do
	java -jar gamut.jar -g RandomGame -actions 2 -players 4 -f ../games/RandomGame_${timestamp}_$i.game -output GambitOutput
done

cd ..

# iterate over all game files in current directory
for f in games/*.game; do

	if [ ! -f ${f%.game}.nash ]; then 
		echo "Running gambit on file $f"
    	gambit-enumpoly $f -q | tee ${f%.game}.nash #$f.nash	# executing gambit with command line output of the NE
    	#gambit-enumpoly $f -q > ${f%.game}.nash #$f.nash 		# executing gambit without command line output of the NE
	fi
	if [ ! -f ${f%.game}.saddle ]; then
		echo "Running SaddlePy on file $f"
		python ../SaddlePy/main.py $f
	fi
	# TODO piping SaddlePy output, excluding file handling from the script
done


