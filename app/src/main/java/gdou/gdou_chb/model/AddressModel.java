package gdou.gdou_chb.model;

import gdou.gdou_chb.data.bean.Address;

/**
 * Created by WT on 2016/11/30.
 */

public interface AddressModel {
    /**
     * 添加收货地址
     * @param address
     * @return
     */
    Address addAddress(Address address);

    /**
     * 改变用户默认收货地址
     * @param addressId
     * @return
     */
    Address changeDefault(long addressId);

    /**
     * 删除收货地址
     * @param addressId
     * @return
     */
    Address delete(long addressId);

    /**
     * 查找指定用户的所有地址
     * @param userId
     * @return
     */
    Address all(long userId);

    /**
     * 查找指定用户的默认地址
     * @param userId
     * @return
     */
    Address defalut(long userId);

    /**
     * 修改收货地址
     * @param address
     * @return
     */
    Address update(Address address);

}
