package glm.seclass.qc.edu.glm;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {Item.class , GroceryListsTable.class}, version = 1)
public abstract class GLDatabase extends RoomDatabase {

    private static GLDatabase INSTANCE;
    public abstract GroceryListDAO groceryListDAO();
    public abstract ItemDAO itemDAO();

    public static GLDatabase getAppDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    GLDatabase.class, "grocerylist-database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }
}
