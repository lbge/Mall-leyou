package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.commom.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 品牌管理Service
 *
 * @author Linbo Ge
 * @date 2020/7/22 9:38
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    public PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        //初始化example对象
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        //根据name模糊查询，或根据首字母模糊查询
        if (StringUtils.isNotBlank(key)) {
            //根据品牌名称name或者品牌首字母letter模糊查询
            criteria.andLike("name", "%" + key + "%").orEqualTo("letter", key);
        }
        //添加分页条件
        PageHelper.startPage(page, rows);
        //添加排序条件
        if (StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy + " " + (desc ? "desc" : "asc"));
        }
        List<Brand> brands = this.brandMapper.selectByExample(example);
        //包装成pageInfo
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        //包装成分页结果集返回,前端页面需要一个全部条数的信息，所以按需求封装构造函数
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 新增品牌
     *
     * @param brand
     * @param cids
     */
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {

        //先新增brand
        this.brandMapper.insertSelective(brand);

        //再新增中间表
        //使用insertSelective效率更高，不会拼接空的列
        //通用mapper只能操作单张表，要自己定义中间表的插入
        cids.forEach(cid -> {
            this.brandMapper.insertCategoryAndBrand(cid, brand.getId());
        });
    }

    /**
     * 根据分类id查询品牌列表
     * @param cid
     * @return
     */
    public List<Brand> queryBrandByCid(Long cid) {
        return this.brandMapper.selectBrandsByCid(cid);
    }

    /**
     * 根据id获取品牌
     * @param id
     * @return
     */
    public Brand queryBrandById(Long id) {
        return this.brandMapper.selectByPrimaryKey(id);
    }
}

