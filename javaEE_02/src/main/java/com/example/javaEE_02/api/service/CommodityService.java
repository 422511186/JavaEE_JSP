package com.example.javaEE_02.api.service;

import com.example.javaEE_02.pojo.Commodity;

import java.util.List;

public interface CommodityService {

    /**
     * 添加商品
     *
     * @param commodity
     * @return
     * @throws Exception
     */
    int addCommodity(Commodity commodity) throws Exception;

    /**
     * 获取商品列表
     *
     * @return
     */
    List<Commodity> getCommodities();


}
