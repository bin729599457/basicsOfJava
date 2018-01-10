# 概念
    SQL (Structured Query Language) 数据库，指关系型数据库 - 主要代表：SQL Server，Oracle，MySQL(开源)，PostgreSQL(开源)。

    NoSQL（Not Only SQL）泛指非关系型数据库 - 主要代表：MongoDB，Redis，CouchDB。
# 主要区别
## 1.存储方式：
    SQL数据存在特定结构的表中；而NoSQL则更加灵活和可扩展，存储方式可以省是JSON文档、哈希表或者其他方式。
## 2. 表/数据集合的数据的关系
    在SQL中，必须定义好表和字段结构后才能添加数据，例如定义表的主键(primary key)，索引(index),触发器(trigger),存储过程(stored procedure)等。
    表结构可以在被定义之后更新，但是如果有比较大的结构变更的话就会变得比较复杂。
    在NoSQL中，数据可以在任何时候任何地方添加，不需要先定义表。
