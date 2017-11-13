package glm.seclass.qc.edu.glm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GLDatabase db = GLDatabase.getAppDatabase(this);

        Item newitem = new Item();
        newitem.setItemName("Cheerios");
        newitem.setTypeName("Cereal");
        db.itemDAO().insert(newitem);

        List<Item> example = db.itemDAO().getAllTypes();

        for(int i = 0; i < example.size(); i++) {
            Log.e("items number " + i, example.get(i).getItemName() + " " + example.get(i).getTypeName());
        }
    }
}

