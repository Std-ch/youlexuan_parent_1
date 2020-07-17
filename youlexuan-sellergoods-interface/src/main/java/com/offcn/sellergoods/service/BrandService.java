package com.offcn.sellergoods.service;
import java.util.List;
import java.util.Map;

import com.offcn.entity.PageResult;
import com.offcn.pojo.TbBrand;
/**
 * 品牌服务层接口
 * @author Administrator
 *
 */
public interface BrandService {
    /**
     * 返回全部列表
     * @return
     */
    public List<TbBrand> findAll();

    // 分页查询，插入两个参数，一个是pagenum当前起始页和每页总记录数pagesize
    public PageResult findPage(int pageNum,int pageSize);

    //添加
    public void add(TbBrand brand);

    //回显
    public TbBrand findOne(long id);

    //修改
    public void update(TbBrand brand);
    //删除
    public void delete(long [] ids);
    //搜索
    public PageResult findPage(TbBrand brand,int pageNum,int pageSize);

    public List<Map> selectOptionList();

}