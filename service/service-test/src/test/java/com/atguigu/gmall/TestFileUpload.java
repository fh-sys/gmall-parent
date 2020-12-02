package com.atguigu.gmall;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;

/**
 * @ClassName TestFileUpload
 * @Description:
 * @Author Hao
 * @Date 2020/12/1 11:43
 * @Version V1.0
 **/
public class TestFileUpload {
    public static void main(String[] args) throws IOException, MyException {
        String path = TestFileUpload.class.getResource("/tracker.conf").getPath();
        System.out.println("path = " + path);
        ClientGlobal.init(path);
        // 链接tracker
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        //获取storage
        StorageClient storageClient = new StorageClient(trackerServer,null);
        String localFilename = "d:/1.jpg";
        String[] jpgs = storageClient.upload_file(localFilename, "jpg", null);
        for (String jpg : jpgs) {
            System.out.println("jpg = " + jpg);
        }
    }

}
