#!/bin/bash

#URL=`cat url`
URL=http://localhost:8080/cz.fav.sar.server
USERNAME="test@test.com"
PASSWORD="test"

#wget -d --header="Origin: https://mareksimunek.github.io" --header="Content-type: application/json" --post-data="{\"username\":\"$USERNAME\", \"password\":\"$PASSWORD\"}" $URL/login;

TOKEN="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHRlc3QuY29tIiwidXNlcklkIjoxLCJleHBpcmVzIjoxNDgxNjczNTcyOTM3LCJhdXRob3JpdGllcyI6IlVTRVIifQ.v5rrMwhZpVxKqU6n7N5b8O4788UDTrwf6UYnzaOSWQuK6ng1KaehRkHm-WhGiDjW-bICHNXaBgPy7ZShJX2g9A"

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

