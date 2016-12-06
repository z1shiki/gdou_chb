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
        return null;
    }

    @Override
    public Observable<Result> findByOrderId(Orders orders) {
        return null;
    }

    @Override
    public Observable<Result> getRevent(Comment comment) {
        return null;
    }
}
