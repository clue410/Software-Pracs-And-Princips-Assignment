# Group 8 - Group Project Part C: REST REQUESTS

## Running Kafka:
##### _Windows:_
Use the following two commands in the Windows CMD (one in each window) to start Kafka:
```bash
C:\kafka\bin\windows\zookeeper-server-start.bat C:\kafka\config\zookeeper.properties
```
```bash
C:\kafka\bin\windows\kafka-server-start.bat C:\kafka\config\server.properties
```
##### _MacOS/Linux:_
```bash
./bin/zookeeper-server-start.sh ./config/zookeeper.properties
```
```bash
./bin/kafka-server-start.sh ./config/server.properties
```

## POST Use Cases:

### Use Case 1 - Create Customer:
##### _Windows:_
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"companyName\" : \"LargeCompany inc\", \"address\" : \"222 Business Avenue NSW\", \"country\" : \"Canada\"}" http://localhost:8080/customer
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8080/customer' \ --header 'Content-Type:application/json' \ --data '{"companyName" : "LargeCompany inc", "address" : "222 Business Avenue NSW", "country" : "Canada"}'
```

<p>&nbsp</p>

### Use Case 2 - Create Contact:
##### _Windows:_
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"name\" : \"John Boss\", \"phone\" : \"123 456 990\", \"email\" : \"ceo.business@mail.com\", \"position\" : \"CEO\"}" http://localhost:8080/customer/1/contact
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8080/customer/1/contact' \ --header 'Content-Type:application/json' \ --data-raw '{"name" : "John Boss", "phone" : "123 456 990", "email" : "ceo.business@mail.com", "position" : "CEO"}' 
```

<p>&nbsp</p>

### Use Case 3 - Create Product:
##### _Windows:_
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"productCategory\" : \"Dairy\", \"name\" : \"Milk\", \"price\" : \"4.20\", \"stock\" : \"20\"}" http://localhost:8081/product
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8081/product' --header 'Content-Type: application/json' --data '{"productCategory": "Dairy","name": "Milk","price": 4.20, "stock": 20}'
```

<p>&nbsp</p>

### Use Case 4 - Create ProductDetail:
##### _Windows:_
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"description\" : \"500ml of Chocolate Milk\", \"comment\" : \"Very yummy\"}" http://localhost:8081/product/1/detail
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8081/product/1/detail' --header 'Content-Type: application/json' --data '{"description": "500ml of Chocolate Milk","comment": "Very yummy"}'
```

<p>&nbsp</p>

