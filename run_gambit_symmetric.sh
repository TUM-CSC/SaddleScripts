
#!/bin/bash


no_actions=$1
iterations=$2

cd GAMUT
cd gamut

timestamp=$(date +"%Y-%m-%d_%H-%M-%S")
#for i in 1 2 3 4 5; do
for i in $(seq $iterations); do
	java edu.stanford.multiagent.gamer.Main -g SymmetricRandomZeroSum -actions $no_actions -f ../games/SymmetricRandomZeroSum_${timestamp}_$i.game -output GambitOutput
	#java -classpath build/classes/main edu.stanford.multiagent.gamer.Main "$@" -g SymmetricRandomZeroSum -actions 4 -f ../games/SymmetricRandomZeroSum_${timestamp}_$i.game -output GambitOutput
	# java -classpath /GAMUT/gamut/build/classes/main edu.stanford.multiagent.gamer.Main "$@" -g SymmetricRandomZeroSum -actions 2
	# java -cp /tmp/test/ edu.stanford.multiagent.gamer.Main -g SymmetricRandomZeroSum -actions 2
	#java -jar gamut.jar -g RandomGame -actions 2 -players 4 -f ../games/RandomGame_${timestamp}_$i.game -output GambitOutput
done

cd ..
cd ..

# iterate over all game files in current directory
for f in GAMUT/games/*.game; do

	#if [ ! -f ${f%.game}.nash ]; then 
	#	echo "Running gambit on file $f"
    #	gambit-enumpoly $f -q | tee ${f%.game}.nash #$f.nash	# executing gambit with command line output of the NE
    #	#gambit-enumpoly $f -q > ${f%.game}.nash #$f.nash 		# executing gambit without command line output of the NE
	#fi
	if [ ! -f ${f%.game}.saddle ]; then
		echo "Running SaddlePy on file $f"
		python ../SaddlePy/main.py $f
	fi
	# TODO piping SaddlePy output, excluding file handling from the script
done
