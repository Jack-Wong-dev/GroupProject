package glm.seclass.qc.edu.glm;

/**
 * Created by Lin on 11/9/17.
 */
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;

@Entity
public class GroceryListsTable {

    @PrimaryKey(autoGenerate = true)
    private int listID;

    @ColumnInfo(name = "checkMark")
    private boolean checkMark;

    @ColumnInfo(name = "listName")
    private String listName;

    @ColumnInfo(name = "itemName")
    private String itemName;

    @ColumnInfo(name = "quantity")
    private  int quantity;

    @ColumnInfo(name = "itemType")
    private String itemType;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

}