### Use Case 5 - Create Order:
##### _Windows:_
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"productId\":\"1\", \"supplier\":\"FoodOrder inc\", \"quantity\":\"3\", \"status\":\"unpaid\", \"customerId\":\"1\"}" http://localhost:8082/order
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8082/order' \ --header 'Content-Type:application/json' \ --data '{"productId" : "1", "supplier" : "FoodOrder inc", "quantity" : "3", "status" : "unpaid", "customerId" : "1"}'
```

<p>&nbsp</p>

## PUT Use Cases:

### Use Case 6 - Update Customer:
##### _Windows:_
```shell
curl -i -X PUT -H "Content-Type:application/json" -d "{\"companyName\" : \"SmallCompany inc\", \"address\" : \"333 Business Avenue VIC\", \"country\" : \"Australia\"}" http://localhost:8080/customer/1
```
##### _MacOS/Linux:_
```shell
curl --location --request PUT 'http://localhost:8080/customer/1' \ --header 'Content-Type:application/json' \ --data-raw '{"companyName" : "SmallCompany inc", "address" : "333 Business Avenue VIC", "country" : "Australia"}'
```

<p>&nbsp</p>

### Use Case 7 - Update Contact:
##### _Windows:_
```shell
curl -i -X PUT -H "Content-Type:application/json" -d "{\"name\" : \"allan smith\", \"phone\" : \"102020202\", \"email\" : \"smithy.allan@mail.com\", \"position\" : \"CFO\"}" http://localhost:8080/customer/1/contact
```
##### _MacOS/Linux:_
```shell
curl --location --request PUT 'http://localhost:8080/customer/1/contact' \ --header 'Content-Type:application/json' \ --data-raw '{"name" : "allan smith", "phone" : "102020202", "email" : "smithy.allan@mail.com", "position" : "CFO"}'
```

<p>&nbsp</p>

### Use Case 8 - Update Product:
##### _Windows:_
```shell
curl -i -X PUT -H "Content-Type:application/json" -d "{\"productCategory\" : \"Not Diary\", \"name\" : \"Chocolate Milk\", \"price\" : \"6.00\", \"stock\" : \"30\"}" http://localhost:8081/product/1
```
##### _MacOS/Linux:_
```shell
curl --location --request PUT 'http://localhost:8081/product/1' --header 'Content-Type: application/json' --data '{"productCategory": "Not Dairy","name": "Chocolate Milk", "price": 6.00, "stock": 30}'
```

<p>&nbsp</p>

### Use Case 9 - Update ProductDetail:
##### _Windows:_
```shell
curl -i -X PUT -H "Content-Type:application/json" -d "{\"description\" : \"Dark Chocolate Milk\", \"comment\" : \"May Contain Almonds\"}" http://localhost:8081/product/1/detail
```
##### _MacOS/Linux:_
```shell
curl --location --request PUT 'http://localhost:8081/product/1/detail' --header 'Content-Type: application/json' --data '{"description": "Dark Chcocolate Milk","comment": "May cointain Almonds"}'
```

<p>&nbsp</p>

### Use Case 10 - Update Order:
##### _Windows:_
```shell
curl -i -X PUT -H "Content-Type:application/json" -d "{\"productId\" : \"1\", \"supplier\" : \"FoodDelivery\", \"quantity\" : \"5\", \"status\":\"unpaid\", \"customerId\":\"1\"}" http://localhost:8082/order/1
```
##### _MacOS/Linux:_
```shell
curl --location --request PUT 'http://localhost:8080/order/1' \ --header 'Content-Type:application/json' \ --data '{"productId" : 1, "supplier" : "FoodDelivery", "quantity" : 5, "status" : "unpaid", "customerId" : "1"}' 
```

<p>&nbsp</p>

### Use Case 11 - Buy Order:
##### _Windows:_
```shell
curl -X PUT http://localhost:8082/order/buy/1
```

##### _MacOS/Linux:_
```shell
curl --location --request PUT 'http://localhost:8082/order/buy/1' 
```

<p>&nbsp</p>

## GET Use Cases:

### Use Case 12 - Get All Customers and their Contacts:
##### _Windows:_
```shell
curl -X GET http://localhost:8080/customers
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8080/customers'
```

<p>&nbsp</p>

### Use Case 13 - Find a Specific Customer and its Contacts:
##### _Windows:_
```shell
curl -X GET http://localhost:8080/customer/1
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8080/customer/1'
```

<p>&nbsp</p>

### Use Case 14 - Get All Products and their Details:
##### _Windows:_
```shell
curl -X GET http://localhost:8081/products
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8081/products'
```

<p>&nbsp</p>

### Use Case 15 - Find a Specific Product and its Details:
##### _Windows:_
```shell
curl -X GET http://localhost:8081/product/1
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8081/product/1'
```

<p>&nbsp</p>

### Use Case 16 - Find a Specific Product and its Stock:
##### _Windows:_
```shell
curl -X GET http://localhost:8081/product/1/stock
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8081/product/1/stock'
```

<p>&nbsp</p>

### Use Case 17 - Find All Orders:
##### _Windows:_
```shell
curl -X GET http://localhost:8082/order
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8082/order'
```

<p>&nbsp</p>

### Use Case 18 - Find a Specific Order:
##### _Windows:_
```shell
curl -X GET http://localhost:8082/order/1
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8082/order/1'
```

<p>&nbsp</p>

### Use Case 19 - Get All Customers Sorted By Country Name Alphabetically:
##### _Windows:_
```shell
curl -X GET http://localhost:8080/customers/sort 
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8080/customers/sort' 
```

<p>&nbsp</p>

### Use Case 20 - Get All Products Sorted By Price:
##### _Windows:_
```shell
curl -X GET http://localhost:8081/products/sort
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8081/products/sort'
```

<p>&nbsp</p>

### Viewing List of Kafka Topics:
##### _Windows:_
```shell
C:\kafka\bin\windows\kafka-topics.bat --bootstrap-server=localhost:9092 --list
```
##### _MacOS/Linux:_
```shell
./bin/kafka-topics.sh --bootstrap-server=localhost:9092 --list
```

<p>&nbsp</p>

### Consuming Data in "orderplaced" Topic:
##### _Windows:_
```shell
c:\kafka\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic orderplaced --from-beginning
```
##### _MacOS/Linux:_
```shell
./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic orderplaced --from-beginning
```

<p>&nbsp</p>

### Consuming Data in "productstock" Topic:
##### _Windows:_
```shell
c:\kafka\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic productstock --from-beginning
```
##### _MacOS/Linux:_
```shell
./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic productstock --from-beginning
```