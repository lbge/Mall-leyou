package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Linbo Ge
 * @date 2020/7/21 16:38
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根据父节点返回子节点
     *
     * @param pid
     * @return
     */
    public List<Category> queryCategoriesByPid(Long pid) {
        Category record = new Category();
        record.setParentId(pid);
        //根据parentId查询类目
        return this.categoryMapper.select(record);
    }

    /**
     * 根据多个分类id查询分类名称
     * @param ids
     * @return
     */
    public List<String> queryNamesByIds(List<Long> ids) {
        List<Category> categories = this.categoryMapper.selectByIdList(ids);
        //将一个集合中的元素处理后放入另一个集合当中
        return categories.stream().map(category -> category.getName()).collect(Collectors.toList());
    }
}
