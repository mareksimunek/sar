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
wget --save-cookies=$COOKIE_FILE -o /dev/null -d --keep-session-cookies --post-data="username=$USERNAME&password=$PASSWORD" $URL/login;
echo "";

echo "";
wget --save-cookies=$COOKIE_FILE -d --keep-session-cookies --header="Origin: http://test1111.com" --post-data="username=$USERNAME&password=$PASSWORD" $URL/login;
echo "";

echo "";
wget --load-cookies=$COOKIE_FILE -o /dev/null -d --header="Origin: http://test.com" $URL/report?id=1;
echo "";

echo "";
wget --load-cookies=$COOKIE_FILE -o /dev/null --method="OPTIONS" -d --header="Origin: http://test99.com" $URL/report?id=1;
echo "";

echo "";
wget --load-cookies=$COOKIE_FILE -o /dev/null -d --method="POST" $URL/logout;
echo "";

echo "";
wget --load-cookies=$COOKIE_FILE -o /dev/null -d $URL/report?id=1;
echo "";
