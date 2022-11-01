# Hadoop-Cluster
![image](https://user-images.githubusercontent.com/56857867/199201305-bb74047a-db5f-41e1-b044-07262fdcdd89.png)

#### 1.常用端口号
##### hadoop3.x
> HDFS NameNode 内部通常端口：8020/9000/9820

> HDFS NameNode 对用户的查询端口：9870

> Yarn查看任务运行情况的：8088

> 历史服务器：19888
##### hadoop2.x
> HDFS NameNode 内部通常端口：8020/9000

> HDFS NameNode 对用户的查询端口：50070

> Yarn查看任务运行情况的：8088

> 历史服务器：19888
#### 2.常用的配置文件
##### hadoop3.x 
> core-site.xml  hdfs-site.xml  yarn-site.xml  mapred-site.xml workers
##### hadoop2.x 
> core-site.xml  hdfs-site.xml  yarn-site.xml  mapred-site.xml slaves