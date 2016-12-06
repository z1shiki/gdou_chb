package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * 订单评论
 * Created by WT on 2016/11/29.
 */

public class Comment implements Serializable {
    /**
     * 订单Id
     */
    private long OrdersId;
    /**
     * 用户Id
     */
    private long userId;
    /**
     * 商家用户Id
     */
    private long shopUserId;
    /**
     * 评论Id
     */
    private long commentId;
    /**
     * 评论内容
     */
    private String content;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getOrdersId() {
        return OrdersId;
    }

    public void setOrdersId(long ordersId) {
        OrdersId = ordersId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getShopUserId() {
        return shopUserId;
    }

    public void setShopUserId(long shopUserId) {
        this.shopUserId = shopUserId;
    }
}