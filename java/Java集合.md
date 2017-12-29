## List、Set和Map的区别：
    前两者与Map的区别显而易见，前两者属于单个元素级别的存储，而Map是键值对的存储方式。那么List和Set的区别呢？在不分析源码的情况下，可以先理解为List采用线性结构存储，元素可以为null。Set采用离散存储方式，不允许存储值为null的元素且存储的元素不能重复。
## Collection和Collections的区别：
    Collection是集合类List和Set的父接口，规定了集合的通用方法，不同子类的具体实现略有不同。Collections是集合工具类，提供了一系列static方法辅助操作，常用的有排序sort()、转化为线程安全的synchronizedXXX()等。
## ArrayList
    1.arraylist不是线程安全的，只能用在单线程环境下
    2.arraylist支持序列化和克隆
    3.arraylist只有两个私有属性，如下，由此可以看出arraylist的底层实现是数组
    4.当调用无参构造方法时，会初始化容量为10；当参数为一个int类型的容量时，arraylist的初始化为指定容量；当参数为一个集合类型时，arraylist的大小初始化为集合的大小
    5.调用add方法时，会使用ensureCapacity(int capacity)方法先检测当前容量是否满足所要增加的元素的个数，如果不足则会对arraylist进行扩容，扩容至原容量的1.5倍+1，如果还不足，则会直接扩容至ensureCapcity方法中的capacity值的容量。
    6.在arraylist中间插入一组数据时，在检查容量和扩容之后，会将原本从插入位置index位置到最后的数据都拷贝到新扩容的空间，然后再把要插入的数据插入到原来数据腾出的位置
    7.在arraylist中删除数据时，会把后面的数据往前复制，保证中间没有无效的数据，然后对原本往前挪的位置设置为null

## HashMap和Hashtable的区别：
    HashMap允许使用null作为key或者value
    HashMap不是线程安全的

```java
public synchronized V put(K key, V value) {
    // 保证value值不为空，此处省略其代码
    // 保证key是不重复的，此处省略其代码
    //查过阈值则扩容，此处省略
    // Creates the new entry.
    Entry<K,V> e = tab[index];
    tab[index] = new Entry<>(hash, key, value, e);
    count++;
    return null;
}
```
    通过源码可以很明显看到其put方法使用synchronized关键字，在线程中这是实现线程安全的一种方式，所以Hashtable是线程安全的。

## ConcurrentHashMap的底层实现
		ConcurrentHashMap使用了线程锁分段技术，每次访问只允许一个线程修改哈希表的映射关系，所以是线程安全的

## HashMap 的实现原理
