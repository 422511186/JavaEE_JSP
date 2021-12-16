package com.example.javaEE_02.pojo;

import java.util.List;

/**
 * 商品类实体类
 *
 * @Auther: hzy
 * @Date: 2021/11/27 18:49
 * @Description:
 */

public class Commodity {

    private Integer id;     //商品id
    private String name;    //商品名称
    private String detail;  //商品信息
    private List<Img> detail_img;  //商品图
    private Double price;   //商品价格
    private Integer count;  //商品库存

    public Commodity() {
    }

    public Commodity(Integer id, String name, String detail, Double price, Integer count) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.count = count;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Img> getDetail_img() {
        return detail_img;
    }

    public void setDetail_img(List<Img> detail_img) {
        this.detail_img = detail_img;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", detail_img=" + detail_img +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
