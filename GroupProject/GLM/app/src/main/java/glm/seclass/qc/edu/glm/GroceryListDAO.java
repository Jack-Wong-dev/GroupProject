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
public interface GroceryListDAO {

    @Query("SELECT * FROM GroceryList")
    List<GroceryList> getAll();

    @Query("SELECT * FROM GroceryList WHERE list_name = :listName")
    GroceryList find(String listName);

    @Insert
    void insert(GroceryList list);

    @Update
    void update(GroceryList list);

    @Delete
    void delete(GroceryList list);

}
