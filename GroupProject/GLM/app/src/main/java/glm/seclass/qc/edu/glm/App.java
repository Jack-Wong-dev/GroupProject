package glm.seclass.qc.edu.glm;

import android.app.Application;
import android.arch.persistence.room.Room;

import glm.seclass.qc.edu.glm.AppDatabase;

/**
 * Created by Lin on 11/9/17.
 */

public class App extends Application{

    public static App INSTANCE;
    private AppDatabase database;

    public static App get() {
        return INSTANCE;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "glDB").build();
        INSTANCE = this;
    }

    public AppDatabase getDB() {
        return database;
    }
}
