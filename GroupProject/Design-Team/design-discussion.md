# Design Discussion


### Pros & Cons Individual Designs 

Design 1(Jack): 

Pros: 
One of the main pros of Design 1 was that it came up with the idea of having ItemType as its own class; this class was related to Item. In this way it accounted for requirement three by having type specified as a first level. 

Cons:
Possibly the inclusion of the attribute of ItemPrice, as the user might be going to different stores for their shopping list, as well as the possibility of the price at one particular store changing at some point. 

Design 2 (Don):
Pros: 
The diagram groups methods succinctly.

Cons:
This diagram doesn’t account for some attributes necessary to methods, such as the item quantity. It doesn’t account for certain aspects of the design, like hierarchical lists. 


Design 3 (Lin):
Pros: 
The diagram is detailed, and accounts for the parameters that would be passed into methods such as ItemID for the addItem method. 

Cons:
Possibly how the Hierarchical List Class was established, only in that the List class does not interact with the Hierarchical List Class directly. 

Design 4(Jessica): 
Pros: 
The diagram lists an addtoDB method for the user to develop their database. 

Cons:
It does not definitively establish levels between the itemType and itemName for the use of the third requirement. 

### Team Design:

With regards to the team design, many of the features in the agreed upon design mirror those classes, features and methods listed in each team member’s individual design. For example, everyone agreed upon basic classes like User and List. Many of the methods listed in each individual design were kept in place as well, such as those methods that pertained to creating or deleting a list. This new UML features an aspect taken from Design 1 that was not present in the other three designs; the use of an ItemTypes class that dominates over the ItemNode class. In this way, our design handles the specifications of requirement three from the list of requirements; ItemType as a first level, and then the actual item can be selected. 

The new design also produces features not previously listed in any of the individual designs. One example of this is the searchForList featured in the User class. This method would allow the user to search through multiple lists if they so choose; the total number of lists they have is kept in the attribute listNum. In addition, we also added an attribute, totalItemCount, to the List class, in order for the user to know how many items they have on their grocery list altogether. 

### Summary:

The process of creating a UML diagram is not to be underestimated; one must take into account how to place different attributes and methods, and determine if the relationships established between created classes makes sense. However, working with a team allows one to see the requirements in a different light, and understand different ways of looking at the problem by comparing individual diagrams and discussing them. We can incorporate the different solutions they have made, such as creating a hierarchy between classes from Design 1. Finally, discussion also lead to the creation of new methods and attributes that would be useful for the user.
