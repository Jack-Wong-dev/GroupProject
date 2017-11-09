package glm.seclass.qc.edu.glm;

/**
 * Created by Lin on 11/9/17.
 */
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;

@Entity
public class Item {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "itemName")

    private String itemName;

    @ColumnInfo(name = "typeName")
    private String typeName;

    void setItemName(String itemName){
        this.itemName = itemName;
    }

    void setTypeName(String typeName){
        this.typeName = typeName;
    }

    String getItemName(){
        return itemName;
    }

    String getTypeName(){
        return typeName;
    }

}
