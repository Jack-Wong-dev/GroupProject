package glm.seclass.qc.edu.glm;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.List;

/**
 * Created by Lin on 11/21/17.
 */



public class UIList extends AppCompatActivity {





     FloatingActionMenu materialDesignFAM;
    FloatingActionButton addItem;
    FloatingActionButton deleteThisList;
    FloatingActionButton searchForItem;



//    Button addItem;
//    Button deleteThisList;
//    Button searchForItem;
    LinearLayout llList;
    MyTasks myTasks;
    String listName;
    TextView title;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);

        addItem = (FloatingActionButton) findViewById(R.id.add_btn);
        deleteThisList = (FloatingActionButton) findViewById(R.id.delete_btn);
        llList = findViewById(R.id.ListLayout);
        title = findViewById(R.id.listname);

        Bundle bundle = getIntent().getExtras();

        listName = bundle.getString("thisListName");
        title.setText(listName);
        update();

        addItem.setOnClickListener(displayTypeScreen(addItem));

        deleteThisList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTasks.deleteList(listName);
                setResult(1);
                finish();
            }
        });
        searchForItem = findViewById(R.id.search_btn);
        searchForItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent searchEngine = new Intent(context , SearchEngine.class);
                searchEngine.putExtra("listName" , listName);

                startActivityForResult(searchEngine , 1);
            }
        });
    }
//    displays type view from add button
    View.OnClickListener displayTypeScreen(final FloatingActionButton button)  {
        return new View.OnClickListener() {
            public void onClick(View v) {
                Intent showTypeView = new Intent(context, UIType.class);
                showTypeView.putExtra("thisListName", listName);
                startActivityForResult(showTypeView, 1);
            }
        };
    }



    // this function updates the items in the list
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1) {
            update();
        }
    }

    public void update(){

        llList.removeAllViews();

        List<ListToItem> listToItem = myTasks.getListItems(listName);

        for(int i = 0; i < listToItem.size(); i++){

            LinearLayout horizontalLL = new LinearLayout(this);
            horizontalLL.setOrientation(LinearLayout.HORIZONTAL);

            CheckBox cb = new CheckBox(this);
            horizontalLL.addView(cb);

            final String itemName = myTasks.getItem(listToItem.get(i).getItemId());
            TextView textViewName = new TextView(this);
            textViewName.setText(itemName);
            horizontalLL.addView(textViewName);

            EditText editTextQuantity = new EditText(this);
            horizontalLL.addView(editTextQuantity);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER_HORIZONTAL);

            // Button Generated Dynamically
            Button deleteItem = new Button(this);
            deleteItem.setText("Delete");
            deleteItem.setTextColor(Color.WHITE);
            deleteItem.setBackgroundColor(Color.parseColor("#FFC0CB"));
            deleteItem.setLayoutParams(params);


            deleteItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myTasks.deleteItemFromList(listName, itemName);
                    update();
                }
            });
            horizontalLL.addView(deleteItem);

            llList.addView(horizontalLL);

        }
    }
}


