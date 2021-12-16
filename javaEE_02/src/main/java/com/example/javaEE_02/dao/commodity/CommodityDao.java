package com.example.javaEE_02.dao.commodity;

import com.example.javaEE_02.pojo.Commodity;

import java.util.List;

public interface CommodityDao {

    /**
     * 获取所有商品列表
     *
     * @return
     * @throws Exception
     */
    List<Commodity> queryCommodities() throws Exception;

    /**
     * 通过商品名进行模糊查询
     *
     * @param name
     * @return
     */
    List<Commodity> queryCommodityByName(String name) throws Exception;

    /**
     * 通过商品id来更新商品库存
     *
     * @param id
     * @param count 商品库存更新后的数量
     * @return
     */
    int updateCommodityCountById(Integer id, Integer count) throws Exception;

    /**
     * 通过商品id删除某个商品
     *
     * @param id
     * @return
     */
    public int deleteCommodityById(Integer id) throws Exception;

    /**
     * 通过商品id查找
     *
     * @param id
     * @return
     */
    public Commodity queryCommodityById(Integer id) throws Exception;

    /**
     * 保存某个商品
     *
     * @param commodity
     * @return
     * @throws Exception
     */
    public int saveCommodity(Commodity commodity) throws Exception;


}
