package glm.seclass.qc.edu.glm;

/**
 * Created by Lin on 11/9/17.
 */
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"itemName"})
public class Item {
    @NonNull
    private String itemName;

    private String typeName;

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public void setTypeName(String typeName){
        this.typeName = typeName;
    }

    public String getItemName(){
        return itemName;
    }

    public String getTypeName(){
        return typeName;
    }

}
