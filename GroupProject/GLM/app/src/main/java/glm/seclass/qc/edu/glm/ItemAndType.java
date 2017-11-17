package glm.seclass.qc.edu.glm;

import android.arch.persistence.room.Embedded;

/**
 * Created by Lin on 11/15/17.
 */

public class ItemAndType {
    @Embedded
    Item item;
    @Embedded
    ItemType itemType;
}
