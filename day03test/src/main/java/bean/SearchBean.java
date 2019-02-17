package bean;

import java.util.List;

public class SearchBean {

    /**
     * result : [{"commodityId":84,"commodityName":"秋冬装新款高腰半截裙女时尚灯芯绒短裙韩版学生a字裙子","masterPic":"http://172.17.8.100/images/small/commodity/nz/qz/6/1.jpg","price":129,"saleNum":0},{"commodityId":80,"commodityName":"秋季新款韩版女装连衣裙春秋冬学院风气质休闲时尚显瘦字母印花拼接荷叶边短裙子长袖连衣裙","masterPic":"http://172.17.8.100/images/small/commodity/nz/qz/2/1.jpg","price":178,"saleNum":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 84
         * commodityName : 秋冬装新款高腰半截裙女时尚灯芯绒短裙韩版学生a字裙子
         * masterPic : http://172.17.8.100/images/small/commodity/nz/qz/6/1.jpg
         * price : 129
         * saleNum : 0
         */

        private int commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int saleNum;

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

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
}
