package glm.seclass.qc.edu.glm;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by Lin on 11/15/17.
 */

public class InitDatabase{

    private static GLDatabase db;

    private InitDatabase() {
    }


    public static void create(Context myContext) {
        if (db == null) {
            db = Room.databaseBuilder(myContext.getApplicationContext(),
                    GLDatabase.class, "grocerylist-database").build();
        }
    }

    public static void destroy(Context myContext) {
        db = null;
        myContext.deleteDatabase("grocerylist-database");
    }

    public static GLDatabase getDB() {
        return db;
    }
}