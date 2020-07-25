package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 品牌管理mapper
 *
 * @author Linbo Ge
 * @date 2020/7/22 9:36
 */
public interface BrandMapper extends Mapper<Brand> {

    @Insert("INSERT INTO tb_category_brand (category_id, brand_id) values (#{cid},#{bid})")
    void insertCategoryAndBrand(@Param("cid") Long cid, @Param("bid") Long bid);

    @Select("SELECT * FROM `tb_brand` a INNER JOIN tb_category_brand b ON a.id = b.brand_id WHERE b.category_id = #{cid}")
    List<Brand> selectBrandsByCid(Long cid);
}
