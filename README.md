# ACMEDelivery

## Introduction
The introduction of the ACME Delivery Service Software Requirements Specification(SRS) provides an overview of the purpose,  scope,  definitions,andoverview of  the SRS.  This  document aims  to provide  a well-defined  set of requirements the ACME Delivery Service siteshould implement.The detailed requirements of the ACME Delivery Serviceare provided in this document.

## Technology Stack
* Java 17
* Angular Framework13
* Spring Boot latest production release
* Maven latest production release
* Oracledatabase server
To call your endpoints, you may utilize one of the following tools:
* Postman Application
* Intellij HTTP Client
* Curl command-line tool

# Functional Requirements

## Product Perspective
ACME Delivery Service is awebapplication that allows individualsto order online food, coffee, beverages,etc.To use the application, the user must register using a unique phone and email address.Your goal isto create a functioning web application using Angular, following the practices covered during the sessions. The   web  application should expose aUI section   for   every   business   requirement  and should communicate with the back-end Spring Boot application using a set of well-defined RESTful services that should return avalid JSON response. In the following section, we will describe all required functionality.

## Domain Model
Our  system  consists  of  several  entities  with  the  most  basic  being  the account, store,  store  category, product, productcategory, and of course orders. You are free to create whatever domain class you think is appropriate and include whatever attributes perdomain class. Remember that you should base the creation of your database schema on the entity classes that will be based on the domain classes.

## Generate Sample Data
Once you have concluded the domain model, you should generate some corresponding sample datato feed the services under development. You are free to use whatever functionality Spring framework offers for this purpose.

## Business Requirements
The web application's user, after initial registration, should be able to
* Search for the desired store, either by name or by category.
* Add one or more items from the store's menu to the order.
* Create an order containing items only from the same store.
* In case we change to another storeand add one of its items, the order should be clearedbefore adding the new item(s).
* Retrieve all placed orders.
* List of the most famous stores in general and per category.
* List of the 10 most popular products to order.


# Non-functional Requirements

## Software Design
All functionality should be implementedby following the practices covered during the sessions. You should make use of interfaces and abstract classes wherever it seems appropriate and use proper java packaging nomenclature.

## Performance
When it comes to performance, all calls should have a maximum response time of 200milliseconds.

## Logging
There should be a well-defined logging policy maintaining all information considered mandatory to be able to trace user activity and debug erroneous calls. By logging policy, we are referring to the definition of the logging level per specific functionality, potentially more than one log file along with a clear rotation policy.

## Software Quality
When it comes to the quality of the implementing product, we need to make sure every call should always return  a  valid  JSON  document  including  the  cases  where  something  went  wrong,  due  to  either a development bug or system reasons. The end-user should not see default error pages. Depending on the type of the call(CRUD actions), the proper HTTP code should be alwaysreturned:
* 200 OK
* 201 Created
* 202 Accepted
* 204 No Content
* 400 Bad Request
* 401 Unauthorized
* 403 Forbidden
* 404 Not Found
* 500 Internal Server Error
As far as the quality of the source code is concerned, you should utilize any type of formatting rulesyou consider appropriate and indicative of your coding style.
