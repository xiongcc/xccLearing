package com.example.xiong.xionglearing.xcc.test;

import java.util.List;

/**
 * Created by Administrator on 2016/3/3.
 */
public class TestModel {

    /**
     * standard_code : string
     * mark_items : [{"score":"0分","remark":"写解得0分"},{"score":"1分","remark":"写了等式"}]
     */

    private String standard_code;

    @Override
    public String toString() {
        return "TestModel{" +
                "standard_code='" + standard_code + '\'' +
                ", mark_items=" + mark_items +
                '}';
    }

    /**
     * score : 0分
     * remark : 写解得0分
     */

    private List<MarkItemsEntity> mark_items;

    public void setStandard_code(String standard_code) {
        this.standard_code = standard_code;
    }

    public void setMark_items(List<MarkItemsEntity> mark_items) {
        this.mark_items = mark_items;
    }

    public String getStandard_code() {
        return standard_code;
    }

    public List<MarkItemsEntity> getMark_items() {
        return mark_items;
    }

    public static class MarkItemsEntity {
        private String score;
        private String remark;

        @Override
        public String toString() {
            return "MarkItemsEntity{" +
                    "score='" + score + '\'' +
                    ", remark='" + remark + '\'' +
                    '}';
        }

        public void setScore(String score) {
            this.score = score;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getScore() {
            return score;
        }

        public String getRemark() {
            return remark;
        }
    }
}
