package com.leyou.item.api;

import com.leyou.item.pojo.SpecParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Linbo Ge
 * @date 2020/7/23 9:59
 */
@RequestMapping("spec")
public interface SpecificationApi {

    /**
     * 根据条件查询参数列表
     * http://api.leyou.com/api/item/spec/params?gid=1
     * 参数在？后使用@RequestParam
     * @param gid
     * @return
     */
    @GetMapping("params")
    public List<SpecParam> queryParams(
            @RequestParam(value = "gid" ,required = false) Long gid,
            @RequestParam(value = "cid",required = false) Long cid,
            @RequestParam(value = "generic",required = false) Boolean generic,
            @RequestParam(value = "searching",required = false) Boolean searching
    );
}
