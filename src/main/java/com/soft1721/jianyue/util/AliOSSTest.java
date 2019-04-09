package com.soft1721.jianyue.util;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

import java.io.File;
import java.net.URL;
import java.util.Date;

public class AliOSSTest {
    public static void main(String[] args) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAIBI2XS1ZaGsbD";
        String accessKeySecret = "DdUsJHWDHle23PdT35QQEAgOvrTVVi";
        String bucketName = "smilesys";
        String filedir = "avatar/";
        String fileKey = "hello.jpg";

        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileKey, new File("D:\\pic\\head1.jpg"));
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, filedir + fileKey, expiration);
        System.out.println(url);
        ossClient.shutdown();
    }
}