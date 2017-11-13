package glm.seclass.qc.edu.glm;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

/**
 * Created by Lin on 11/13/17.
 */
@Entity(primaryKeys = {"listName"})
public class GroceryListNames {

    @NonNull
    private String listName;

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
