package com.example.week03demo.bean;

import java.util.List;

public class CartBean {
    public String message;
    public String status;
    public List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public class ResultBean{
        public int commodityId;
        public String commodityName;
        public int count;
        public String pic;
        public int price;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
