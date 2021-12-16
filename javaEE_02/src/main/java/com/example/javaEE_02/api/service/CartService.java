package com.example.javaEE_02.api.service;

import com.example.javaEE_02.pojo.Carts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: hzy
 * @Date: 2021/12/5 22:53
 * @Description:
 */
public interface CartService {
    //添加商品到购物车
    void addCommodity(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * 购物车商品数量添加
     */
    void addCount();

    /**
     * 购物车商品数量减少
     */
    void reduceCount();

    //获取购物车信息
    List<Carts> getCartList(HttpServletRequest request, HttpServletResponse response);

    /**
     * 获取当前购物车的总金额
     * @param request
     * @param response
     * @return
     */
    double getCartPrice(HttpServletRequest request, HttpServletResponse response);
}
