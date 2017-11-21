package glm.seclass.qc.edu.glm;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyInterface {

    Button createList;
    Button search;
    Button destroy;
    Context context = this;
    LinearLayout scrollView;
    GLDatabase db;
    MyTasks myTasks;
    Boolean canCreate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        destroy = findViewById(R.id.destroyDB);
        createList = findViewById(R.id.createList);
        search = findViewById(R.id.search);

//        InitDatabase.create(context);

        myTasks = new MyTasks(this, this);
        myTasks.populateDB();
        myTasks.getLists();

//        db = InitDatabase.getDB();

//        Log.e("some tag", "after creating db");
//        This commented part is how to create new item
//        creating tuples for grocery list should be similar to this

//        Item newitem = new Item();
//           newitem.setItemName("banana");
//        newitem.setTypeName("fruit");
//        db.itemDAO().insert(newitem);
//        Log.e("hello", "message");
//        List<String> example = db.itemDAO().getAllTypes();
//
//        for(int i = 0; i < example.size(); i++) {
//            Log.e("items number " + i, example.get(i));
//        }

        scrollView = (LinearLayout) findViewById(R.id.MainLayout);

//        Log.e("some tag", "before Init.getlist");
//        List<GroceryList> groceryListsList = db.groceryListDAO().getAll();

//        Log.e("some tag", "after get items");
//        Log.e("some tag", "after initgetlist");
//        for(int i = 0; i < items.size(); i++){
//            Button button = new Button(context);
//            button.setText(items.get(i).getItemName());
//            scrollView.addView(button);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//        }

//      this part is supposed to prompt EditText field

        createList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View promptsView = layoutInflater.inflate(R.layout.prompt, null);

                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setView(promptsView);

                final EditText userInput = (EditText) promptsView.findViewById(R.id.newListName);

                alert
                        .setCancelable(false)
                        .setPositiveButton("Create",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
//                                        String userText = userInput.getText().toString();
//                                        GroceryList newListName = new GroceryList();
//                                        newListName.setListName(userText);
//                                        myTasks.insert(userText, "list");
//                                        if(!canCreate){
//                                            CharSequence text = "That list already exists!";
//                                            int duration = Toast.LENGTH_SHORT;
//                                            Toast toast = Toast.makeText(context, text, duration);
//                                            toast.show();
//                                        }
//                                        else{
//                                            Button newList = new Button(context);
//                                            newList.setText(userInput.getText());
//                                            scrollView.addView(newList);
////                                            db.groceryListDAO().insert(newListName);
//                                        }
                                    }
                        })
                        .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            }
                        );
                AlertDialog alertDialog = alert.create();
                alertDialog.show();
            }
        });
        destroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitDatabase.destroy(context);
            }
        });

    }
    public void displaySearchScreen (View view){
        Intent search_intent = new Intent(this, SearchEngine.class);
        startActivity(search_intent);
    }


    @Override
    public void displayListsToScrollView(List<GroceryList> lists) {
        for(int i = 0; i < lists.size(); i++){
            Button button = new Button(context);
            button.setText(lists.get(i).getListName());
            scrollView.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
    @Override
    public Boolean canCreate(Boolean found){
        if(found){
            canCreate = false;
        }
        else{
            canCreate = true;
        }
        return canCreate;
    }
}

