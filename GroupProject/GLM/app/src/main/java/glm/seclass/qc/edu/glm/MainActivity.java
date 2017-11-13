package glm.seclass.qc.edu.glm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

//    final Button createList = findViewById(R.id.createList);
//    final Button browse = findViewById(R.id.browse);
//    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

//        createList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LayoutInflater layoutInflater = LayoutInflater.from(context);
//                View promptsView = layoutInflater.inflate(R.layout.activity_main, null);
//                AlertDialog.Builder alert = new AlertDialog.Builder(context);
//                alert.setView(promptsView);
//                final EditText userInput = (EditText) promptsView.findViewById(R.id.newListName);
//                alert.setCancelable(false).setPositiveButton("Create",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        }).setNegativeButton("Cancel", )
//            }
//        });
    }
}

