package glm.seclass.qc.edu.glm;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button createList;
    Button browse;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createList = findViewById(R.id.createList);
        browse = findViewById(R.id.browse);

        GLDatabase db = GLDatabase.getAppDatabase(this);

//        This commented part is how to create new item
//        creating tuples for grocery list should be similar to this

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


//      this part is supposed to prompt EditText field
        final LinearLayout scrollView = (LinearLayout) findViewById(R.id.MainLayout);

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
                                        Button newList = new Button(context);
                                        newList.setText(userInput.getText());
                                        scrollView.addView(newList);
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
    }
}

