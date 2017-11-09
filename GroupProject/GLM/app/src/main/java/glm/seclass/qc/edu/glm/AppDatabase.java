package glm.seclass.qc.edu.glm;

/**
 * Created by don on 11/9/17.
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
