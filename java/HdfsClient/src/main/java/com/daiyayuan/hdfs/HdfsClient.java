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
     *
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
        // 代码中进行配置的优先级最高
        configuration.set("dfs.replication", "3");
        // 用户
        String user = "daiyayuan";
        // 获取客户端对象
        fileSystem = FileSystem.get(uri, configuration, user);
    }

    /**
     * 关闭客户端
     *
     * @throws IOException
     */
    @After
    public void close() throws IOException {
        // 关闭资源
        fileSystem.close();
    }

    /**
     * 创建文件夹
     *
     * @throws IOException
     */
    @Test
    public void mkdir() throws IOException {
        // 创建文件夹
        fileSystem.mkdirs(new Path("/xiyou/huaguoshan"));
    }

    /**
     * 上传文件
     *
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

    /**
     * 下载文件
     *
     * @throws IOException
     */
    @Test
    public void download() throws IOException {
        /**
         * 从hdfs向本地拷贝数据
         * Parameter1: 是否删除原数据
         * Parameter2: 原数据路径
         * Parameter3：目的地路径
         * Parameter4: 是否开启文件校验
         */
        fileSystem.copyToLocalFile(false, new Path("hdfs://hadoop102/xiyou/huaguoshan"), new Path("C:\\Users\\Administrator\\Desktop"), true);
    }

    /**
     * 删除文件
     *
     * @throws IOException
     */
    @Test
    public void delete() throws IOException {
        /**
         * 在hdfs中删除数据数据
         * Parameter1: 删除路径
         * Parameter2: 是否递归删除
         */
        fileSystem.delete(new Path("hdfs://hadoop102/xiyou"), true);
    }
}
