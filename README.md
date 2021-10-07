# Three Java Tasks

## Task 1 - Tree Abstraction
### Description
General abstraction of natural tree.

### Solutions
Main interface:
* Tree - contains components and method suitable for each tree

Specific interface:
* DeciduousTree  - extends main Tree interface, additionaly contains component and method suitable only to deciduous trees

* ConiferousTree  - extends main Tree interface, additionaly contains component and method suitable only to coniferous trees


## Task 2 - Save Geolocalization App

### Description
REST API supports saving geolocation requests.

### Solutions

Setup database parameters.

GeolocationController endpoint
* POST/geolocation

Request format example:
* {'deviceId':'12345', 'latitiude': 505430, 'longitude': 1423412}

Received geolocation data are stored in database.

## Task 3 - Stripe Invoice Library
### Description
Implement an invoice service client library in the Stripe payment system.

### Solutions

Library providing methods to add and read invoices, add customers, products and prices.

Setup Stripe apiKey in application.properties

Steps to create invoice:
1. Create Customer - CustomerService.createCustomer passing customer details
2. Create Product - ProductService.createProduct passing product details
3. Create Invoice - InvoiceService.createInvoice passing invoice details

To get all customer invoices use InvoiceService.getInvoices passing customerId

To get invoice by id use InvoiceService.getInvoice passing invoiceId

