package com.leyou.item.api;

import com.leyou.item.pojo.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Linbo Ge
 * @date 2020/7/22 9:39
 */
@RequestMapping("brand")
public interface BrandApi {

    /**
     * 根据id获取品牌
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Brand queryBrandById(@PathVariable("id") Long id);
}