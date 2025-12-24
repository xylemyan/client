package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "CommenClient")
public interface CommenClient {
    @GetMapping("/common/download")
    public void fileDownload(String fileName, Boolean delete);

    /**
     * 通用上传请求（单个）
     */
    @PostMapping("/common/upload")
    public AjaxResult uploadFile(MultipartFile file);

    /**
     * 通用上传请求（多个）
     */
    @PostMapping("/common/uploads")
    public AjaxResult uploadFiles(List<MultipartFile> files) ;

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download/resource")
    public void resourceDownload(String resource);
}
