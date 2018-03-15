## Redis学习日记
    Redis 是一个非关系型内存数据库，它可以用作数据库、缓存和消息中间件。 
    它支持字符串(strings),散列(hashes),列表(lists), 集合(sets),有序集合(sorted sets),
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
