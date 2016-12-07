package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.Comment;
import gdou.gdou_chb.model.CommentModel;
import gdou.gdou_chb.model.bean.Orders;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class CommentModelImpl implements CommentModel {
    @Override
    public Observable<Result> commentOrders(Comment comment) {
        HttpParams params  = new HttpParams();
        params.put("OrderId", String.valueOf(comment.getOrdersId()));
        params.put("userId",String.valueOf(comment.getUserId()));
        params.put("shopUserId",String.valueOf(comment.getShopUserId()));
        params.put("content",String.valueOf(comment.getContent()));
        return  RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.commentOrders_URL
                ,params);
    }

    @Override
    public Observable<Result> findByOrderId(Comment comment) {
        HttpParams params  = new HttpParams();
        params.put("ordersId", String.valueOf(comment.getOrdersId()));
        return  RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL + BaseModelImpl.findByOrderId_URL + comment.getOrdersId()
                ,params);
    }

}
