#!/usr/bin/env bash
# 195
# Given a text file file.txt, print just the 10th line of the file.
#awk '{ if(NR == 10) print $0 }' file.txt
#sed -n '10p' file.txt
mapfile -t lines < file.txt
echo "${lines[9]}"