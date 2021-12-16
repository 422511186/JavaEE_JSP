package com.example.javaEE_02.pojo;

import java.util.ArrayList;

/**
 * @Auther: hzy
 * @Date: 2021/12/5 20:45
 * @Description:
 */

public class Carts {
    private Commodity commodity;
    private Integer count;

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Carts{" +
                "commodity=" + commodity +
                ", count=" + count +
                '}';
    }
}
