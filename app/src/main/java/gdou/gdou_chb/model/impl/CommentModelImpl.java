package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.Comment;
import gdou.gdou_chb.model.CommentModel;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class CommentModelImpl implements CommentModel {
    /**
     * 提交评论
     * @param comment
     * @return
     */
    @Override
    public Observable<Result> commentOrders(Comment comment) {
        HttpParams params = new HttpParams();
        params.put("comment", String.valueOf(comment));
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.commentOrders_URL
                ,params);
    }

    /**
     * 查找指定订单评论
     * @param orderId
     * @return
     */

    @Override
    public Observable<Result> findByOrderId(long orderId) {
        HttpParams params = new HttpParams();
        params.put("orderId", String.valueOf(orderId));
        return RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL + BaseModelImpl.findByOrderId_URL
                ,params);
    }

    /**
     * 得到商家回复
     * @param orderId
     * @return
     */

    @Override
    public Observable<Result> getRevent(long orderId) {
        HttpParams params = new HttpParams();
        params.put("orderId", String.valueOf(orderId));
        return RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL + BaseModelImpl.getRevent_URL
                ,params);
    }
}
