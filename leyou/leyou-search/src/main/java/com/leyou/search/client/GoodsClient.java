package com.leyou.search.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Linbo Ge
 * @date 2020/7/27 14:14
 */
@FeignClient("item-service")
public interface GoodsClient extends GoodsApi {

}
