#!/usr/bin/env bash
#awk '{ if(NR == 10) print $0 }' file.txt
#sed -n '10p' file.txt
mapfile -t lines < file.txt
echo "${lines[9]}"