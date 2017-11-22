package glm.seclass.qc.edu.glm;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class SearchEngine extends AppCompatActivity {
    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;
    MyTasks myTasks;
    String listName;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_engine);
        listView = (ListView) findViewById(R.id.listview);
        editText = (EditText) findViewById(R.id.txtsearch);
        initList();
        Bundle bundle = getIntent().getExtras();
        listName = bundle.getString("listName");
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (s.toString().equals("")) {
                    initList();
                } else {
                    //perform search
                    searchItem(s.toString());
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String itemName = (String) listView.getItemAtPosition(position);

                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setMessage("Add this item?");
                //final EditText userInput = (EditText) promptsView.findViewById(R.id.newListName);

                alert
                        .setCancelable(false)
                        .setPositiveButton("Enter",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        if(myTasks.itemIsInList(listName , itemName)){
                                            CharSequence text = "That Item already exists!";
                                            Log.e("SearchEngine" , "This item already exists");
                                            int duration = Toast.LENGTH_SHORT;
                                            Toast toast = Toast.makeText(context, text, duration);
                                            toast.show();
                                        } else{
                                            myTasks.insertToList(listName , itemName );
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
    }
    public void searchItem(String textToSearch){
        String[] arr = new String[listItems.size()];
        arr = listItems.toArray(arr);
        for(String item:arr){
            if(!item.toLowerCase().contains(textToSearch.toString().toLowerCase())){
                listItems.remove(item);
            }
        }
//        for(String item:listItems){
//            if(!item.toLowerCase().contains(textToSearch.toString().toLowerCase())){
//                listItems.remove(item);
//            }
//        }

        adapter.notifyDataSetChanged();
    }
    public void initList(){
//        items = new String[]{"Pen", "Pineapple", "Apple", "Pen Pineapple Apple Pen", "Eggs", "Bacon",
//                "Banana", "Coconut","Durian", "Eggfruit", "Fig", "Grapefruit",
//                "Honeydew Melon", "Indian Fig", "Jackfruit", "Kiwi", "Lemon", "Mango", "Nectarine",
//                "Peach", "Quince", "Raspberries", "Strawberries", "Tomato", "Ugni", "Watermelon" };
//        listItems= new ArrayList<>(Arrays.asList(items));
        myTasks = new MyTasks(this);
//
        List<Item> itemList = myTasks.getItems();

        listItems = new ArrayList<>();
        for(int i = 0; i < itemList.size() ; i++ ){
            listItems.add(itemList.get(i).getItemName());
        }
//
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, listItems);
        listView.setAdapter(adapter);

    }
}