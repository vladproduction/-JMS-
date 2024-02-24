# e-commerce-platform

### Scenario: 
An e-commerce platform needs to efficiently process orders placed by customers. 
Instead of directly processing orders within the web application, the system leverages message queues for asynchronous 
and scalable order processing.

### How to start:
* start Active MQ;
* run application;
* produce - consume;
* check result;

### Components:
* **Producer** (The web application acts as the message producer. Upon successful order placement, it creates a message 
            containing order details and publishes it to an ActiveMQ queue)
* **Consumer** ( A separate Java application (emulation) acts as the message consumer. It continuously listens to the queue, receives 
            order messages, and triggers a series of tasks)
    #### **tasks**:
    * Validates the order;
    * Updates inventory levels;
    * Generates invoices;
    * Initiates payment processing;
    * Sends order confirmation emails to customers;
    * Stores the processed order information in a database;


