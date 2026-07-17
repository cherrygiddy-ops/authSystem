package com.authservice.system.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "EBOOK-INSIGHTS-SERVICE", configuration = FeignConfig.class)
public interface AnalyticsClient {
}
