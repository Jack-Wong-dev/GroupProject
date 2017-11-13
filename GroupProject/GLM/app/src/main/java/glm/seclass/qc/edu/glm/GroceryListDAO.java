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

    @Query("SELECT DISTINCT listName FROM GroceryListsTable")
    List<String> getAllLists();

    @Query("SELECT * FROM GroceryListsTable WHERE listName LIKE :listName GROUP BY itemType")
    List<GroceryListsTable> getSelectedList(String listName);

    
    @Insert
    void insertAll(List<Item> items);

    @Update
    void update(Item item);

    @Delete
    void delete(Item item);

}