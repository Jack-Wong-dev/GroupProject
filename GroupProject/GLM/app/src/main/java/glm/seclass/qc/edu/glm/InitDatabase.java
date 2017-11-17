package glm.seclass.qc.edu.glm;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

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
        }
    }

    public static void destroy(Context myContext) {
        db = null;
        myContext.deleteDatabase("grocerylist-database");
    }

    public static GLDatabase getDB() {
        return db;
    }

    public static void populateDB() {
        db.groceryListDAO().insert(new GroceryList("Test List"));
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
