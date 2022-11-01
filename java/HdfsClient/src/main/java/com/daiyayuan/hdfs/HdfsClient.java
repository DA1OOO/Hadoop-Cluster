package com.daiyayuan.hdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.yarn.webapp.hamlet2.Hamlet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

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

    /**
     * 文件移动和更名
     *
     * @throws IOException
     */
    @Test
    public void move() throws IOException {
        /**
         * 文件移动和更名
         * Parameter1: 原文件路径
         * Parameter2: 目标文件路径
         */
        fileSystem.rename(new Path("/input/work.txt"), new Path("/dyy.txt"));
    }

    /**
     * 获取文件详情
     *
     * @throws IOException
     */
    @Test
    public void fileDetail() throws IOException {
        // 获取所有文件信息
        RemoteIterator<LocatedFileStatus> listFiles = fileSystem.listFiles(new Path("/"), true);
        // 遍历文件
        while (listFiles.hasNext()) {
            LocatedFileStatus fileStatus = listFiles.next();
            System.out.println("=====>" + fileStatus.getPath() + "<=====");
            System.out.println(fileStatus.getPermission());
            System.out.println(fileStatus.getOwner());
            System.out.println(fileStatus.getGroup());
            System.out.println(fileStatus.getLen());
            System.out.println(fileStatus.getModificationTime());
            System.out.println(fileStatus.getReplication());
            System.out.println(fileStatus.getBlockSize());
            System.out.println(fileStatus.getPath().getName());
            // 获取块信息
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            System.out.println(Arrays.toString(blockLocations));
        }
    }

    /**
     * 判断为文件或者文件夹
     *
     * @throws IOException
     */
    @Test
    public void isFileOrPack() throws IOException {
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/"));
        for (FileStatus status : fileStatuses) {
            if (status.isFile()) {
                // 为一个文件
                System.out.println("File:" + status.getPath().getName());
            } else {
                // 为一个目录
                System.out.println("Package:" + status.getPath().getName());
            }
        }

    }
}
