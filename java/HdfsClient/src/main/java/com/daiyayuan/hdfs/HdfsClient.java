package com.daiyayuan.hdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * HDFS客户端
 */
public class HdfsClient {
    /**
     * 创建文件夹
     */
    @Test
    public void mkdir() throws URISyntaxException, IOException {
        // name node的通讯端口
        URI uri = new URI("hdfs://hadoop102:8020");
        // 配置文件
        Configuration configuration = new Configuration();
        // 获取客户端对象
        FileSystem fileSystem = FileSystem.get(uri, configuration);
        // 创建文件夹
        fileSystem.mkdirs(new Path("/xiyou/huaguoshan"));
        // 关闭资源
        fileSystem.close();
    }
}
