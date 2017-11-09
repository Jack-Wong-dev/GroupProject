package glm.seclass.qc.edu.glm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List <Item> list = new ArrayList<>();
        Item newitem = new Item();
        newitem.setItemName("Cheerios");
        newitem.setTypeName("Cereal");
        App.get().getDB().groceryListDAO().insertAll(list);
    }
}

