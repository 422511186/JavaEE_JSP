package com.example.javaEE_02.api.service.Impl;

import com.example.javaEE_02.api.service.CommodityService;
import com.example.javaEE_02.dao.commodity.CommodityDao;
import com.example.javaEE_02.dao.commodity.CommodityDaoImpl;
import com.example.javaEE_02.pojo.Commodity;

import java.util.List;

public class CommodityServiceImpl implements CommodityService {

    private final CommodityDao commodityDao = new CommodityDaoImpl();

    /**
     * 添加商品
     *
     * @param commodity
     * @return
     * @throws Exception
     */
    @Override
    public int addCommodity(Commodity commodity) throws Exception {
        return commodityDao.saveCommodity(commodity);
    }

    /**
     * 获取商品列表
     *
     * @return
     */
    @Override
    public List<Commodity> getCommodities() {
        List<Commodity> list = null;
        try {
            list = commodityDao.queryCommodities();
        } catch (Exception e) {
            System.err.println("error:  " + e);
        }
        return list;
    }

}
