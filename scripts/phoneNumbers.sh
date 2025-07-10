#!/usr/bin/env bash
# 193
# Given a text file file.txt that contains a list of phone numbers (one per line),
# write a one-liner bash script to print all valid phone numbers.
# formats:
# (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)
#grep -E "^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$" file.txt
p1="\([0-9][0-9][0-9]\)\ [0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]"
p2="[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]"

while read -r line; do
  case $line in
  $p1)
    echo "$line"
    ;;
  $p2)
    echo "$line"
  esac
done < file.txt