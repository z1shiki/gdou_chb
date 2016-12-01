package gdou.gdou_chb.model;

import gdou.gdou_chb.model.bean.Comment;

/**
 * Created by WT on 2016/11/30.
 */

public interface CommentModel {
    /**
     * 提交评论
     * @param comment
     * @return
     */
    void commentOrders(Comment comment);

    /**
     * 查找指定订单评论
     * @param orderId
     * @return
     */
    void findByOrderId(long orderId);

    /**
     * 得到商家回复
     * @param orderId
     * @return
     */
    void getRevent(long orderId );
}
