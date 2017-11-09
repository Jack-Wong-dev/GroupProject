package glm.seclass.qc.edu.glm;

/**
 * Created by Lin on 11/9/17.
 */

import android.arch.persistence.room.Query;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Dao;
import java.util.*;

@Dao
public interface GroceryListDAO {

    @Query("SELECT * FROM item")
    List<item> getAll();

    @Query("SELECT itemName FROM item WHERE itemName LIKE %:itemName%")
    List<item> searchItem(String name);

    

    @Query("SELECT * FROM item WHERE name LIKE :name LIMIT 1")
    item findByName(String name);

    @Insert
    void insertAll(List<item> items);

    @Update
    void update(item item);

    @Delete
    void delete(item item);

}
