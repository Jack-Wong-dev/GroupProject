package glm.seclass.qc.edu.glm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by Lin on 11/22/17.
 */

public class UIType extends AppCompatActivity{

    String listName;
    String typeName;
    MyTasks myTasks;
    Context context = this;
    LinearLayout llTypes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_view);
        Log.e("tag", "UIType Oncreate");
        Log.e("tag", "error after context");
        Bundle bundle = getIntent().getExtras();
        Log.e("tag", "error after bundle");
        listName = bundle.getString("thisListName");
        llTypes = findViewById(R.id.TypeLayout);
        Log.e("tag", "error before findview");
        Log.e("tag", "before get all item types");
        List<ItemType> allTypes = myTasks.getAllTypes();
        Log.e("tag", "error after getting alltypes");
        if (allTypes == null){
            Log.e("tag", "null in UIType");
            return;
        }
        for(int i = 0; i < allTypes.size(); i++){
            Log.e("tag", "made it to for loop");
            Button itemTypeButton = new Button(this);
            Log.e("tag", "made it to for loop");
            itemTypeButton.setText(allTypes.get(i).getItemType());
            Log.e("tag", "made it to for loop");
            llTypes.addView(itemTypeButton);
            Log.e("tag", "made it to for loop");
            itemTypeButton.setOnClickListener(itemsInType(itemTypeButton));
        }
    }

    View.OnClickListener itemsInType(final Button button)  {
        return new View.OnClickListener() {
            public void onClick(View v) {
                Intent ItemInTypeScreenIntent = new Intent(context, UIItemsInType.class);
                ItemInTypeScreenIntent.putExtra("thisListName", listName);
                ItemInTypeScreenIntent.putExtra("thisTypeName", button.getText().toString());
                startActivity(ItemInTypeScreenIntent);
                finish();
            }
        };
    }
}
