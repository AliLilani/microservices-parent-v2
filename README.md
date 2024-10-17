# E-Commerce Microservice Application

### CSCI318 Group 13

## Overview

The e-commerce application consists of five microservices (Customer, Product, Inventory, Order,
and Notification) that support a variety of use cases. Below are use cases that highlight the core
functionalities of the system, including three that require inter-service communication and two that
involve real-time streaming data processing.

## Key Features

This is an E-commerce Spring Boot microservice application built using Domain-Driven Design
(DDD) and advanced software engineering techniques to ensure maintainability, scalability, and
modularity. Each microservice represents a distinct business domain, such as orders or inventory,
with clearly defined responsibilities and boundaries. This design encourages low coupling and
high cohesion across services. The application follows key design principles, like separation of
concerns, repositories for persistence, and service layers for business logic, creating a clean,
adaptable system.

## Getting Started

### Prerequisites
- **Java 21**
- **Apache Kafka**
- **Spring Boot**

### Setup

1. **Download and Install Apache Kafka**
    #### Linux and MacOS
    Download a **binary package** of Apache Kafka (e.g., `kafka_2.13-3.7.0.tgz`) from
    [https://kafka.apache.org/downloads](https://kafka.apache.org/downloads)
    and upzip it.
    In the Terminal, `cd` to the unzip folder, and start Kakfa with the following commands (each in a separate Terminal session):
    ```bash
    ./bin/zookeeper-server-start.sh ./config/zookeeper.properties
    ```
    ```bash
    ./bin/kafka-server-start.sh ./config/server.properties
    ```

    #### Windows
    Download a **binary package** of Apache Kafka (e.g., `kafka_2.13-3.7.0.tgz`) from
    [https://kafka.apache.org/downloads](https://kafka.apache.org/downloads)
    and unzip it to a directory, e.g., `C:\kafka`&mdash;Windows does not like a complex path name!.
    Use the following two commands in the Windows CMD (one in each window) to start Kafka:
    ```bash
    C:\kafka\bin\windows\zookeeper-server-start.bat C:\kafka\config\zookeeper.properties
    ```
    ```bash
    C:\kafka\bin\windows\kafka-server-start.bat C:\kafka\config\server.properties
    ```

2. **Clone the Repository**
   ```bash
   git clone https://github.com/AliLilani/microservices-parent-v2
   cd microservices-parent-v2
   ```

3. **Build the Project**


## Running The Application

**Add New Customer:**

Linux/MacOS
``` bash
curl -X POST -H "Content-Type:application/json" -d " {"fName": "ali","lName": "hani","contactInfo": {"email": "gfgd@aaaa","phone": "100578445446234","address": "Alexandria"}}" http://localhost:8084/api/customer/addCustomer
```
Windows (Run in cmd not powershell)
``` cmd
curl -X POST -H "Content-Type:application/json" -d " {\"fName\": \"ali\",\"lName\": \"hani\",\"contactInfo\": {\"email\": \"gfgd@aaaa\",\"phone\": \"100578445446234\",\"address\": \"Alexandria\"}}" http://localhost:8084/api/customer/addCustomer
```

**Query Customer By ID:**

Linux/MacOS and Windows(cmd)
```
curl -X GET -H "Content-Type:application/json" http://localhost:8084/api/customers/1
```

**Query All Customers:**

Linux/MacOS and Windows(cmd)
```
curl -X GET -H "Content-Type:application/json" http://localhost:8084/api/customer/allCustomers
```

**Update Customer Information:**

Linux/MacOS
```bash
curl -X PUT -H "Content-Type:application/json" -d "{"fName": "ali","lName": "hani","contactInfo": {"email": "gfgd@aaaa","phone": "254","address": "cairo"}}" http:localhost:8084/api/customer/update/1 
```
Windows (Run in cmd not powershell)
``` cmd
curl -X PUT -H "Content-Type:application/json" -d "{\"fName\": \"ali\",\"lName\": \"hani\",\"contactInfo\": {\"email\": \"gfgd@aaaa\",\"phone\": \"254\",\"address\": \"cairo\"}}" http://localhost:8084/api/customer/update/1
```

**Delete a Customer**

Linux/MacOS and Windows(cmd)
```
curl -X DELETE http://localhost:8084/customer/delete/1
```

**Add a Product**

Linux/MacOS
```bash
curl -X POST -H "Content-Type:application/json" -d "{"name": "mac pro4","description": "lab","price": {"amount": 1000},"vendor": {"vendorName" :"Apple"}}" http://localhost:8083/api/addProduct
```
Windows (Run in cmd not powershell)
``` cmd
curl -X POST -H "Content-Type:application/json" -d "{\"name\": \"mac pro4\",\"description\": \"lab\",\"price\": {\"amount\": 1000},\"vendor\": {\"vendorName\" :\"Apple\"}}" http://localhost:8083/api/addProduct
```

**Query Product By ID**

Linux/MacOS and Windows(cmd)
```
curl -X GET -H "Content-Type:application/json" http://localhost:8083/api/products/1
```

**Query All Products**

Linux/MacOS and Windows(cmd)
```
curl -X GET -H "Content-Type:application/json" http://localhost:8083/api/products
```

**Delete a Product**

Linux/MacOS and Windows(cmd)
```
curl -X GET -H "Content-Type:application/json" http://localhost:8083/api/products/delete/2
```

**Stock Inventory Item**

Linux/MacOS
```bash
curl -X POST -H "Content-Type:application/json" -d "{"productId": 2,"location": {"warehouse": "A","aisle": "L","shelf": "5"},"stock": {"stockQuantity": 10},"expiryDate": {"expiryDate": "2030-09-24"}}" http://localhost:8085/api/inventory/addItem
```
Windows (Run in cmd not powershell)
``` cmd
curl -X POST -H "Content-Type:application/json" -d "{\"productId\": 2,\"location\": {\"warehouse\": \"A\",\"aisle\": \"L\",\"shelf\": \"5\"},\"stock\": {\"stockQuantity\": 10},\"expiryDate\": {\"expiryDate\": \"2030-09-24\"}}" http://localhost:8085/api/inventory/addItem
```

**Find All Items in Inventory**

Linux/MacOS and Windows(cmd)
```
curl -X GET -H "Content-Type:application/json" http://localhost:8085/api/inventory/findAllItems
```

**Place an Order**

Linux/MacOS
```bash
curl -X POST -H "Content-Type:application/json" -d "{"customerId":4,"productIds" : [1 ,2],"salesOrderDate" :{"orderDate": "2023-09-24"},"salesOrderTotalAmount" : {"salesOrderTotalAmount": 2000}}" http://localhost:8081/api/orders/placeOrder
```
Windows (Run in cmd not powershell)
``` cmd
curl -X POST -H "Content-Type:application/json" -d "{\"customerId\":4,\"productIds\" : [1 ,2],\"salesOrderDate\" :{\"orderDate\": \"2023-09-24\"},\"salesOrderTotalAmount\" : {\"salesOrderTotalAmount\": 2000}}" http://localhost:8081/api/orders/placeOrder
```

**Query Order By placingOrderID**

Linux/MacOS and Windows(cmd)
```
curl -X GET -H "Content-Type:application/json" http://localhost:8081/api/orders/placingID/{id generated from previous command} 
```

**Find all orders placed by certain CustomerID**

Linux/MacOS and Windows(cmd)
```
curl -X GET -H "Content-Type:application/json" http://localhost:8081/api/orders/findAllOrdersByCustomer/4
```

**Find all orders exceeding certain total amount**

Linux/MacOS and Windows(cmd)
```
curl -X GET -H "Content-Type:application/json" http://localhost:8081/api/orders/findAllOrdersExceedingAmount/900
```

**Find all Items in Inventory Below Certain stock quantity**

Linux/MacOS and Windows(cmd)
```
curl -X GET -H "Content-Type:application/json" http://localhost:8085/api/inventory/findItemsBelowStockLevel/100
```

## Architecture

- **Spring Boot** for microservice framework.
- **Kafka** for event-driven communication.
- **CQRS** (Command Query Responsibility Segregation) is used for Order and Inventory services to optimize read and write performance.

## Diagrams
![Diagram 1](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/1.png) 
![Diagram 2](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/2.png)
![Diagram 3](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/3.png)
![Diagram 4](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/4.png)
![Diagram 5](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/5.png)
![Diagram 6](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/6.png)
![Diagram 7](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/1.png)
![Diagram 8](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/umls/NotificationUML1.jpg)
![Diagram 9](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/umls/SalesOrderUML.jpg)
![Diagram 10](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/umls/SalesOrderUML2.jpg)
![Diagram 11](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/umls/customerUML1.jpg)
![Diagram 12](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/umls/inventoryUML1.jpg)
![Diagram 13](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/umls/inventoryUML2.jpg)
![Diagram 13](https://github.com/AliLilani/microservices-parent-v2/blob/main/assets/umls/productUML1.jpg)








