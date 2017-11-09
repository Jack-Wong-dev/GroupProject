package glm.seclass.qc.edu.glm;

/**
 * Created by Lin on 11/9/17.
 */
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;

public class groceryLists {

<<<<<<< HEAD
    @ColumnInfo(name = "listName")
    private String listName;

    @ColumnInfo(name = "name")
    private String name;
=======
    @PrimaryKey(autoGenerate = true)
    private int listID;
>>>>>>> 349ab8fbdb6f3a0cb70f2ac53660f31c931a6777

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

    @ColumnInfo(name = "quantity")
    private String quantity;

    @ColumnInfo(name = "type")
    private String type;



    // getters and setters
}
