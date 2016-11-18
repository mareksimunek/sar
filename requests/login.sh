#!/bin/bash

URL=`cat url`
USERNAME="test"
PASSWORD="test"
COOKIE_FILE="cookie.txt"

echo $URL;

echo "";
wget $URL/report;
echo "";

echo "";
wget --save-cookies=$COOKIE_FILE --keep-session-cookies --post-data="username=$USERNAME&password=$PASSWORD" $URL/login;
echo "";

echo "";
wget --load-cookies=$COOKIE_FILE $URL/report?id=1;
echo "";

echo "";
wget --load-cookies=$COOKIE_FILE  --method="POST" $URL/logout;
echo "";

echo "";
wget --load-cookies=$COOKIE_FILE $URL/report?id=1;
echo "";
