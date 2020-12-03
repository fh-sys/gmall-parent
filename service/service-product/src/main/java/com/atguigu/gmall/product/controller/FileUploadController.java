package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName FileUploadController
 * @Description: 商品文件上传控制器
 * @Author Hao
 * @Date 2020/12/1 11:38
 * @Version V1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("admin/product")
public class FileUploadController {

    @PostMapping("fileUpload")
    public Result fileUpload(@RequestParam("file")MultipartFile file) throws IOException, MyException {
        String url = "http://192.168.200.128:8080";
        String path = FileOutputStream.class.getResource("/tracker.conf").getPath();
        //初始化trackerClient
        ClientGlobal.init(path);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        String filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String[] urlSuffixs = storageClient.upload_file(file.getBytes(), filenameExtension, null);
        for (String suffix : urlSuffixs) {
            url = url+ "/"+suffix;
        }
        return Result.ok(url);
    }
}
