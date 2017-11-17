package glm.seclass.qc.edu.glm;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;

/**
 * Created by Lin on 11/15/17.
 */
@Entity
public class ItemAndType {
    @Embedded(prefix = "item_")
    Item item;
    @Embedded(prefix = "item_type_")
    ItemType itemType;
}
