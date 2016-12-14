package gdou.gdou_chb;

import org.junit.Test;

import java.util.List;

import gdou.gdou_chb.model.bean.ResultBean;
import gdou.gdou_chb.model.bean.Shop;
import gdou.gdou_chb.util.GsonUtils;

/**
 * Created by MissYou on 2016/12/13.
 */

public class GetShopTest {

    private String testJson = "{\n" +
            "  \"messageCode\": 200,\n" +
            "  \"serviceResult\": true,\n" +
            "  \"resultInfo\": \"查询成功\",\n" +
            "  \"resultParm\": {\n" +
            "    \"shopList\": [\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"createdBy\": \"2\",\n" +
            "        \"createdDate\": 1480990581000,\n" +
            "        \"lastModifiedBy\": null,\n" +
            "        \"lastModifiedDate\": 1480990581000,\n" +
            "        \"openTime\": 0,\n" +
            "        \"distributionFee\": 1,\n" +
            "        \"score\": 0,\n" +
            "        \"startingPrice\": 9,\n" +
            "        \"stopTime\": 0,\n" +
            "        \"latitude\": 0,\n" +
            "        \"longitude\": 0,\n" +
            "        \"shopName\": \"小食\",\n" +
            "        \"license\": 0,\n" +
            "        \"shopImg\": \"/imageware/bf1fb76a-b09b-46de-b886-beac80ee98c7.png\",\n" +
            "        \"status\": 0,\n" +
            "        \"businessId\": 0,\n" +
            "        \"online\": false,\n" +
            "        \"delete\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"createdBy\": \"2\",\n" +
            "        \"createdDate\": 1480990896000,\n" +
            "        \"lastModifiedBy\": null,\n" +
            "        \"lastModifiedDate\": 1480990896000,\n" +
            "        \"openTime\": 0,\n" +
            "        \"distributionFee\": 2,\n" +
            "        \"score\": 0,\n" +
            "        \"startingPrice\": 10,\n" +
            "        \"stopTime\": 0,\n" +
            "        \"latitude\": 0,\n" +
            "        \"longitude\": 0,\n" +
            "        \"shopName\": \"中餐\",\n" +
            "        \"license\": 0,\n" +
            "        \"shopImg\": \"\\\\imageware\\\\bf1fb76a-b09b-46de-b886-beac80ee98c7.png\",\n" +
            "        \"status\": 0,\n" +
            "        \"businessId\": 0,\n" +
            "        \"online\": true,\n" +
            "        \"delete\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 3,\n" +
            "        \"createdBy\": \"1\",\n" +
            "        \"createdDate\": 1481080594000,\n" +
            "        \"lastModifiedBy\": null,\n" +
            "        \"lastModifiedDate\": 1481080594000,\n" +
            "        \"openTime\": 0,\n" +
            "        \"distributionFee\": 3,\n" +
            "        \"score\": 0,\n" +
            "        \"startingPrice\": 11,\n" +
            "        \"stopTime\": 0,\n" +
            "        \"latitude\": 0,\n" +
            "        \"longitude\": 0,\n" +
            "        \"shopName\": \"衣服\",\n" +
            "        \"license\": 0,\n" +
            "        \"shopImg\": \"\\\\imageware\\\\bf1fb76a-b09b-46de-b886-beac80ee98c7.png\",\n" +
            "        \"status\": 0,\n" +
            "        \"businessId\": 0,\n" +
            "        \"online\": false,\n" +
            "        \"delete\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 4,\n" +
            "        \"createdBy\": \"2\",\n" +
            "        \"createdDate\": 1481183978000,\n" +
            "        \"lastModifiedBy\": null,\n" +
            "        \"lastModifiedDate\": 1481183984000,\n" +
            "        \"openTime\": 0,\n" +
            "        \"distributionFee\": 4,\n" +
            "        \"score\": 0,\n" +
            "        \"startingPrice\": 23,\n" +
            "        \"stopTime\": 0,\n" +
            "        \"latitude\": 12,\n" +
            "        \"longitude\": 1.02,\n" +
            "        \"shopName\": \"杂货\",\n" +
            "        \"license\": 0,\n" +
            "        \"shopImg\": \"\\\\imageware\\\\bf1fb76a-b09b-46de-b886-beac80ee98c7.png\",\n" +
            "        \"status\": 0,\n" +
            "        \"businessId\": 0,\n" +
            "        \"online\": true,\n" +
            "        \"delete\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 5,\n" +
            "        \"createdBy\": \"0\",\n" +
            "        \"createdDate\": 1481430386000,\n" +
            "        \"lastModifiedBy\": null,\n" +
            "        \"lastModifiedDate\": 1481430386000,\n" +
            "        \"openTime\": 0,\n" +
            "        \"distributionFee\": 0,\n" +
            "        \"score\": 0,\n" +
            "        \"startingPrice\": 0,\n" +
            "        \"stopTime\": 0,\n" +
            "        \"latitude\": 0,\n" +
            "        \"longitude\": 0,\n" +
            "        \"shopName\": \"饮料\",\n" +
            "        \"license\": 0,\n" +
            "        \"shopImg\": \"\\\\imageware\\\\bf1fb76a-b09b-46de-b886-beac80ee98c7.png\",\n" +
            "        \"status\": 0,\n" +
            "        \"businessId\": 0,\n" +
            "        \"online\": false,\n" +
            "        \"delete\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 6,\n" +
            "        \"createdBy\": \"0\",\n" +
            "        \"createdDate\": 1481430544000,\n" +
            "        \"lastModifiedBy\": null,\n" +
            "        \"lastModifiedDate\": 1481430544000,\n" +
            "        \"openTime\": 0,\n" +
            "        \"distributionFee\": 0,\n" +
            "        \"score\": 0,\n" +
            "        \"startingPrice\": 0,\n" +
            "        \"stopTime\": 0,\n" +
            "        \"latitude\": 0,\n" +
            "        \"longitude\": 0,\n" +
            "        \"shopName\": \"包子\",\n" +
            "        \"license\": 0,\n" +
            "        \"shopImg\": \"\\\\imageware\\\\bf1fb76a-b09b-46de-b886-beac80ee98c7.png\",\n" +
            "        \"status\": 0,\n" +
            "        \"businessId\": 0,\n" +
            "        \"online\": false,\n" +
            "        \"delete\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 7,\n" +
            "        \"createdBy\": \"0\",\n" +
            "        \"createdDate\": 1481430713000,\n" +
            "        \"lastModifiedBy\": null,\n" +
            "        \"lastModifiedDate\": 1481430713000,\n" +
            "        \"openTime\": 0,\n" +
            "        \"distributionFee\": 0,\n" +
            "        \"score\": 0,\n" +
            "        \"startingPrice\": 0,\n" +
            "        \"stopTime\": 0,\n" +
            "        \"latitude\": 0,\n" +
            "        \"longitude\": 0,\n" +
            "        \"shopName\": \"糖水\",\n" +
            "        \"license\": 0,\n" +
            "        \"shopImg\": \"\\\\imageware\\\\bf1fb76a-b09b-46de-b886-beac80ee98c7.png\",\n" +
            "        \"status\": 0,\n" +
            "        \"businessId\": 0,\n" +
            "        \"online\": false,\n" +
            "        \"delete\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 8,\n" +
            "        \"createdBy\": \"0\",\n" +
            "        \"createdDate\": 1481430755000,\n" +
            "        \"lastModifiedBy\": null,\n" +
            "        \"lastModifiedDate\": 1481430755000,\n" +
            "        \"openTime\": 0,\n" +
            "        \"distributionFee\": 0,\n" +
            "        \"score\": 0,\n" +
            "        \"startingPrice\": 0,\n" +
            "        \"stopTime\": 0,\n" +
            "        \"latitude\": 0,\n" +
            "        \"longitude\": 0,\n" +
            "        \"shopName\": \"水果店\",\n" +
            "        \"license\": 0,\n" +
            "        \"shopImg\": \"\\\\imageware\\\\bf1fb76a-b09b-46de-b886-beac80ee98c7.png\",\n" +
            "        \"status\": 0,\n" +
            "        \"businessId\": 0,\n" +
            "        \"online\": false,\n" +
            "        \"delete\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 9,\n" +
            "        \"createdBy\": \"0\",\n" +
            "        \"createdDate\": 1481430914000,\n" +
            "        \"lastModifiedBy\": null,\n" +
            "        \"lastModifiedDate\": 1481430914000,\n" +
            "        \"openTime\": 0,\n" +
            "        \"distributionFee\": 0,\n" +
            "        \"score\": 0,\n" +
            "        \"startingPrice\": 0,\n" +
            "        \"stopTime\": 0,\n" +
            "        \"latitude\": 0,\n" +
            "        \"longitude\": 0,\n" +
            "        \"shopName\": \"烧饼店\",\n" +
            "        \"license\": 0,\n" +
            "        \"shopImg\": \"\\\\imageware\\\\bf1fb76a-b09b-46de-b886-beac80ee98c7.png\",\n" +
            "        \"status\": 0,\n" +
            "        \"businessId\": 0,\n" +
            "        \"online\": false,\n" +
            "        \"delete\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 10,\n" +
            "        \"createdBy\": \"0\",\n" +
            "        \"createdDate\": 1481430963000,\n" +
            "        \"lastModifiedBy\": null,\n" +
            "        \"lastModifiedDate\": 1481430963000,\n" +
            "        \"openTime\": 0,\n" +
            "        \"distributionFee\": 0,\n" +
            "        \"score\": 0,\n" +
            "        \"startingPrice\": 0,\n" +
            "        \"stopTime\": 0,\n" +
            "        \"latitude\": 0,\n" +
            "        \"longitude\": 0,\n" +
            "        \"shopName\": \"武大郎烧饼店\",\n" +
            "        \"license\": 0,\n" +
            "        \"shopImg\": \"\\\\imageware\\\\bf1fb76a-b09b-46de-b886-beac80ee98c7.png\",\n" +
            "        \"status\": 0,\n" +
            "        \"businessId\": 0,\n" +
            "        \"online\": false,\n" +
            "        \"delete\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 11,\n" +
            "        \"createdBy\": \"0\",\n" +
            "        \"createdDate\": 1481431069000,\n" +
            "        \"lastModifiedBy\": null,\n" +
            "        \"lastModifiedDate\": 1481431069000,\n" +
            "        \"openTime\": 0,\n" +
            "        \"distributionFee\": 0,\n" +
            "        \"score\": 0,\n" +
            "        \"startingPrice\": 0,\n" +
            "        \"stopTime\": 0,\n" +
            "        \"latitude\": 0,\n" +
            "        \"longitude\": 0,\n" +
            "        \"shopName\": \"武大郎烧饼店（分店）\",\n" +
            "        \"license\": 0,\n" +
            "        \"shopImg\": \"\\\\imageware\\\\bf1fb76a-b09b-46de-b886-beac80ee98c7.png\",\n" +
            "        \"status\": 0,\n" +
            "        \"businessId\": 0,\n" +
            "        \"online\": false,\n" +
            "        \"delete\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 12,\n" +
            "        \"createdBy\": \"0\",\n" +
            "        \"createdDate\": 1481431576000,\n" +
            "        \"lastModifiedBy\": null,\n" +
            "        \"lastModifiedDate\": 1481431576000,\n" +
            "        \"openTime\": 0,\n" +
            "        \"distributionFee\": 0,\n" +
            "        \"score\": 0,\n" +
            "        \"startingPrice\": 0,\n" +
            "        \"stopTime\": 0,\n" +
            "        \"latitude\": 0,\n" +
            "        \"longitude\": 0,\n" +
            "        \"shopName\": \"武大郎烧饼店（分店）\",\n" +
            "        \"license\": 0,\n" +
            "        \"shopImg\": \"\\\\imageware\\\\bf1fb76a-b09b-46de-b886-beac80ee98c7.png\",\n" +
            "        \"status\": 0,\n" +
            "        \"businessId\": 0,\n" +
            "        \"online\": false,\n" +
            "        \"delete\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 14,\n" +
            "        \"createdBy\": \"3\",\n" +
            "        \"createdDate\": 1481600843000,\n" +
            "        \"lastModifiedBy\": null,\n" +
            "        \"lastModifiedDate\": 1481600843000,\n" +
            "        \"openTime\": 6,\n" +
            "        \"distributionFee\": 5,\n" +
            "        \"score\": 0,\n" +
            "        \"startingPrice\": 12,\n" +
            "        \"stopTime\": 2,\n" +
            "        \"latitude\": 12.3,\n" +
            "        \"longitude\": 12.03,\n" +
            "        \"shopName\": \"巫大帅\",\n" +
            "        \"license\": 1,\n" +
            "        \"shopImg\": \"\\\\imageware\\\\db01131d-f41d-4c65-9ff4-351c5e236aed.png\",\n" +
            "        \"status\": 0,\n" +
            "        \"businessId\": 3,\n" +
            "        \"online\": false,\n" +
            "        \"delete\": false\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";


    @Test
    public void checkGosn() {
        ResultBean resultBean = GsonUtils.parseJsonWithGson(testJson, ResultBean.class);
        List<Shop> shops = GsonUtils.getBeanFromResultBeanListMiss(resultBean,"shopList", Shop[].class);
        System.out.println(shops.size());
    }
}
