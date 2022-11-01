# 如果集群是第一次启动，格式化集群
# [da1@hadoop102 hadoop-3.2.4]$ 
hdfs namenode -format

# 启动HDFS
# [da1@hadoop102 hadoop-3.2.4]$ 
cd /opt/module/hadoop-3.2.4
sbin/start-dfs.sh

# 在配置了 ResourceManager 的节点（hadoop103）启动 YARN
# [da1@hadoop103 hadoop-3.2.4]$ 
sbin/start-yarn.sh

# hadoop102中启动历史服务器
# [da1@hadoop102 hadoop]$ 
mapred --daemon start historyserver