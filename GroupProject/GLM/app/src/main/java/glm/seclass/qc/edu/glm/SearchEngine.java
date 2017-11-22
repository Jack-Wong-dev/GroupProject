package glm.seclass.qc.edu.glm;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
public class SearchEngine extends AppCompatActivity {

    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;
    MyTasks myTasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_engine);
        listView = (ListView) findViewById(R.id.listview);
        editText = (EditText) findViewById(R.id.txtsearch);
        initList();
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
    }
    public void searchItem(String textToSearch){
        String[] arr = new String[listItems.size()];
        arr = listItems.toArray(arr);
        for(String item:arr){
            if(!item.toLowerCase().contains(textToSearch.toString().toLowerCase())){
                listItems.remove(item);
            }
        }

        adapter.notifyDataSetChanged();
    }
    public void initList(){
        myTasks = new MyTasks(this);

        List<Item> itemList = myTasks.getItems();

        listItems = new ArrayList<>();
        for(int i = 0; i < itemList.size() ; i++ ){
            listItems.add(itemList.get(i).getItemName());
        }

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, listItems);
        listView.setAdapter(adapter);

    }
}