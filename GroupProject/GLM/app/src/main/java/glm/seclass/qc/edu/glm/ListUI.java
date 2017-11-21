package glm.seclass.qc.edu.glm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Lin on 11/21/17.
 */

public class ListUI extends AppCompatActivity {
    Button addItem;
    Button deleteThisList;
    LinearLayout scrollView;
    MyTasks myTasks;
    String listName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        addItem = findViewById(R.id.add_btn);
        deleteThisList = findViewById(R.id.delete_btn);
        scrollView = findViewById(R.id.ListLayout);
        myTasks = new MyTasks(this);
//        Bundle bundle = getIntent().getExtras();
//        List<ListToItem> listToItem = myTasks.getListItems(bundle.getString("thisListName"));
//        for(int i = 0; i < listToItem.size(); i++){
//            LinearLayout horizontalLL = new LinearLayout(this);
//            horizontalLL.setOrientation(LinearLayout.HORIZONTAL);
//
//            CheckBox cb = new CheckBox(this);
//            horizontalLL.addView(cb);
//            String itemName = myTasks.getItem(listToItem.get(i).getItemId());
//            TextView textViewName = new TextView(this);
//            textViewName.setText(itemName);
//            horizontalLL.addView(textViewName);
//            EditText editTextNumber = new EditText(this);
//            editTextNumber
//
//            horizontalLL.addView(textViewName);
//
//        }
    }
}
