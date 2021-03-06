package com.example.javaEE_02.dao.commodity;

import com.example.javaEE_02.dao.basedao;
import com.example.javaEE_02.pojo.Commodity;
import com.example.javaEE_02.pojo.Img;
import org.testng.annotations.Test;

import java.util.List;

public class CommodityDaoImpl extends basedao implements CommodityDao {
    @Override
    public List<Commodity> queryCommodities() throws Exception {
        String sql = "select id,name,detail,price,count from Commodity";
        List<Commodity> commodityList = queryForList(Commodity.class, sql);
        for (Commodity commodity : commodityList) {
            commodity.setDetail_img(queryCommodityImgById(commodity.getId()));
        }
        return commodityList;
    }

    public List<Img> queryCommodityImgById(Integer id) throws Exception {
        String sql = "select img_info from commodity_detail_img where commodity_id=?";
        List<Img> list = queryForList(Img.class, sql, id);
        return list;
    }

    public int deleteCommodityImgById(Integer id) throws Exception {
        String sql = "delete from commodity_detail_img where commodity_id=?";
        int update = update(sql, id);
        return update;
    }


    @Override
    public List<Commodity> queryCommodityByName(String name) throws Exception {
        String sql = "select id,name,detail,price,count from Commodity where name like ?";
        List<Commodity> commodityList = queryForList(Commodity.class, sql, name);
        for (Commodity commodity : commodityList) {
            commodity.setDetail_img(queryCommodityImgById(commodity.getId()));
        }
        return commodityList;
    }

    @Override
    public int updateCommodityCountById(Integer id, Integer count) throws Exception {
        String sql = "update Commodity set count=? where id=?";
        int update = update(sql, count, id);
        return update;
    }

    @Override
    public int deleteCommodityById(Integer id) throws Exception {
        String sql = "delete from Commodity where id=?";
        int update = update(sql, id);
        deleteCommodityImgById(id);
        return update;
    }

    @Override
    public Commodity queryCommodityById(Integer id) throws Exception {
        String sql1 = "select id,name,detail,price,count from Commodity where id=?";
        Commodity commodity = queryForOne(Commodity.class, sql1, id);
        commodity.setDetail_img(queryCommodityImgById(id));
        return commodity;
    }

    @Override
    public int saveCommodity(Commodity commodity) throws Exception {
        String sql1 = "insert into commodity (id, name, detail, price, count) values (?,?,?,?,?)";
        String sql2 = "insert into commodity_detail_img (img_info, commodity_id) values(?,?)";
        int update1 = update(sql1, commodity.getId(), commodity.getName(), commodity.getDetail(), commodity.getPrice(), commodity.getCount());
        if (update1 != -1) {
            for (Img img : commodity.getDetail_img()) {
                int update2 = update(sql2, img.getImg_info(), commodity.getId());
                if (update2 == -1) {
                    return update2;
                }
            }
        }
        return update1;
    }

    @Test
    void p() throws Exception {
        // ?????????????????????????????????
        List<Commodity> commodityList = queryCommodityByName("?????????");
        for (Commodity commodity : commodityList) {
            System.out.println("123");
            System.out.println(commodity.getName() + commodity.getId());
        }

        // ???????????????????????????????????????id???????????????????????????
        //updateCommodityCountById(1, 100);

        // ????????????id???????????????
        //deleteCommodityById(102);

        // ????????????id?????????????????????return???????????????????????????
        //Commodity commodity = queryCommodityById(101);
        //System.out.println(commodity.getName());
        //for (Img img:commodity.getDetail_img()) {
        //    System.out.println("+++" + img.getImg_info());
        //}
        //Commodity commodity = queryCommodityById(101);
        //System.out.println(commodity.getDetail());
        //List<Img> list = queryCommodityImgById(101);
        //System.out.println(list);
        //for (Img l:list) {
        //    System.out.println(l.getImg_info());
        //}


        //Commodity commodity = new Commodity();
        //commodity.setId(102);
        //commodity.setName("we");
        //commodity.setDetail("wqe");
        //commodity.setPrice(12.3);
        //commodity.setCount(2);
        //List<Img> list = new ArrayList<>();
        //list.add(new Img("aaa"));
        //list.add(new Img("bbb"));
        //commodity.setDetail_img(list);
        // ?????????????????????????????????????????????????????????Commodity???
        //saveCommodity(commodity);
    }
}
