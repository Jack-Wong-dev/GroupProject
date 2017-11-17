package glm.seclass.qc.edu.glm;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Lin on 11/17/17.
 */
@Dao
public interface ItemAndTypeDao {
    @Query("SELECT * FROM Item i JOIN ItemType t ON i.type_id = t.type_id WHERE item_type = :itemType")
    List<ItemAndType> getAllItemsOfType(String itemType);
}
