package glm.seclass.qc.edu.glm;

/**
 * Created by Lin on 11/9/17.
 */
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;

public class groceryLists {

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

    // getters and setters
}
