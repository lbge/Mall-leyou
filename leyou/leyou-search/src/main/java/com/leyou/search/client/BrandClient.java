package com.leyou.search.client;

import com.leyou.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Linbo Ge
 * @date 2020/7/27 14:45
 */
@FeignClient("item-service")
public interface BrandClient extends BrandApi {
}
