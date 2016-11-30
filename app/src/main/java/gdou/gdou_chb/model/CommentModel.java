package gdou.gdou_chb.model;

import gdou.gdou_chb.data.bean.Comment;

/**
 * Created by WT on 2016/11/30.
 */

public interface CommentModel {
    /**
     * 提交评论
     * @param comment
     * @return
     */
    Comment commentOrders(Comment comment);

    /**
     * 查找指定订单评论
     * @param orderId
     * @return
     */
    Comment findByOrderId(long orderId);

    /**
     * 得到商家回复
     * @param orderId
     * @return
     */
    Comment getRevent(long orderId);
}
