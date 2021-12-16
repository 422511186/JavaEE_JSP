package com.example.javaEE_02.pojo;

/**
 * 购物车
 *
 * @Auther: hzy
 * @Date: 2021/11/27 19:26
 * @Description:
 */

public class Cart {
    private Integer id;//表id 主键
    private Integer user_id;//用户id
    private Integer commodity_id;//商品id
    private Integer commodity_count;//商品数量

    public Cart() {
    }

    public Cart(Integer user_id, Integer commodity_id, Integer commodity_count) {
        //this.id = id;
        this.user_id = user_id;
        this.commodity_id = commodity_id;
        this.commodity_count = commodity_count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(Integer commodity_id) {
        this.commodity_id = commodity_id;
    }

    public Integer getCommodity_count() {
        return commodity_count;
    }

    public void setCommodity_count(Integer commodity_count) {
        this.commodity_count = commodity_count;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
