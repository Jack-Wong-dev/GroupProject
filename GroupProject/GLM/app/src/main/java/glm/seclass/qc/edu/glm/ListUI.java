package glm.seclass.qc.edu.glm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lin on 11/21/17.
 */

public class ListUI extends AppCompatActivity {
    Button addItem;
    Button deleteThisList;
    LinearLayout scrollView;
    MyTasks myTasks;
    String listName;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        addItem = findViewById(R.id.add_btn);
        deleteThisList = findViewById(R.id.delete_btn);
        scrollView = findViewById(R.id.ListLayout);
//        myTasks = new MyTasks(this);
        Bundle bundle = getIntent().getExtras();
        Log.e("some tag", "messege here");
        listName = bundle.getString("thisListName");
        Log.e("some tag", "list name is" + listName);
        title = findViewById(R.id.listname);
        title.setText(listName);
        Log.e("some tag", "messege here again again");

        //At the moment the items in list does not persist
        //but this is because its repopulating with same type id which fails the unique constraint
        myTasks.populateList(listName);
        List<ListToItem> listToItem = myTasks.getListItems(listName);

        for(int i = 0; i < listToItem.size(); i++){
            Log.e("somewhere", "over");
            LinearLayout horizontalLL = new LinearLayout(this);
            horizontalLL.setOrientation(LinearLayout.HORIZONTAL);

            CheckBox cb = new CheckBox(this);
            horizontalLL.addView(cb);

            Log.e("the", "rainbow");
            String itemName = myTasks.getItem(listToItem.get(i).getItemId());
            TextView textViewName = new TextView(this);
            textViewName.setText(itemName);
            horizontalLL.addView(textViewName);

            Log.e("is", "a");
            EditText editTextQuantity = new EditText(this);
            horizontalLL.addView(editTextQuantity);

            Log.e("answer", "to why its crashing");
            Button deleteItem = new Button(this);
            deleteItem.setText("X");
            horizontalLL.addView(deleteItem);
            scrollView.addView(horizontalLL);
        }
    }
}
