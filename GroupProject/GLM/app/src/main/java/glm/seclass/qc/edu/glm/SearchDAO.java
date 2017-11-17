package glm.seclass.qc.edu.glm;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Lin on 11/15/17.
 */

@Dao
public interface SearchDAO {
    @Query("SELECT * ")
    public List<ItemAndType> getAllItemAndTypes();
}
