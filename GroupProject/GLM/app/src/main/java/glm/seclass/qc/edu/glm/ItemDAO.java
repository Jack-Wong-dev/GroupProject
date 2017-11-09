package glm.seclass.qc.edu.glm;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by don on 11/9/17.
 */

public interface ItemDAO {

    @Query("SELECT itemName FROM Item WHERE itemName LIKE %:itemName%")
    List<Item> searchItem(String name);

    @Query("SELECT itemName FROM Item WHERE typeName IS :typeName")
    List<Item> getAllItemsOfType(String typeName);

    @Query("SELECT DISTINCT typeName FROM Item")
    List<String> getAllTypes();

    @Insert
    void insertAll(List<Item> items);

    @Insert
    void insert(String name);

    @Update
    void update(Item item);

    @Delete
    void delete(Item item);
}
