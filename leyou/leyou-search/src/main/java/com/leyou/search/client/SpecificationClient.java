package com.leyou.search.client;

import com.leyou.item.api.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Linbo Ge
 * @date 2020/7/27 14:47
 */
@FeignClient("item-service")
public interface SpecificationClient extends SpecificationApi {
}
