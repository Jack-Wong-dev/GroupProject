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

    @Query("SELECT DISTINCT listName FROM groceryListsTable")
    List<String> getAllLists();

    @Query("SELECT * FROM groceryListsTable WHERE listName LIKE :listName")
    List<itemTable> getSelectedList(String listName);

    

//    @Query("SELECT * FROM itemTable WHERE name LIKE :name LIMIT 1")
//    itemTable findByName(String name);

    @Insert
    void insertAll(List<itemTable> items);

    @Update
    void update(itemTable item);

    @Delete
    void delete(itemTable item);

}
