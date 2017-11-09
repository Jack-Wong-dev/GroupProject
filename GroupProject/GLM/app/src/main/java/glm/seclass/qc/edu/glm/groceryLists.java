package glm.seclass.qc.edu.glm;

/**
 * Created by Lin on 11/9/17.
 */
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;

public class groceryLists {

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "image_url")
    private String imageUrl;

    // getters and setters
}
