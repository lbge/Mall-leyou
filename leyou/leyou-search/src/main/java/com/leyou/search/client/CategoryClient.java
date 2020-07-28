package com.leyou.search.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Linbo Ge
 * @date 2020/7/27 14:46
 */
@FeignClient("item-service")
public interface CategoryClient extends CategoryApi {
}
