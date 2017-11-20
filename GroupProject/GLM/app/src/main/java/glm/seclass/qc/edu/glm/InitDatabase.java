package glm.seclass.qc.edu.glm;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by Lin on 11/15/17.
 */

public class InitDatabase extends Application {

    private static GLDatabase db;

    private InitDatabase() {
    }

    public static void create(Context myContext) {
        if (db == null) {
            db = Room.databaseBuilder(myContext.getApplicationContext(),
                    GLDatabase.class, "grocerylist-database").allowMainThreadQueries().build();
            populateDB();
        }
    }

    public static void destroy(Context myContext) {
        db = null;
        myContext.deleteDatabase("grocerylist-database");
    }

    public static GLDatabase getDB() {
        return db;
    }

    private static void populateDB() {
        db.groceryListDAO().insert(new GroceryList("Test List"));

        ItemType drinks = new ItemType("Drink" , "Ounce");
        ItemType fruits = new ItemType("Fruit" , "Ounce");
        ItemType meat = new ItemType("Meat" , "Ounce");
        List<ItemType> listOfTypes = new ArrayList<>();
        listOfTypes.add(drinks);
        listOfTypes.add(fruits);
        listOfTypes.add(meat);
        long[] typeID = db.itemTypeDAO().insert(listOfTypes.get(0) , listOfTypes.get(1) ,listOfTypes.get(2) );


        String[] drinksAry = {"Sprite" , "Coke" , "Pepsi" , "Fanta" , "Vitamin Water" , "Gatorade" , "Mountain Dew",
                                "Orange Juice" , "Water" , "Beer"};
        String[] fruitsAry = {"Apple" , "Orange" , "Banana" , "Tangerine" , "Lemon" , "Mango" , "Watermelon",
                "Raspberries" , "Grapefruit" , "Peach"};
        String[] meatAry = {"Beef" , "Steak" , "Chicken" , "Bacon" , "Turkey" , "Ham" , "Pepperoni" , "Spam",
                            "Hotdog" , "Meatball"};
        List<Item> listOfItems = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++ ){
            listOfItems.add(new Item(drinksAry[i] , (int)typeID[0]));
            listOfItems.add(new Item(fruitsAry[i] , (int)typeID[1]));
            listOfItems.add(new Item(meatAry[i] , (int)typeID[2]));
        }

        db.itemDAO().insertAll(listOfItems);
    }
}

//            this is for adding items to the first time the database is created so that users
//            can add items from heirchical list
//            this is still work in progress

//            String [] items = new String[]{ "Pineapple", "Apple", "Pen Pineapple Apple Pen", "Eggs", "Bacon",
//                    "Banana", "Coconut","Durian", "Eggfruit", "Fig", "Grapefruit",
//                    "Honeydew Melon", "Indian Fig", "Jackfruit", "Kiwi", "Lemon", "Mango", "Nectarine",
//                    "Peach", "Quince", "Raspberries", "Strawberries", "Tomato", "Ugni", "Watermelon" };
//
//
//            Log.e("tag", "before item creation");
//            for (int i = 0; i < items.length; i++){
//                Log.e("tag", "here! "+items[i]);
//                Item newItem = new Item();
//                Log.e("tag", "here! 1");
//                newItem.setItemName(items[i]);
//                Log.e("tag", "here! 2");
//                newItem.setTypeName("food");
//                Log.e("tag", "here! 3");
//                INSTANCE.itemDAO().insert(newItem);
//                Log.e("tag", "here! 4");
//            }
//            Log.e("tag", "after item creation");
