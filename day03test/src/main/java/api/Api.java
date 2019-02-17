package api;

public class Api {
    /**
     * 搜索框查询
     */
    public static String SEARCH = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword";

    /**
     * 商品详情
     */
    public static String MORE = "http://172.17.8.100/small/commodity/v1/findCommodityDetailsById";

    /**
     * 同步购物车
     */
    public static String SYNSCART = "http://172.17.8.100/small/order/verify/v1/syncShoppingCart";

}
