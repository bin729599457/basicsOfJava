### List、Set和Map的区别：
    前两者与Map的区别显而易见，前两者属于单个元素级别的存储，而Map是键值对的存储方式。那么List和Set的区别呢？在不分析源码的情况下，可以先理解为List采用线性结构存储，元素可以为null。Set采用离散存储方式，不允许存储值为null的元素且存储的元素不能重复。
### Collection和Collections的区别：
    Collection是集合类List和Set的父接口，规定了集合的通用方法，不同子类的具体实现略有不同。Collections是集合工具类，提供了一系列static方法辅助操作，常用的有排序sort()、转化为线程安全的synchronizedXXX()等。
### ArrayList
    1.arraylist不是线程安全的，只能用在单线程环境下
    2.arraylist支持序列化和克隆
    3.arraylist只有两个私有属性，如下，由此可以看出arraylist的底层实现是数组
    4.当调用无参构造方法时，会初始化容量为10；当参数为一个int类型的容量时，arraylist的初始化为指定容量；当参数为一个集合类型时，arraylist的大小初始化为集合的大小
    5.调用add方法时，会使用ensureCapacity(int capacity)方法先检测当前容量是否满足所要增加的元素的个数，如果不足则会对arraylist进行扩容，扩容至原容量的1.5倍+1，如果还不足，则会直接扩容至ensureCapcity方法中的capacity值的容量。
    6.在arraylist中间插入一组数据时，在检查容量和扩容之后，会将原本从插入位置index位置到最后的数据都拷贝到新扩容的空间，然后再把要插入的数据插入到原来数据腾出的位置
    7.在arraylist中删除数据时，会把后面的数据往前复制，保证中间没有无效的数据，然后对原本往前挪的位置设置为null

### HashMap和Hashtable的区别：
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

### ConcurrentHashMap的底层实现
		ConcurrentHashMap使用了线程锁分段技术，每次访问只允许一个线程修改哈希表的映射关系，所以是线程安全的

### HashMap 的实现原理

####HashMap 概述
    HashMap 是基于哈希表的 Map 接口的非同步实现。此实现提供所有可选的映射操作，并允许使用 null 值和 null 键。此类不保证映射的顺序，特别是它不保证该顺序恒久不变。

    此实现假定哈希函数将元素适当地分布在各桶之间，可为基本操作（get 和 put）提供稳定的性能。迭代 collection 视图所需的时间与 HashMap 实例的“容量”（桶的数量）及其大小（键-值映射关系数）成比例。所以，如果迭代性能很重要，则不要将初始容量设置得太高或将加载因子设置得太低。也许大家开始对这段话有一点不太懂，不过不用担心，当你读完这篇文章后，就能深切理解这其中的含义了。

    需要注意的是：Hashmap 不是同步的，如果多个线程同时访问一个 HashMap，而其中至少一个线程从结构上（指添加或者删除一个或多个映射关系的任何操作）修改了，则必须保持外部同步，以防止对映射进行意外的非同步访问。

####HashMap 的数据结构
    在 Java 编程语言中，最基本的结构就是两种，一个是数组，另外一个是指针（引用），HashMap 就是通过这两个数据结构进行实现。HashMap实际上是一个“链表散列”的数据结构，即数组和链表的结合体。
    HashMap 底层就是一个数组结构，数组中的每一项又是一个链表。
    
####HashMap 源码进行一些学习，首先看一下构造函数：
```java

    public HashMap(int initialCapacity, float loadFactor) {
            if (initialCapacity < 0)
                throw new IllegalArgumentException("Illegal initial capacity: " +
                                                   initialCapacity);
            if (initialCapacity > MAXIMUM_CAPACITY)
                initialCapacity = MAXIMUM_CAPACITY;
            if (loadFactor <= 0 || Float.isNaN(loadFactor))
                throw new IllegalArgumentException("Illegal load factor: " +
                                                   loadFactor);
    
            // Find a power of 2 >= initialCapacity
            int capacity = 1;
            while (capacity < initialCapacity)
                capacity <<= 1;
    
            this.loadFactor = loadFactor;
            threshold = (int)Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
            table = new Entry[capacity];
            useAltHashing = sun.misc.VM.isBooted() &&
                    (capacity >= Holder.ALTERNATIVE_HASHING_THRESHOLD);
            init();
    }

```
我们着重看一下第 18 行代码table = new Entry[capacity];。这不就是 Java 中数组的创建方式吗？也就是说在构造函数中，其创建了一个 Entry 的数组，其大小为 capacity（目前我们还不需要太了解该变量含义），那么 Entry 又是什么结构呢？看一下源码：
```java
    static class Entry<K,V> implements Map.Entry<K,V> {
        final K key;
        V value;
        Entry<K,V> next;
        final int hash;
        ……
    }
```

