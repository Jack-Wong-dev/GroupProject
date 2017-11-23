# Test Plan

Author: Don Liu

## 1 Testing Strategy

### 1.1 Overall strategy

We will employ several different testing strategies, including unit, integration, system, and regression    
testing. Following an MVC format, unit tests using JUnit 4 will be written for a bulk of our methods from
within our model. Upon completion of each iteration of our project, we can perform a brief validation test,
to ensure that our design complies with that of our clients. Integration tests will then be performed. 
Whereas in unit tests where we test each module one by one, in integration tests we combine these unit tested
modules. Lastly, a system test is performed. A black box method is used, and methods as exploratory testing,
stress testing, graphical user interface testing, etc. This cycle is repeat for each iteration, but an 
additional regression test is performed to verify that the software which was previously developed or tested
still works accordingly. Unit tests, and integration tests should be performed by our Software Engineers. 
Validation tests, system tests, and regression tests should be performed by the Quality Assurance Engineer, 
and the Project Manager.


### 1.2 Test Selection

Unit tests and integration tests should be tested using white box techniques. Therefore, our Engineers, who
understand the internal workings of the project should perform these tests. System tests, validation tests,
and regression tests should be performed using black box techniques, because these tests are performed through
the perspective of the end user, who shouldn't know the inner workings of our project, these tests will be 
performed by our Quality Assurance Engineer, and our Project Manager.


### 1.3 Adequacy Criterion

We aim to achieve as much coverage as possible, both structually and functionally, in our given time. Not 
all methods should be subject to unit tests, but the larger methods or methods of greater importance should
have unit tests performed on. Integration tests should refer to our UML diagram and the relationships between
classes. Any two classes that are connected through relationships should contain intergrations tests. 
Validation tests are essential, and should be fully covered in terms of design criterias. System tests and 
regression tests should aim to cover all the design criterias, and to ensure proper functionality. 


### 1.4 Bug Tracking

Within our methods, we can catch Exceptions and output the location of the thrown exception, in the event of
an unexpected error.

### 1.5 Technology

We plan on using JUnit 4 for our structural tests. Manual testing, and Automation testing using Appium with
Selenium should be used for functional  tests. 

## 2 Test Cases

| ﻿test cases                 | purpose                                        | steps                                                                                              | actual result                    |
|----------------------------|------------------------------------------------|----------------------------------------------------------------------------------------------------|----------------------------------|
| create a list              | To see if users can create a list              | click on create a list                                                                             | works as expected                |
| search for a list          | To see if users can search for a list          | click on text field for list search, type in a list, and hit search                                | this feature was not implemented |
| select a list              | To see if users can select a list              | tap on a list                                                                                      | this works as expected           |
| rename a list              | To see if users can rename a list              | tap on a list, then tap rename                                                                     | this works as expected           |
| delete a list              | To see if users can delete a list              | tap on a list, then tap delete                                                                     | this works as expected           |
| search for an item by type | To see if users can search for an item by type | click on text field for item search, enter in an item, and click on search                         | this works as expected           |
| add item to list           | To see if users can add items to a list        | tap on a list, tap on add, enter in item, and click add                                            | this works as expected           |
| change item quantity       | To see if users can change item quality        | tap on a click, tap on change quality, enter quality, then tap change quality                      | this works as expected           |
| search for item by query   | To see if users can search for a item by query | select an item from list by tapping, tap add item to list, then tap search for item by query       | this works as expected           |
| select item from list      | To see if users can select item from list      | tap on a list, then tap on an item from list                                                       | this works as expected           |
| delete item                | To see if users can delete itemm               | tap on a list, tap on an item, then tap on delete                                                  | this works as expected           |
| add new item to database   | To see if users can add new items to database  | tap on a list, tap on add item, search item by query, enter item not in database, and add new item | this works as expected           |
| check off specific item    | To see if users can check off specific items   | tap on list, tap on item, tap on checkbox                                                          | this works as expected           |
| clear all checks           | To see if users can clear all checks           | tap on list, tap on clear all checks                                                               | this works as expected           |
| check off all              | To see if users can check off all              | tap on lists, tap on check off all                                                                 | this feature was not implemented |
