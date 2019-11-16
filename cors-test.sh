#! /bin/bash


# curl -H "Origin: http://localhost:9001" --verbose   http://localhost:8080/api/posts

echo
echo
echo -----
echo

curl --verbose  -X OPTIONS \
-H "Origin: http://localhost:9001" \
-H "Access-Control-Request-Method: DELETE"\
   http://localhost:8080/api/posts