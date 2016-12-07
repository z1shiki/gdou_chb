package gdou.gdou_chb.util;

import android.os.Build;
import android.support.annotation.RequiresApi;

import gdou.gdou_chb.car.GoodsItem;
import gdou.gdou_chb.model.bean.Goods;

/**
 * Created by WT on 2016/12/7.
 * 转换Goods成GoodsItem
 */

public class ChangeGoosToGoodItem {

    /**
     * 转换器
     * @param goods
     * @return
     */
    public static GoodsItem change(Goods goods) {
        return new GoodsItem(Integer.valueOf(String.valueOf(goods.getGoodId())),
                goods.getPrice(),
                goods.getGoodsName(),
                0,
                null);
    }

}
