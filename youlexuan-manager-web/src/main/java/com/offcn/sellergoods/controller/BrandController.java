package com.offcn.sellergoods.controller;
import java.util.List;
import java.util.Map;

import com.offcn.entity.PageResult;
import com.offcn.entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.offcn.pojo.TbBrand;
import com.offcn.sellergoods.service.BrandService;
/**
 * 品牌controller
 * @author Administrator
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }


    //分页查询
    @RequestMapping("/findPage")
    public PageResult findPage(int page,int rows){
        return brandService.findPage(page,rows);
    }

    //添加
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){

        try{
            brandService.add(brand);
            return new Result(true,"保存成功");
        }catch (Exception ex){
            ex.printStackTrace();
            return new Result(false,"保存失败");
        }

    }
    //根据id回显
    @RequestMapping("/findOne")
    public TbBrand findOne(long id){
        return brandService.findOne(id);

    }
    //修改保存
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand){

        try{
            brandService.update(brand);
            return new Result(true,"修改成功");
        }catch (Exception ex){
            ex.printStackTrace();
            return new Result(false,"修改失败");
        }

    }
    //删除
    @RequestMapping("/deleteById")
    public Result delete(long[] ids){
        try{
            brandService.delete(ids);
            return new Result(true,"删除成功");
        }catch (Exception ex){
            ex.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    //搜索
    @RequestMapping("/search")
    public PageResult Search(@RequestBody TbBrand tbBrand, int page,int rows){
        return brandService.findPage(tbBrand,page,rows);

    }
    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList (){
        return brandService.selectOptionList();
    }
}