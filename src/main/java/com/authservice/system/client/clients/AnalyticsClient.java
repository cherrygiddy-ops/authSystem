package com.authservice.system.client.clients;

import com.authservice.system.client.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "gg", configuration = FeignConfig.class)
public interface AnalyticsClient {
}
