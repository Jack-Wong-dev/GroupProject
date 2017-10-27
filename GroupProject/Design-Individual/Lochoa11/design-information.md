1. A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).

	To handle this requirement I designed a class called List Class that will hold the list of items, users that will be able to create one or more lists. Also added a class called items to signify the items.

2. The application must contain a database (DB) of items and corresponding item types.
	
	Not considered because it does not affect the design directly.

3. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.
	
	To handle this I added a class called Hierarchical List Class that hold the types which each point to a set of items

4. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.

	To search for a similar name I put a function that will do this job in the user class 

5. Lists must be saved automatically and immediately after they are modified.

	Considered as the List Class

6. Users must be able to check off items in a list (without deleting them).

	To handle this I made an attribute to the item class called checkedOff so that when added to list the list class can change the boolean to true when checked off.

7. Users must also be able to clear all the check-off marks in a list at once.
	
	To handle this I added a function called clearAllCheckedOff so that the class can 	

8. Check-off marks for a list are persistent and must also be saved immediately.
	
	already considered in the items Class

9. The application must present the items in a list grouped by type, so as to allow users to
shop for a specific type of products at once (i.e., without having to go back and forth
between aisles).
	
	to handle this there is a function in List Class that will group items by type

10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly
farmer’s market list”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete lists.
	
	To handle this there is a Users Class

11. The User Interface (UI) must be intuitive and responsive.

	not considered because this does not affect the design of the software
