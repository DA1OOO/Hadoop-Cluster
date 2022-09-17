# 查看所有服务器的节点运行情况
#!/bin/bash
for host in hadoop102 hadoop103 hadoop104
do
 echo =============== $host ===============
 ssh $host jps 
done