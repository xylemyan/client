package com.cruoyi.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ruoyi-server", url = "http://localhost:8081", contextId = "TeacherGrade")
public interface TeacherGradeClient {
}
