package glm.seclass.qc.edu.glm;

/**
 * Created by Lin on 11/9/17.
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Item.class, parentColumns = "itemName", childColumns = "itemName"))
public class GroceryListsTable {

    @PrimaryKey(autoGenerate = true)
    private int glID;
    private int quantity;
    private boolean checkMark;
    private String listName;
    private String itemName;
    private String itemType;

    public int getGlID() {
        return glID;
    }

    public void setGlID(int glID) {
        this.glID = glID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isCheckMark() {
        return checkMark;
    }

    public void setCheckMark(boolean checkMark) {
        this.checkMark = checkMark;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
