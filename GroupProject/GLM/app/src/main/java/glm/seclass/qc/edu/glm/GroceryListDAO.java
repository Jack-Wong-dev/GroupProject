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
    List<Item> getSelectedList(String listName);

    @Query("SELECT itemName FROM Item WHERE itemName LIKE %:itemName%")
    List<Item> searchItem(String name);

    @Query("SELECT DISTINCT typeName FROM Item")
    List<String> getAllTypes();

    @Query("SELECT itemName FROM Item WHERE typeName IS :typeName")
    List<Item> getAllItemsOfType(String typeName);

    @Insert
    void insertAll(List<Item> items);

    @Update
    void update(Item item);

    @Delete
    void delete(Item item);

}