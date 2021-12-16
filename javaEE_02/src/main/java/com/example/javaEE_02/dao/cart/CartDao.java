package com.example.javaEE_02.dao.cart;

import com.example.javaEE_02.pojo.Cart;
import com.example.javaEE_02.pojo.Carts;

import java.util.List;

public interface CartDao {

    /**
     * 通过购物车id获取一个购物车
     *
     * @param id
     * @return
     */
    Cart queryCartById(Integer id) throws Exception;

    /**
     * 通过购物车的id修改购物车中的商品的数量
     *
     * @param id
     * @param count
     * @return
     * @throws Exception
     */
    int updateCommodityCountById(Integer id, Integer count) throws Exception;

    /**
     * 向购物车添加商品
     *
     * @param cart 一个Cart类的对象。
     * @return
     */
    int addCommodity(Cart cart) throws Exception;

    /**
     * 通过购物车的id删除再购物车中的某个商品
     *
     * @param
     * @return
     */
    int deleteCommodity(Integer id) throws Exception;

    /**
     * 判断该用户的购物车是否含有该商品
     *
     * @param cart
     * @return
     * @throws Exception
     */
    Cart isInCart(Cart cart) throws Exception;

    /**
     * 获取该用户的购物车列表
     * @param id
     * @return
     * @throws Exception
     */
    List<Carts> getCarts(Integer id) throws Exception;
}
