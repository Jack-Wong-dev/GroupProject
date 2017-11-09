package glm.seclass.qc.edu.glm;

/**
 * Created by Lin on 11/9/17.
 */
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;

@Entity
public class item {

<<<<<<< HEAD
    @PrimaryKey(autoGenerate = false)
=======
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "itemName")
>>>>>>> 69c193ac46c4f39301182471bd6383a61ffdd04e
    private String itemName;

    @ColumnInfo(name = "typeName")
    private String typeName;

    // getters and setters

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
