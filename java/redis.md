## Redis学习日记
    Redis 是一个非关系型内存数据库，它可以用作数据库、缓存和消息中间件。 
    Redis支持五种数据类型：string（字符串），hash（哈希），list（列表），set（集合）及zset(sorted set：有序集合)。
    与范围查询,bitmaps,hyperloglogs和地理空间(geospatial)索引半径查询。 
    Redis内置了复制(replication),LUA脚本(Lua scripting), LRU驱动事件(LRU eviction),
    事务(transactions)和不同级别的磁盘持久化(persistence),并通过Redis哨兵(Sentinel)和自动分区(Cluster)提供高可用性(high availability).
### Redis安装
    Ubuntu上安装
```sh
$sudo apt-get update
$sudo apt-get install redis-server
```
    启动 Redis
```sh
$redis-server
```
    查看 redis 是否还在运行
```sh
$redis-cli
```
    这将打开一个 Redis 提示符，如下图所示：
```sh
redis 127.0.0.1:6379>
```
    在上面的提示信息中：127.0.0.1 是本机的IP地址，6379是 Redis 服务器运行的端口。现在输入 PING 命令，如下图所示：

```sh
redis 127.0.0.1:6379> ping
PONG
```
###Redis 事务
    Redis 事务可以一次执行多个命令， 并且带有以下两个重要的保证：
    
    批量操作在发送 EXEC 命令前被放入队列缓存。
    收到 EXEC 命令后进入事务执行，事务中任意命令执行失败，其余的命令依然被执行。
    在事务执行过程，其他客户端提交的命令请求不会插入到事务执行命令序列中。
    一个事务从开始到执行会经历以下三个阶段：
    
    开始事务。
    命令入队。
    执行事务。
