#!/bin/bash

URL=`cat url`
USERNAME="aa1@mail.com"
PASSWORD="test"
COOKIE_FILE="cookie.txt"

wget -d --header="Origin: http://test.com" --header="Content-type: application/json" --post-data="{\"username\":\"$USERNAME\", \"password\":\"$PASSWORD\"}" $URL/login;

wget --method="GET" -d --header="Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwidXNlcklkIjoxLCJleHBpcmVzIjoxNDc5NTgyMTg0Mzg3LCJhdXRob3JpdGllcyI6IlVTRVIifQ.1QE69AwRWTQNhv5efxxFI_7IEcBz2Y6VywzOp4WRQhSakuMRmr-rOlInpAnsWm0Kkgjkh5CyDG8inwnaipVbkw" $URL/report?id=1;

