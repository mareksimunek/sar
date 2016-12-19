#!/bin/bash

#URL=`cat url`
URL=http://localhost:8080/cz.fav.sar.server
USERNAME="test@test.com"
PASSWORD="test"

#wget -d --header="Origin: https://mareksimunek.github.io" --header="Content-type: application/json" --post-data="{\"username\":\"$USERNAME\", \"password\":\"$PASSWORD\"}" $URL/login;

TOKEN="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHRlc3QuY29tIiwidXNlcklkIjoxLCJleHBpcmVzIjoxNDgyMTg5MTQ5MDYyLCJhdXRob3JpdGllcyI6IlVTRVIifQ.DnKPNRWt9-mvqtEARNlzx6JOctvKFc3TIlA2p9OrGKsbI9QoKCTgbVByZh9nuK_G9gWjUDAVlvWIG3XHWcX6LA"

DATA="
{
  \"reportType\": \"POZADAVEK\",
  \"dueDate\": 1477868400000,
  \"companyId\": 2,
  \"customerId\": 3,
  \"difficulty\": 10,
  \"reportText\": \"Blabla\",
  \"solvingUserCode\": \"2\",
  \"garantUserCode\": \"4\",
  \"priority\": 5,
  \"name\": \"Úpravy objednávek a smluv pro ISRS\",
  \"systemId\": 2
}";

echo $DATA;

wget --method=PUT -d --header="Authorization: Bearer $TOKEN" --header="Content-Type: application/json" --body-data "$DATA" $URL/addreport

