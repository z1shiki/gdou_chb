package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;
import gdou.gdou_chb.model.bean.Comment;
import gdou.gdou_chb.model.bean.Orders;
import gdou.gdou_chb.model.bean.User;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */
public interface CommentModel {
    /**
     * 提交评论
     * @param comment
     * @return
     */
    Observable<Result> commentOrders(Comment comment);
    /**
     * 查找指定订单评论
     * @param orders
     * @return
     */
    Observable<Result> findByOrderId(Orders orders);
    /**
     * 得到商家回复
     * @param comment
     * @return
     */
    Observable<Result> getRevent(Comment comment);
}
