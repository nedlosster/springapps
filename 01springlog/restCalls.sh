#!/bin/bash

curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "username=testuser" \
  -d "email=testuser@example.com"

curl -X POST http://localhost:8080/api/users2 \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "username=testuser2" \
  -d "email=testuser2@example.com"
