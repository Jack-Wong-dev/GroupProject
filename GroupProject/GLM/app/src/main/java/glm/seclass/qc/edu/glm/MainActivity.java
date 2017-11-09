package glm.seclass.qc.edu.glm;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import glm.seclass.qc.edu.glm.AppDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase database = null;
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "AppDatabase").build();
    }
}

