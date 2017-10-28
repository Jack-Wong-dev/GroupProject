Assignment 5

1. A grocery list consists of items the users want to buy at a grocery store. The application
must allow users to add items to a list, delete items from a list, and change the quantity
of items in the list (e.g., change from one to two pounds of apples).

The list class provides methods for adding, and deleting items, and also for changing the quantity of items. Items have a class of its own, with fields being its type and its name

2. The application must contain a database (DB) of items and corresponding item types.

Not considered because it doesn’t affect the design directly

3. Users must be able to add items to a list by picking them from a hierarchical list, where
the first level is the item type (e.g., cereal), and the second level is the name of the
actual item (e.g., shredded wheat). After adding an item, users must be able to specify a
quantity for that item.

This is more front end and doesn’t affect the design directly

4. Users must also be able to specify an item by typing its name. In this case, the
application must look in its DB for items with similar names and ask the users, for each
of them, whether that is the item they intended to add. If a match cannot be found, the
application must ask the user to select a type for the item and then save the new item,
together with its type, in its DB.

We have a search method within user class that takes care of this. Search connects the user class with the product name class, and for each product name there can be multiple items, thus the one to many relationship between product name and the item.

5. Lists must be saved automatically and immediately after they are modified.

This doesn’t affect our design.

6. Users must be able to check off items in a list (without deleting them).

Lists have  a method called check.

7. Users must also be able to clear all the check-off marks in a list at once.

Lists have a method called checkAll.

8. Check-off marks for a list are persistent and must also be saved immediately.

This will be implemented within the check and checkall methods.

9. The application must present the items in a list grouped by type, so as to allow users to
shop for a specific type of products at once (i.e., without having to go back and forth
between aisles).

We have the group method within the list class.

10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly
farmer’s market list”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete lists.

Users controls the lists they have, and has select, rename, create, and delete lists. 

11. The User Interface (UI) must be intuitive and responsive.

This doesn’t affect our design.
