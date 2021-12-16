package com.example.javaEE_02.dao.cart;

import com.example.javaEE_02.dao.basedao;
import com.example.javaEE_02.dao.commodity.CommodityDaoImpl;
import com.example.javaEE_02.pojo.Cart;
import com.example.javaEE_02.pojo.Carts;
import com.example.javaEE_02.pojo.Commodity;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl extends basedao implements CartDao {

    @Override
    public Cart queryCartById(Integer id) throws Exception {
        String sql = "select id, user_id, commodity_id, commodity_count from Cart where id=?";
        Cart cart = queryForOne(Cart.class, sql, id);
        return cart;
    }

    @Override
    public int updateCommodityCountById(Integer id, Integer count) throws Exception {
        String sql = "update Cart set commodity_count=? where id=?";
        int update = update(sql, count, id);
        return update;
    }

    @Override
    public int addCommodity(Cart cart) throws Exception {
        String sql = "insert into Cart (user_id, commodity_id, commodity_count) values(?,?,?)";
        int update = update(sql, cart.getUser_id(), cart.getCommodity_id(), cart.getCommodity_count());
        return update;
    }

    @Override
    public int deleteCommodity(Integer id) throws Exception {
        String sql = "delete from Cart where id=?";
        int update = update(sql, id);
        return update;
    }

    @Override
    public Cart isInCart(Cart cart) throws Exception {

        String sql = "select * from Cart where user_id=? and commodity_id=?";

        return queryForOne(Cart.class, sql, cart.getUser_id(), cart.getCommodity_id());
    }

    /**
     * 获取该用户的购物车列表
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List<Carts> getCarts(Integer id) throws Exception {
        String sql = "select commodity_id,commodity_count from Cart where user_id=?";

        List<Cart> carts = queryForList(Cart.class, sql, id);

        ArrayList<Carts> list = new ArrayList<>();

        for (int i = 0; i < carts.size(); i++) {
            Cart cart = carts.get(i);
            Carts carts1 = new Carts();
            carts1.setCount(cart.getCommodity_count());

            CommodityDaoImpl commodityDao = new CommodityDaoImpl();
            Commodity commodity = commodityDao.queryCommodityById(cart.getCommodity_id());
            carts1.setCommodity(commodity);
            list.add(carts1);
        }

        return list;
    }

    @Test
    void p() throws Exception {

        // 通过购物车的id获取某个购物车
//        Cart cart = queryCartById(2);
//        System.out.println(cart);
//        System.out.println("" + cart.getUser_id() + cart.getCommodity_id() + cart.getCommodity_count());

        // 更新购物车中商品的数量，参数分别是购物车的id、商品更新后的数量
        //updateCommodityCountById(2, 1);

        // 通过购物车的id从购物车中删除某个商品
        //deletCommodity(2);

        // 向购物车中添加某个商品，参数分别是该商品属于哪个用户的id、商品的id、添加到购物车的商品的数量
        //Cart cart = new Cart(1, 101, 2);
        //addCommodity(cart);
        List<Carts> carts = new CartDaoImpl().getCarts(5);
        carts.forEach(System.out::println);

    }
}
