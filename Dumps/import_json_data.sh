#!/bin/bash

# Need to set enviromental variables for paths.
# Check Dumps/README.md file for further information
# Enviromentals needed:
# - PROJECT_FOLDER

if [ -z ${PROJECT_FOLDER+x} ];
then
    echo "You need to initialliaze enviromentals."
    echo "Check Dumps/README.md file for further information."
    exit -1
fi

# Remove possible "/" in the end
if [ "${PROJECT_FOLDER: -1}" == "/" ];
then
    PROJECT_FOLDER="${PROJECT_FOLDER%/}"
fi

# Configure paths
INPUT_FOLDER="${PROJECT_FOLDER}/Dumps/json"

cd "${INPUT_FOLDER}"

for i in {0..449}
do
    if [ $i -lt 10 ];
    then
        Num="000${i}"
    elif [ $i -lt 100 ];
    then
        Num="00${i}"
    elif [ $i -lt 1000 ];
    then
        Num="0${i}"
    elif [ $i -lt 10000 ];
    then
        Num="${i}"
    else
        echo "Something's wrong with dataset folders!"
        exit -1
    fi

    CURRENT_INPUT_FOLDER="${INPUT_FOLDER}/NCT${Num}xxxx"

    cd "${CURRENT_INPUT_FOLDER}"
    # Loop through all files inside current folder
    file_array=( `ls` )
    length=${#file_array[@]}
    # Import each file into db
    for (( i=0; i<$length; i++ ))
    do
        echo "File ${file_array[$i]} is processed"
        sed -i 's/$t/value/g' ${file_array[$i]}
        mongoimport --db eir --collection clinical_studies --file ${file_array[$i]}
    done

done
