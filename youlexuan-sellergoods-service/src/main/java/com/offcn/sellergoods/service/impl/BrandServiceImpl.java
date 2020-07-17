package com.offcn.sellergoods.service.impl;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.offcn.entity.PageResult;
import com.offcn.pojo.TbBrandExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.offcn.mapper.TbBrandMapper;
import com.offcn.pojo.TbBrand;
import com.offcn.sellergoods.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        //1.分页的查询
        PageHelper.startPage(pageNum,pageSize);

        //2.获取分页的对象
        Page<TbBrand> page = (Page<TbBrand>)brandMapper.selectByExample(null);

        //从对象中获取结果集每页总记录数
        return  new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void add(TbBrand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public TbBrand findOne(long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            brandMapper.deleteByPrimaryKey(id);
        }

    }

    @Override
    public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        TbBrandExample example = new TbBrandExample();

        if(brand != null){
            TbBrandExample.Criteria criteria = example.createCriteria();
            if(brand.getName() != null && brand.getName().length()>0){

                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if(brand.getFirstChar() != null && brand.getFirstChar().length()>0){
                criteria.andFirstCharEqualTo(brand.getFirstChar());
            }
        }

        Page<TbBrand> page = (Page<TbBrand>)brandMapper.selectByExample(example);



        return new PageResult(page.getTotal(),page.getResult());
    }
    @Override
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }


}
