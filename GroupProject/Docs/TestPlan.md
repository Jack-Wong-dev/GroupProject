# Test Plan

*This is the template for your test plan. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

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

| Test                    | Are                     | Cool            |
| -------------           |:-------------:          | -----:          |
| col 3 is                | right-aligned           | $1600           |
| col 2 is                | centered                |   $12           |
| zebra stripes           | are neat                |    $1           |

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.*
