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
        }
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
        myContext.deleteDatabase("grocerylist-database");
    }
}
