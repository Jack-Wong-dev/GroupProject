package glm.seclass.qc.edu.glm;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by don on 11/9/17.
 */

@Dao
public interface ItemDAO {

//    when doing this add % to beginning and end of search term
    @Query("SELECT * FROM Item WHERE itemName LIKE :name")
    List<Item> searchItem(String name);

    @Query("SELECT * FROM Item WHERE typeName IS :typeName")
    List<Item> getAllItemsOfType(String typeName);

    //    this throws an error could be something with SQL call
    @Query("SELECT typeName FROM Item GROUP BY typeName")
    List<String> getAllTypes();

    @Query("SELECT * FROM Item")
    List<Item> getAllItems();

    @Insert
    void insertAll(List<Item> items);

    @Insert
    void insert(Item item);

    @Update
    void update(Item item);

    @Delete
    void delete(Item item);
}
