package glm.seclass.qc.edu.glm;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {Item.class , GroceryListsTable.class, GroceryListNames.class}, version = 1)
public abstract class GLDatabase extends RoomDatabase {

    private static GLDatabase INSTANCE;
    public abstract GroceryListsTableDAO groceryListDAO();
    public abstract ItemDAO itemDAO();
    public abstract  GroceryListNamesDAO groceryListNamesDAO();
    private static Context myContext;
    public static GLDatabase getAppDatabase(Context context){
        myContext = context;
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    GLDatabase.class, "grocerylist-database").allowMainThreadQueries().build();

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
        }
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
        myContext.deleteDatabase("grocerylist-database");
    }
}
