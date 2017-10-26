# Assignment 5
## Requirements & Realization

1. A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).

     *  Since this is the first requirement we establish many of the necessary classes here. For example, we make a class **GroceryList** which will also lead to the creation of the class called **Item**. **User** will obviously become a class as well. In this statement, we also see the need to establish methods _add_item_, _delete_item_, and _change_quantity_ which belong to the GroceryList class. The Item class will also get the attribute itemQuantity.
     
     
2. The application must contain a database (DB) of items and corresponding item types. 

    *  We will create a class called **ItemDatabase** that will contain the attributes itemName and itemType. These attributes will also be added to the Item class. We assume that the database is the user's personal database. 
    

3. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.

    * Since we have the ItemDatabase, rather than establishing another class we utilize this one. We create a method called _specify_Item_inDb()_. This method will be put in the GroceryList class, as the user can then add this item to their list and then specify the quantity.  


4. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.

   *  This whole statement sounds overall like specifications for a method. Therefore, we add the method _search_inDB()_ also for the GroceryList class. The user will be able to create a new a new item  if necessary, using the function _add_toDB()_, which then adds the item to the database. When implementing, we can make it so that _add_toDB()_ is only evoked by _search_inDB()_. 


5. Lists must be saved automatically and immediately after they are modified.
   *  This seems like something that should be explicitly done anyway, and therefore, we do not need to add anything further to the class diagram with respect to this statement. 


6. Users must be able to check off items in a list (without deleting them).
 
   *  As this is different from deleting items, a method called _check_off()_ will be added to Item. In addition, a Boolean attribute checkedOff will indicate if the item has been marked with a check or not. 


7. Users must also be able to clear all the check-off marks in a list at once.
 
   * This sounds like a method in itself, so we have a method called _clear_checks()_ added to the GroceryList, as it modifies the list. 


8. Check-off marks for a list are persistent and must also be saved immediately.

   *  This sounds like something that should be explicitly done, and like with statement 5, we do not do anything further with the class diagram with respect to this statement. 


9. The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth between aisles).

   *  To accomplish this task, we could modify the add_item() method present in GroceryList so that it displays both the type and the name of the item, and adds the item into the correct place in the list. 


10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists.

    *  Here, we create methods for users called _create_list()_, _rename_list()_, _select_list()_, and _delete_list()_. Because of this aspect, we must add the attribute listName to the class GroceryList so that lists can be differentiated. 


11. The User Interface (UI) must be intuitive and responsive.

    *  As this statement conveys nothing about the style or format of the class diagram, we disregard it and make no changes to the diagram. 
    
