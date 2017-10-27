# Assignment 5


### Requirement 1

1. A grocery list consists of items the users want to buy at a grocery store. The application
must allow users to add items to a list, delete items from a list, and change the quantity
of items in the list (e.g., change from one to two pounds of apples).

I added class User with attributes 

	names 
	userID (there can be multiple users with the same name) 
	numberOfLists (since a user can have zero or more lists)

In addition, I added a Grocery List class which contains attributes 
	
	listName (name of the particular grocery list)
	itemQuantity (how many of said items)

and methods
	
	addItems 
	deleteItems
	updateQuantity

### Requirement 2

2. The application must contain a database (DB) of items and corresponding item types .

I created a class Database which uses contents from classes created at requirement 3.


### Requirement 3

3. Users must be able to add items to a list by picking them from a hierarchical list, where
the first level is the item type (e.g., cereal), and the second level is the name of the
actual item (e.g., shredded wheat). After adding an item, users must be able to specify a
quantity for that item.

I created two classes, Class ItemType and class Item.
This way in order for the user to add items to a list the user must identify the type of item before being able to select the actual item (identified by name).
 

### Requirement 4

4. Users must also be able to specify an item by typing its name. In this case, the
application must look in its DB for items with similar names and ask the users, for each
of them, whether that is the item they intended to add. If a match cannot be found, the
application must ask the user to select a type for the item and then save the new item,
together with its type, in its DB.

Under Class Database, I included the following:

	Attributes:
		-matchFound:bool

	Methods:
		+searchItem() 
		+searchSimilarNames()


### Requirement 5

5. Lists must be saved automatically and immediately after they are modified.

Not realized in a class diagram.  
Can be realized in an activity / use case diagram 

### Requirement 6

6. Users must be able to check off items in a list (without deleting them).

I added an attribute called checkbox:bool and a method called checkOff()

### Requirement 7

7. Users must also be able to clear all the check-off marks in a list at once.

I included a method called clearAllCheckOff() under the 
Class Grocery List.

### Requirement 8

8. Check-off marks for a list are persistent and must also be saved immediately.

Not realized in a class diagram.  
Can be realized in an activity diagram 

### Requirement 9

9. The application must present the items in a list grouped by type, so as to allow users to
shop for a specific type of products at once (i.e., without having to go back and forth
between aisles).

I added a method called displaySimilarProducts() under Class ItemType

### Requirement 10

10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly
farmer’s market list”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete lists.

I included the following methods to class User:
	+selectList()	// Selects a list
	+createList() 	// Creates a new list
	+deleteList()	// Deletes a list
	+renameList()	// Renames a list


### Requirement 11
11. The User Interface (UI) must be intuitive and responsive.

Not considered because it does not affect the design directly.