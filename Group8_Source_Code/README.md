# Group 8 - Group Project Part B: REST REQUESTS

## POST Use Cases:

### Use Case 1 - Create Customer:
##### _Windows:_
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"companyName\" : \"LargeCompany inc\", \"address\" : \"222 Business Avenue NSW\", \"country\" : \"Australia\"}" http://localhost:8080/customer
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8080/customer' \ --header 'Content-Type:application/json' \ --data '{"companyName" : "LargeCompany inc", "address" : "222 Business Avenue NSW", "country" : "Australia"}'
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
curl -X POST -H "Content-Type:application/json" -d "{\"productCategory\" : \"Dairy\", \"name\" : \"Milk\", \"price\" : \"4.20\"}" http://localhost:8081/product
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8081/product' \ --header 'Content-Type:application/json' \ --data '{"productCategory": "Dairy", "name": "Milk", "price": 4.20}'
```

<p>&nbsp</p>

### Use Case 4 - Create ProductDetail:
##### _Windows:_
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"description\" : \"500ml of Chocolate Milk\", \"comment\" : \"Very yummy\"}" http://localhost:8081/product/1/detail
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8081/product/1/detail' \ --header 'Content-Type:application/json' \ --data '{"description": "500ml of Chocolate Milk", "comment": "Very yummy"}'
```

<p>&nbsp</p>

### Use Case 5 - Create Order:
##### _Windows:_
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"productId\":\"1\", \"supplier\":\"FoodOrder inc\", \"quantity\":\"3\"}" http://localhost:8082/order
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8082/order' \ --header 'Content-Type:application/json' \ --data '{"productId" : "2", "supplier" : "FoodOrder inc", "quantity" : "3"}'
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
curl -i -X PUT -H "Content-Type:application/json" -d "{\"productCategory\" : \"Not Diary\", \"name\" : \"Chocolate Milk\", \"price\" : \"5.20\"}" http://localhost:8081/product/1
```
##### _MacOS/Linux:_
```shell
curl --location --request PUT 'http://localhost:8081/product/1' \ --header 'Content-Type:application/json' \ --data '{"productCategory": "Not Dairy", "name": "Chocolate Milk", "price": 5.20 }'
```

<p>&nbsp</p>

### Use Case 9 - Update ProductDetail:
##### _Windows:_
```shell
curl -i -X PUT -H "Content-Type:application/json" -d "{\"description\" : \"Dark Chocolate Milk\", \"comment\" : \"May Contain Almonds\"}" http://localhost:8081/product/1/detail
```
##### _MacOS/Linux:_
```shell
curl --location --request PUT 'http://localhost:8081/product/1/detail' \ --header 'Content-Type:application/json' \ --data '{"description": "Dark Chocolate Milk", "comment": "May Contain Almonds"}'
```

<p>&nbsp</p>

### Use Case 10 - Update Order:
##### _Windows:_
```shell
curl -i -X PUT -H "Content-Type:application/json" -d "{\"productId\" : \"1\", \"supplier\" : \"FoodDelivery\", \"quantity\" : \"5\"}" http://localhost:8082/order/1
```
##### _MacOS/Linux:_
```shell
curl --location --request PUT 'http://localhost:8080/order/1' \ --header 'Content-Type:application/json' \ --data '{"productId" : 1, "supplier" : "FoodDelivery", "quantity" : 5}' 
```

<p>&nbsp</p>

## GET Use Cases:

### Use Case 11 - Get All Customers and their Contacts:
##### _Windows:_
```shell
curl -X GET http://localhost:8080/customer
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8080/customer'
```

<p>&nbsp</p>

### Use Case 12 - Find a Specific Customer and its Contacts:
##### _Windows:_
```shell
curl -X GET http://localhost:8080/customer/1
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8080/customer/1'
```

<p>&nbsp</p>

### Use Case 13 - Get All Products and their Details:
##### _Windows:_
```shell
curl -X GET http://localhost:8081/product
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8081/product'
```

<p>&nbsp</p>

### Use Case 14 - Find a Specific Product and its Details:
##### _Windows:_
```shell
curl -X GET http://localhost:8081/product/1
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8081/product/1'
```

<p>&nbsp</p>

### Use Case 15 - Find All Orders:
##### _Windows:_
```shell
curl -X GET http://localhost:8082/order
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8082/order'
```

<p>&nbsp</p>

### Use Case 16 - Find a Specific Order:
##### _Windows:_
```shell
curl -X GET http://localhost:8082/order/1
```
##### _MacOS/Linux:_
```shell
curl --location 'http://localhost:8082/order/1'
```

<p>&nbsp</p>

### Use Case 17 - Find All Orders Placed by a Specific Customer:
##### _Windows:_
```shell

```
##### _MacOS/Linux:_
```shell

```

<p>&nbsp</p>

## Other Use Cases:

### Use Case 18 - Return Order:
##### _Windows:_
```shell

```
##### _MacOS/Linux:_
```shell

```