package gdou.gdou_chb.car;

import java.util.Random;

public class GoodsItem{
    public int id;
    public int typeId;
    public int rating;
    public String name;
    public String typeName;
    public double price;
    public int count = 1;
    public String shopimg;

    public GoodsItem(int id, double price, String name, int typeId, String typeName,String img) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.typeId = typeId;
        this.typeName = typeName;
        this.shopimg = img;
        rating = new Random().nextInt(5)+1;
    }
}
