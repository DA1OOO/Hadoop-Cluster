# 如果集群是第一次启动
# [da1@hadoop102 hadoop-3.2.4]$ 
hdfs namenode -format

# 启动HDFS
# [da1@hadoop102 hadoop-3.2.4]$ 
sbin/start-dfs.sh

# 在配置了 ResourceManager 的节点（hadoop103）启动 YARN
# [da1@hadoop103 hadoop-3.2.4]$ 
sbin/start-yarn.sh