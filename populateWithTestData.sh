#!/bin/bash
#Begin Product Population
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
     "productCategory": "Dairy",
     "name": "Milk",
     "price": 4.20
}'
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
     "productCategory": "Bread",
     "name": "Grain",
     "price": 3.15
}'
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
     "productCategory": "Steak",
     "name": "Meat",
     "price": 8.44
}'
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
     "productCategory": "Coffee",
     "name": "Beverages",
     "price": 3.77
}'
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
     "productCategory": "Cereal",
     "name": "Breakfast Foods",
     "price": 4.14
}'
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
     "productCategory": "Cheese",
     "name": "Dairy",
     "price": 3.31
}'
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
     "productCategory": "Tea Bags",
     "name": "Tea and Coffee",
     "price": 2.25
}'
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
     "productCategory": "Ramen",
     "name": "Noodles",
     "price": 4.42
}'
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
     "productCategory": "Broccoli",
     "name": "Vegetables",
     "price": 5.51
}'
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
     "productCategory": "Avocados",
     "name": "Vegetables",
     "price": 6.67
}'
#End Product Population