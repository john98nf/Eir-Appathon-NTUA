#!/bin/bash

# Need to set enviromental variables for paths.
# Check Data/README.md file for further information
# Enviromentals needed:
# - PROJECT_FOLDER

if [ -z ${PROJECT_FOLDER+x} ];
then
    echo "You need to initialliaze enviromentals."
    echo "Check Data/README.md file for further information."
    exit -1
fi

# Remove possible "/" in the end
if [ "${PROJECT_FOLDER: -1}" == "/" ];
then
    PROJECT_FOLDER="${PROJECT_FOLDER%/}"
fi

# Configure paths
OUTPUT_FOLDER="${PROJECT_FOLDER}/Data/json"
INPUT_FOLDER="${PROJECT_FOLDER}/Data/xml"

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
    CURRENT_OUTPUT_FOLDER="${OUTPUT_FOLDER}/NCT${Num}xxxx"
    mkdir -p "${CURRENT_OUTPUT_FOLDER}"

    # Loop through all files inside current folder
    file_array=( `ls ${CURRENT_INPUT_FOLDER}` )
    length=${#file_array[@]}
    for (( i=0; i<$length; i++ ))
    do
        echo "File ${file_array[$i]} is processed"
        # Set dot "." as delimiter
        IFS='.'
        #Read the split words into an array based on dot delimiter
        read -a temporary <<< "${file_array[$i]}"
        output_file="${temporary[0]}.json"

        # Main job
        python3 -m xmljson -d parker -o "${CURRENT_OUTPUT_FOLDER}/${output_file}" "${CURRENT_INPUT_FOLDER}/${file_array[$i]}"

    done

done
