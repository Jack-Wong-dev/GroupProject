package glm.seclass.qc.edu.glm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GLDatabase db = GLDatabase.getAppDatabase(this);

//        Item newitem = new Item();
//        newitem.setItemName("banana");
//        newitem.setTypeName("fruit");
//        db.itemDAO().insert(newitem);
//        Log.e("hello", "message");
//        List<String> example = db.itemDAO().getAllTypes();
//
//        for(int i = 0; i < example.size(); i++) {
//            Log.e("items number " + i, example.get(i));
//        }

    }
}

