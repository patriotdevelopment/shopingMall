package com.patriotdevelopment.feign;

import com.patriotdevelopment.service.MemberService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("member")
public interface MemberFeign  extends MemberService {
}
