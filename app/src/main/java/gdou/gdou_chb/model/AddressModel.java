package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;
import gdou.gdou_chb.model.bean.Address;
import gdou.gdou_chb.model.bean.User;
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
     * @param address
     * @return
     */
    Observable<Result> changeDefault(Address address);
    /**
     * 删除收货地址
     * @param address
     * @return
     */
    Observable<Result> delete(Address address);
    /**
     * 查找指定用户的所有地址
     * @param user
     * @return
     */
    Observable<Result> all(User user);
    /**
     * 查找指定用户的默认地址
     * @param user
     * @return
     */
    Observable<Result> defalut(User user);
    /**
     * 修改收货地址
     * @param address
     * @return
     */
    Observable<Result> update(Address address);
}
