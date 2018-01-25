package com.hubert.EurekaService.serviceInterfase;

import com.hubert.EurekaService.hystrix.ComputeClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="compute-service",fallback = ComputeClientHystrix.class)  //eureka注册的服务提供方  fallback 回调 ComputeClientHystrix
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
