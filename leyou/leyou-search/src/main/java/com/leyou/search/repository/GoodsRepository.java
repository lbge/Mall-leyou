package com.leyou.search.repository;

import com.leyou.search.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Linbo Ge
 * @date 2020/7/27 16:36
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods,Long> {
}
