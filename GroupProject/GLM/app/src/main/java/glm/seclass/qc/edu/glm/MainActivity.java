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
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button createList;
    Button browse;
    Button destroy;
    Context context = this;
    LinearLayout scrollView;
    GLDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        destroy = findViewById(R.id.destroyDB);
        createList = findViewById(R.id.createList);
        browse = findViewById(R.id.browse);

        db = GLDatabase.getAppDatabase(this);
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

        List<String> allList = db.groceryListNamesDAO().getAllLists();

        for(int i = 0; i < allList.size(); i++){
            Button button = new Button(context);
            button.setText(allList.get(i));
            scrollView.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

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
                                        String userText = userInput.getText().toString();
                                        GroceryListNames newListName = new GroceryListNames();
                                        newListName.setListName(userText);
                                        if(db.groceryListNamesDAO().find(userText) != null){
                                            CharSequence text = "That list already exists!";
                                            int duration = Toast.LENGTH_SHORT;
                                            Toast toast = Toast.makeText(context, text, duration);
                                            toast.show();
                                        }
                                        else{
                                            Button newList = new Button(context);
                                            newList.setText(userInput.getText());
                                            scrollView.addView(newList);
                                            db.groceryListNamesDAO().insert(newListName);
                                        }
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
                db.destroyInstance();
            }
        });

    }
    public void displaySearchScreen (View view){
        Intent search_intent = new Intent(this, SearchEngine.class);
        startActivity(search_intent);
    }

}

