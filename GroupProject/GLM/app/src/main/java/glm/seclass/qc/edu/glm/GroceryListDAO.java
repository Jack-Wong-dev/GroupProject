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

    @Query("SELECT DISTINCT listName FROM groceryLists")
    List<String> getAllLists();

    @Query("SELECT * FROM groceryLists WHERE listName LIKE :listName")
    List<item> getSelectedList(String listName);

//    @Query("SELECT * FROM item WHERE name LIKE :name LIMIT 1")
//    item findByName(String name);

    @Insert
    void insertAll(List<item> items);

    @Update
    void update(item item);

    @Delete
    void delete(item item);

}
