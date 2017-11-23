package glm.seclass.qc.edu.glm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lin on 11/21/17.
 */

public class UIList extends AppCompatActivity {
    Button addItem;
    Button deleteThisList;
    Button searchForItem;
    LinearLayout llList;
    MyTasks myTasks;
    String listName;
    TextView title;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        addItem = findViewById(R.id.add_btn);
        deleteThisList = findViewById(R.id.delete_btn);
        llList = findViewById(R.id.ListLayout);
        llList.setFocusable(true);
        llList.setFocusableInTouchMode(true);
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
    View.OnClickListener displayTypeScreen(final Button button)  {
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

        final List<ListToItem> listToItem = myTasks.getListItems(listName);

        for(int i = 0; i < listToItem.size(); i++){

            LinearLayout horizontalLL = new LinearLayout(this);
            horizontalLL.setOrientation(LinearLayout.HORIZONTAL);

            CheckBox cb = new CheckBox(this);
            cb.setChecked(listToItem.get(i).getCheckedOff());
            cb.setOnClickListener(updateDB(cb, listToItem.get(i)));
            horizontalLL.addView(cb);

            final String itemName = myTasks.getItem(listToItem.get(i).getItemId());
            TextView textViewName = new TextView(this);
            textViewName.setText(itemName);
            horizontalLL.addView(textViewName);


            final EditText editTextQuantity = new EditText(this);
            editTextQuantity.setCursorVisible(false);
            editTextQuantity.setSelectAllOnFocus(true);
            editTextQuantity.setSelected(false);
            editTextQuantity.setInputType(InputType.TYPE_CLASS_NUMBER);
            editTextQuantity.setNextFocusUpId(llList.getId());
            editTextQuantity.getNextFocusUpId();
            editTextQuantity.setImeOptions(EditorInfo.IME_ACTION_DONE);
            editTextQuantity.setText("" +myTasks.getQty(listToItem.get(i)));

            final int j = i;
            editTextQuantity.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if(actionId == 6){
                        listToItem.get(j).setQuantity(Integer.parseInt(editTextQuantity.getText().toString()));
                        myTasks.setQty(listToItem.get(j));
                    }
                    return false;
                }
            });
            horizontalLL.addView(editTextQuantity);


            TextView textView = new TextView(this);
            Log.e("tag", itemName);
            textView.setText(myTasks.getMeasurement(itemName));
            horizontalLL.addView(textView);

            Button deleteItem = new Button(this);
            deleteItem.setText("X");
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
    View.OnClickListener updateDB(final CheckBox cb, final ListToItem listToItem){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listToItem.setCheckedOff(!listToItem.getCheckedOff());
                myTasks.check(listToItem);
            }
        };
    }
}


