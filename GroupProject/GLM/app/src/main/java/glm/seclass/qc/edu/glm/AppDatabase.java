package glm.seclass.qc.edu.glm;

/**
 * Created by don on 11/9/17.
 */
import android.arch.persistence.room.*;


@Database(entities = {item.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GroceryListDAO userDao();
}
