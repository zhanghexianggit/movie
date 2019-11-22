package com.bw.movie.bean;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public class CinemmaBean {

    /**
     * result : [{"id":4,"name":"魔影国际影城"},{"id":5,"name":"CGV星星影城"},{"id":8,"name":"北京博纳影城朝阳门旗舰店"},{"id":9,"name":"北京百老汇影城国瑞购物中心店"},{"id":10,"name":"华谊兄弟影院"},{"id":11,"name":"星美国际影城"},{"id":15,"name":"金逸北京中关村店"},{"id":16,"name":"海淀剧院"}]
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
         * id : 4
         * name : 魔影国际影城
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
