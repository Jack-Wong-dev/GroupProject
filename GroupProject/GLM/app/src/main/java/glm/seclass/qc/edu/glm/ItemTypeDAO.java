package glm.seclass.qc.edu.glm;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Lin on 11/15/17.
 */
@Dao
public interface ItemTypeDAO {

    @Query("SELECT * FROM ItemType")
    List<ItemType> getAll();

    @Query("SELECT * FROM ItemType WHERE item_type = :itemType")
    ItemType get(String itemType);

    @Insert
    long[] insert(ItemType... itemtype);
    @Insert
    void insertAll(List<ItemType> itemTypes);

    @Insert
    void insert(ItemType itemType);

    @Update
    void update(ItemType itemType);

    @Delete
    void delete(ItemType itemType);

}
