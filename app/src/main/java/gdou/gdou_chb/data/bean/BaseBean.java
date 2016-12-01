package gdou.gdou_chb.data.bean;

import java.io.Serializable;
import java.util.UUID;
/**
 * Created by WT on 2016/12/1.
 */

public abstract class BaseBean implements Serializable{

    public UUID uuid;

    /**
     * 唯一的识别标
     * @return
     */
    public UUID getUuid() {
        return UUID.randomUUID();
    }
}
