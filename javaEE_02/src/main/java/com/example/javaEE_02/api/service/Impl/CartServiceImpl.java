package com.example.javaEE_02.api.service.Impl;

import com.example.javaEE_02.api.service.CartService;
import com.example.javaEE_02.dao.cart.CartDao;
import com.example.javaEE_02.dao.cart.CartDaoImpl;
import com.example.javaEE_02.dao.user.UserDao;
import com.example.javaEE_02.dao.user.UserDaoImpl;
import com.example.javaEE_02.pojo.Cart;
import com.example.javaEE_02.pojo.Carts;
import com.example.javaEE_02.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

public class CartServiceImpl implements CartService {

    private final CartDao cartDao = new CartDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

    //添加商品到购物车
    @Override
    public void addCommodity(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");

        //通过用户的账户名查找用户的id
        User db_user = userDao.queryUserByAccount(user.getUser_account());
        System.out.println("db_user = " + db_user);

        Integer commodity_id = Integer.valueOf(request.getParameter("commodity_id"));
        System.out.println("commodity_id = " + commodity_id);
        //查询购物车中是否已经含有本商品
        Cart inCart = cartDao.isInCart(new Cart(db_user.getId(), commodity_id, null));

        //没有的话，添加到购物车，数量为1
        if (inCart == null) {
            Cart cart = new Cart();
            cart.setUser_id(db_user.getId());
            cart.setCommodity_id(commodity_id);
            cart.setCommodity_count(1);
            cartDao.addCommodity(cart);
            writer.println("添加成功");
        } else {
            //已经存在的话，修改数量，数量+1
            inCart.setCommodity_count(inCart.getCommodity_count() + 1);
            cartDao.updateCommodityCountById(inCart.getId(), inCart.getCommodity_count());
            writer.println("已存在，购物车该商品数量+1");
        }
    }

    @Override
    public void addCount() {

    }

    @Override
    public void reduceCount() {

    }


    //获取购物车信息
    @Override
    public List<Carts> getCartList(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("User");

            if (user == null)
                throw new RuntimeException("未登录,请先登录");

            //通过用户的账户名查找用户的id
            User db_user = userDao.queryUserByAccount(user.getUser_account());

            return cartDao.getCarts(db_user.getId());
        } catch (Exception e) {
            System.err.println("error:  " + e);
            return null;
        }
    }

    @Override
    public double getCartPrice(HttpServletRequest request, HttpServletResponse response) {
        List<Carts> cartList = getCartList(request, response);
        double mPrice=0;
        for (Carts e : cartList) {
            mPrice+=e.getCount()*e.getCommodity().getPrice();
        }
        return mPrice;
    }


}








