package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * 订单评论
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:37:06
 */

public class Comment implements Serializable {
    /**
     * 评论Id
     */
    private long commentId;
    /**
     * 评论内容
     */
    private String comment;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}