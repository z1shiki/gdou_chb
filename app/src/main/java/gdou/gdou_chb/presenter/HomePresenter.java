package gdou.gdou_chb.presenter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import gdou.gdou_chb.contract.HomeContract;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Z1shiki on 2016/11/30.
 */

public class HomePresenter implements HomeContract.Presenter {

    private CompositeSubscription mSubscription;
    private final HomeContract.ShopView mHomeView;
    private HomeContract.OrderView mOrderView;
    private HomeContract.UserCenterView mUserCenterView;
    //Home需要操作的数据 地址 商家
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;

    private double mLatitude;
    private double mLongitude;
    private String mAddress;

    private Context mContext;

    public HomePresenter(Context context, @Nullable HomeContract.ShopView homeView)
    {
        mHomeView = homeView;
        mOrderView = null;
        mUserCenterView = null;
        mContext = context;
        mSubscription = new CompositeSubscription();
        mHomeView.setPresenter(this);
    }

    public void setmUserCenterView(HomeContract.UserCenterView view){
        mUserCenterView = view;
    }

    public void setmOrderView(HomeContract.OrderView view){
        mOrderView = view;
    }




    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void initAmap() {
        //TODO:初始化参数
        //初始化定位
        mLocationClient = new AMapLocationClient(mContext);
        //设置定位回调监听
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        //可在其中解析amapLocation获取相应内容。
//                        TODO: 解析地址并打包与数据层交互
                        mLatitude = aMapLocation.getLatitude();//获取纬度
                        mLongitude = aMapLocation.getLongitude();//获取经度
                        mAddress = aMapLocation.getAddress();//获取地址
                    }else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError","location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                }
            }
        });
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();

        //TODO:配置参数
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(
                AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //获取一次定位结果：
        mLocationOption.setOnceLocation(true);

        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度
        // 最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被
        // 设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(true);

        //TODO:启动定位
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
    }

    @Override
    public void getGPS() {
//        执行定位并且
        //启动定位
        mLocationClient.startLocation();
//        TODO: 和数据层的 地址 进行交互
//        存入一个本地地址库来读取商家
//        mHomeView.setLocation(维护的地址参数);
    }

    @Override
    public void changelocation() {
//        TODO:从本地地址数据库选择地址、
//         新的地址的经纬发送给数据层、从数据层获得新的商家列表
//        mHomeView.changeShoplist(维护的商家列表参数);  修改商店列表的方法
    }

    @Override
    public void doSerach() {
        //TODO : 发送搜索栏里的值给商家列表
        //返回新的商家列表
//        mHomeView.changeShoplist(维护的商家列表参数); 数据层返回了搜索过后的新的商家列表
    }
}
