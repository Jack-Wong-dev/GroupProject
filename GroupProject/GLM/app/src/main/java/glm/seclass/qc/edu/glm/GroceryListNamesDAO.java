package glm.seclass.qc.edu.glm;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Lin on 11/13/17.
 */

@Dao
public interface GroceryListNamesDAO {

    @Query("SELECT * FROM GroceryListNames")
    List<String> getAllLists();

    @Query("SELECT listName FROM GroceryListNames WHERE listName IS :listName")
    GroceryListNames find(String listName);

    @Insert
    void insert(GroceryListNames listName);

    @Update
    void update(GroceryListNames listName);

    @Delete
    void delete(GroceryListNames listName);

}
