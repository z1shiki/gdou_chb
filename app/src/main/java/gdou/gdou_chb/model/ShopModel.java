package gdou.gdou_chb.model;

import gdou.gdou_chb.data.bean.Shop;

/**
 * Created by WT on 2016/11/30.
 */

public interface ShopModel {
    /**
     * 商家营业
     * @param userId
     * @return
     */
    Shop Online(long userId);

    /**
     * 商家休息
     * @param userId
     * @return
     */
    Shop shopOffLine(long userId);
}
