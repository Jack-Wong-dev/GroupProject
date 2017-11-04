# Design Document

**Author**: <Team 5> 

## 1 Design Considerations

### 1.1 Assumptions


The software GroceryListManager was sponsored by Brad and Janet; the purpose of this application is to allow users to develop their own grocery lists to utilize when shopping, replacing lists made with pen and paper. 

With regard to the software, we assume that there is enough space on the device carrying the application for it to be stored and run without issue. We also assume that each user of the application will have their own particular set of grocery lists; rather than having a log-in, the installation of the application will allow the user to have a space exclusive to the user for him or her to produce their own grocery lists. 

The software has no dependencies thus far, but must operate on environments that are at least API Level 21. 


### 1.2 Constraints

One of the requirements of provided states that the users must be able to add items to the database; though not exactly a constraint, it requires that the system's database be modifiable and up-to-date with what the user has specified. The application also asks that the user be able to have multiple lists at any time; therefore, the system must support the storage of multiple user lists. Developmentally, the system will be designed with Android Studio. 

### 1.3 System Environment

As stated above, the system must be able to operate on phones that are at least API Level 21, which corresponds to Android 5.0. An example device that runs Android 5.0 would be the Nexus 6, which features a resolution of 2560x1440 pixels and 3GM of RAM. 

## 2 Architectural Design

*The architecture provides the high-level design view of a system and provides a basis for more detailed design work. These subsections describe the top-level components of the system you are building and their relationships.*

### 2.1 Component Diagram

*This section should provide and describe a diagram that shows the various components and how they are connected. This diagram shows the logical/functional components of the system, where each component represents a cluster of related functionality. In the case of simple systems, where there is a single component, this diagram may be unnecessary; in these cases, simply state so and concisely state why.*

### 2.2 Deployment Diagram

*This section should describe how the different components will be deployed on actual hardware devices. Similar to the previous subsection, this diagram may be unnecessary for simple systems; in these cases, simply state so and concisely state why.*

### 3 Low-Level Diagram

*Describe the low-level design for each of the system components identified in the previous section. For each component, you should provide the details in the following UML diagrams to show its internal structure.*

### 3.1 Class Diagram

<object data="Design-Team/design-team.pdf" type="application/pdf" width="800px" height="1000px">
<a href="Design-Team/design-team.pdf">Design-Team/design-team.pdf</a></object>

### 3.2 Other Diagrams

*<u>Optionally</u>, you can decide to describe some dynamic aspects of your system using one or more behavioral diagrams, such as sequence and state diagrams.*

## 4 User Interface Diagram
*For GUI-based systems, this section should provide the specific format/layout of the user interface of the system (e.g., in the form of graphical mockups).*
