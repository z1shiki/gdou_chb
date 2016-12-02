package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.Address;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public interface AddressModel {
    /**
     * 添加收货地址
     * @param address
     * @return
     */
    Observable<Result> addAddress(Address address);

    /**
     * 改变用户默认收货地址
     * @param addressId
     * @return
     */
    Observable<Result> changeDefault(long addressId);

    /**
     * 删除收货地址
     * @param addressId
     * @return
     */
    Observable<Result> delete(long addressId);

    /**
     * 查找指定用户的所有地址
     * @param userId
     * @return
     */
    Observable<Result> all(long userId);

    /**
     * 查找指定用户的默认地址
     * @param userId
     * @return
     */
    Observable<Result> defalut(long userId);

    /**
     * 修改收货地址
     * @param address
     * @return
     */
    Observable<Result> update(Address address);

}
