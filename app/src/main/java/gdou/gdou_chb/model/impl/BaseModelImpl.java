package gdou.gdou_chb.model.impl;

import gdou.gdou_chb.model.bean.User;

/**
 * Created by WT on 2016/12/1.
 */

public class BaseModelImpl {

    /**
     * 保存用户对象
     */
    public static User user;
    /**
     * 公共接口号
     */
    public static final String Service_URL = "http://172.16.13.28:9001/";
    /**
     * 用户
     * User_URL
     */
    public static final String register_URL = "users/register";
    public static final String doLogin_URL = "users/doLogin";
    public static final String resetPassword_URL = "users/resetPassword";
    public static final String changePassword_URL = "users/changePasswords";
    public static final String findUserInfo_URL = "users/findUsersInfo";
    public static final String updateUser_URL = "users/update";
    /**
     * 地址
     * Address_URL
     */
    public static final String addAddress_URL = "address/add";
    public static final String delete_URL = "address/delete/";
    public static final String updateAdderss_URL = "address/update";
    public static final String defalut_URL = "address/defalut/";
    public static final String changeDefault_URL = "address/changeDefault/";
    public static final String allUser_URL = "address/all/"+"userId";
    /**
     * 商店
     * Shop_URL
     */
    public static final String shop_URL = "shop/all";
    /**
     * 商品
     * Good_URL
     */
    public static final String findByShopId_URL = "goods/shop/";
    /**
     * 订单
     * Orders_URL
     */
    public static final String placeOrder_URL = "orders/placeOrder";
    public static final String doneOrders_URL = "orders/done/";
    public static final String rebackOrders_URL = "orders/reback/";
    public static final String userAllOrders_URL = "orders/user/";
    public static final String ordersInfo_URL = "orders/ordersInfo/";
    /**
     * 评论
     * Comment_URL
     */
    public static final String commentOrders_URL = "comment/commentOrders";
    public static final String findByOrderId_URL = "comment/findByOrderId/";
    public static final String getRevent_URL = "comment/reventComment";
    /**
     * 验证码
     * VerifyCode_URL
     */
    public static final String getVerifycode_URL = "verifycode/"+"verifyCode/"+"phoneNumber";
}
