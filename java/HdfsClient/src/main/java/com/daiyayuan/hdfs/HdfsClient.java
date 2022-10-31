package com.daiyayuan.hdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * HDFS客户端
 */
public class HdfsClient {

    private FileSystem fileSystem;

    /**
     * 初始化客户端
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    @Before
    public void init() throws URISyntaxException, IOException, InterruptedException {
        // name node的通讯端口
        URI uri = new URI("hdfs://hadoop102:8020");
        // 配置文件
        Configuration configuration = new Configuration();
        // 用户
        String user = "daiyayuan";
        // 获取客户端对象
        fileSystem = FileSystem.get(uri, configuration, user);
    }

    /**
     * 关闭客户端
     * @throws IOException
     */
    @After
    public void close() throws IOException {
        // 关闭资源
        fileSystem.close();
    }

    /**
     * 创建文件夹
     * @throws IOException
     */
    @Test
    public void mkdir() throws IOException {
        // 创建文件夹
        fileSystem.mkdirs(new Path("/xiyou/huaguoshan"));
    }

    /**
     * 上传文件
     * @throws IOException
     */
    @Test
    public void upload() throws IOException {
        /**
         * 从本地向hdfs拷贝数据
         * Parameter1: 是否删除原数据
         * Parameter2: 是否允许覆盖
         * Parameter3: 原数据路径
         * Parameter4：目的地路径
          */
        fileSystem.copyFromLocalFile(false, false, new Path("C:\\Users\\Administrator\\Desktop\\Hadoop Cluster\\schedule.txt"), new Path("/xiyou/huaguoshan"));
    }
}
