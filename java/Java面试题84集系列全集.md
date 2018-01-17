## Java面试题84集系列全集

### 01.java中的参数传递——值传递、引用传递
    - 对象就是传引用
    - 原始类型就是传值
    - String类型因为没有提供自身修改的函数，每次操作都是新生成一个String对象，所以要特殊对待.
### 02.java的垮平台原理
    JVM也是一个软件，不同的平台有不同的版本。我们编写的Java源码，编译后会生成一种 .class 文件，称为字节码文件。
    Java虚拟机就是负责将字节码文件翻译成特定平台下的机器码然后运行。也就是说，只要在不同平台上安装对应的JVM，就可以运行字节码文件，运行我们编写的Java程序。
    而这个过程中，我们编写的Java程序没有做任何改变，仅仅是通过JVM这一”中间层“，就能在不同平台上运行，真正实现了”一次编译，到处运行“的目的。
    JVM是一个”桥梁“，是一个”中间件“，是实现跨平台的关键，Java代码首先被编译成字节码文件，再由JVM将字节码文件翻译成机器语言，从而达到运行Java程序的目的。
    注意：编译的结果不是生成机器码，而是生成字节码，字节码不能直接运行，必须通过JVM翻译成机器码才能运行。不同平台下编译生成的字节码是一样的，但是由JVM翻译成的机器码却不一样。
    所以，运行Java程序必须有JVM的支持，因为编译的结果不是机器码，必须要经过JVM的再次翻译才能执行。即使你将Java程序打包成可执行文件（例如 .exe），仍然需要JVM的支持。注意：跨平台的是Java程序，不是JVM。
    JVM是用C/C++开发的，是编译后的机器码，不能跨平台，不同平台下需要安装不同版本的JVM。
### 03.抽象类和接口的区别
    |参数|抽象类|接口|

    |默认的方法实现|它可以有默认的方法实现|接口完全是抽象的，它根本不存在方法的实现|
    |构造器|抽象类可以有构造器|接口不能有构造器|
    |与正常Java类的区别|除了不能实例化抽象类，它和普通Java类无任何区别|接口属于完全不同的类型|
    |访问修饰符|public、protected、default均可|默认public,不可使用其它修饰符|
    |速度|比接口速度快|稍微慢，因为需要时间去寻找在类中实现的方法|
    |添加新方法|如果往抽象类添加新方法，可以给它提供默认的实现。因此不需要改变现在的代码|往接口添加方法，那么必须改变实现该接口的所有类|
### 04.java中int占几个字节

    类型      存储需求     bit数    取值范围      备注
    int        4字节       4*8 
    short      2字节       2*8   －32768～32767
    long       8字节       8*8
    byte       1字节       1*8     －128～127
    float      4字节       4*8             float类型的数值有一个后缀F(例如：3.14F)
    double     8字节       8*8             没有后缀F的浮点数值(如3.14)默认为double类型
    char       2字节       2*8
    boolean    1字节       1*8    false、true
    
### 05.java面向对象的特征
    面向对象的三个基本特征是：封装、继承、多态。
    封装，也就是把客观事物封装成抽象的类，并且类可以把自己的数据和方法只让可信的类或者对象操作，对不可信的进行信息隐藏。
    面向对象编程(OOP) 语言的一个主要功能就是“继承”。 ...
    要实现继承，可以通过“继承”（Inheritance）和“组合”（Composition）来实现。
### 06.装箱和拆箱
    自动装箱就是Java自动将原始类型值转换成对应的对象，比如将int的变量转换成Integer对象，这个过程叫做装箱，反之将Integer对象转换成int类型值，这个过程叫做拆箱。
    因为这里的装箱和拆箱是自动进行的非人为转换，所以就称作为自动装箱和拆箱。原始类型byte,short,char,int,long,float,double和boolean对应的封装类为Byte,Short,Character,Integer,Long,Float,Double,Boolean。
### 07.==和equals的区别
    基本数据类型，也称原始数据类型。byte,short,char,int,long,float,double,boolean 
    他们之间的比较，应用双等号（==）,比较的是他们的值。
    当他们用（==）进行比较的时候，比较的是他们在内存中的存放地址，所以，除非是同一个new出来的对象，他们的比较后的结果为true，否则比较后结果为false。 
    JAVA当中所有的类都是继承于Object这个基类的，在Object中的基类中定义了一个equals的方法，这个方法的初始行为是比较对象的内存地 址，但在一些类库当中这个方法被覆盖掉了，如String,Integer,Date在这些类当中equals有其自身的实现，而不再是比较类在堆内存中的存放地址了。
    对于复合数据类型之间进行equals比较，在没有覆写equals方法的情况下，他们之间的比较还是基于他们在内存中的存放位置的地址值的，因为Object的equals方法也是用双等号（==）进行比较的，所以比较后的结果跟双等号（==）的结果相同。
    我们可以改写equals()方法, 根据需要来比较两个对象.
    equals默认情况下 和 "=="都是比较对象的内存地址, 而非hashCode().
    hashCode只是与内存地址有关.
    相同的对象（相同的hashcode和内存地址）,反之相同的hashcode不一定是相同的对象.
### 08.java中String、StringBuffer、StringBuilder的区别
- 1.可变与不可变
　　String类中使用字符数组保存字符串，如下就是，因为有“final”修饰符，所以可以知道string对象是不可变的。
```java
private final char value[];
```
　　StringBuilder与StringBuffer都继承自AbstractStringBuilder类，在AbstractStringBuilder中也是使用字符数组保存字符串，如下就是，可知这两种对象都是可变的。
```java
char[] value;
```

- 2.是否多线程安全
　　String中的对象是不可变的，也就可以理解为常量，显然线程安全。
　　AbstractStringBuilder是StringBuilder与StringBuffer的公共父类，定义了一些字符串的基本操作，如expandCapacity、append、insert、indexOf等公共方法。
　　StringBuilder并没有对方法进行加同步锁，所以是非线程安全的。　
    　StringBuffer对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的看如下源码：

```java
public synchronized StringBuffer reverse() {
    super.reverse();
    return this;
}

public int indexOf(String str) {
    return indexOf(str, 0);        
//存在 public synchronized int indexOf(String str, int fromIndex) 方法
}
```

- 3.StringBuilder与StringBuffer共同点

        StringBuilder与StringBuffer有公共父类AbstractStringBuilder(抽象类)。
        抽象类与接口的其中一个区别是：抽象类中可以定义一些子类的公共方法，子类只需要增加新的功能，不需要重复写已经存在的方法；而接口中只是对方法的申明和常量的定义。

        StringBuilder、StringBuffer的方法都会调用AbstractStringBuilder中的公共方法，如super.append(...)。只是StringBuffer会在方法上加synchronized关键字，进行同步。

### 09.字符流和字节流的区别

    字符流处理的单元为2个字节的Unicode字符，分别操作字符、字符数组或字符串，而字节流处理单元为1个字节， 操作字节和字节数组。
    所以字符流是由Java虚拟机将字节转化为2个字节的Unicode字符为单位的字符而成的，所以它对多国语言支持性比较好！如果是 音频文件、图片、歌曲，就用字节流好点，如果是关系到中文（文本）的，用字符流好点. 
    所有文件的储存是都是字节（byte）的储存，在磁盘上保留的并不是文件的字符而是先把字符编码成字节，再储存这些字节到磁盘。在读取文件（特别是文本文件）时，也是一个字节一个字节地读取以形成字节序列. 
    字节流可用于任何类型的对象，包括二进制对象，而字符流只能处理字符或者字符串； 2. 字节流提供了处理任何类型的IO操作的功能，但它不能直接处理Unicode字符，而字符流就可以


### 09.讲一下java中的集合
### 10.ArrayList 和LinkedList的区别
### 11.HashMap和HashTable的区别
### 12.实现一个拷贝文件的工具类要使用字节流还是字符串
### 13.线程的的实现方式？怎么启动线程？怎么区分线程？
### 14.线程并发库和线程池的作用
### 15.设计模式和常用的设计模式
### 16.http get post请求的区别
### 17.说说你对Servlet的理解
### 18.Servlet的生命周期
### 19.Servlet中forward和redirect的区别
### 20.jsp和Servlet的相同点和不同点
### 21.内置对象和四大作用域和页面传值
### 22.Session和Cookie的区别和使用场景
### 23.mvc模式和mvc各部分的实现
### 24.数据库分类和常用数据库
### 25.关系型数据库的三范式
### 26.事务的四大特征
### 27.mysql数据库最大连接数
### 28.mysql和oracle的分页语句
### 29.触发器的使用场景？
### 30.存储过程的优点
### 31.jdbc调用存储过程
### 32.简单说一下你对jdbc的理解
### 33.写一个jdbc的访问oracle的列子
### 34.jdbc中preparedStatement比Statement的好处
### 35.数据库连接池的作用

### 46.简单介绍一下MVC模式
### 47.简单说一下对mvc框架的理解
### 48.struts2的执行流程或者struts2的原理
### 49.Struts2的拦截器是什么
### 50.Spring MVC的执行流程
### 51.SpringMVC和Struts2的不同
### 52.简单介绍一下Spring或者Spring的两大核心
### 53.AOP是什么？都用它做什么？
### 54.Spring事务的传播特性和隔离级别
### 55.ORM是什么？ORM框架是什么？
### 56.ibatis和hibernate有什么不同
### 57.hibernate对象状态及其转换
### 58：hibernate的缓存
### 59.webservice的使用场景
### 60.activiti的简单介绍
### 61.linux的使用场景
### 62.linux常用命令
### 65：数据库优化方面的事情
### 66：如果查询和定位慢查询
### 67：数据库优化之数据库表设计遵循范式
### 68：选择合适的数据库引擎
### 69：选择合适的索引
### 70：使用索引的一些技巧1
### 71：数据库优化之分表
### 72：数据库的读写分离
### 73：数据库优化之缓存
### 74：sql语句优化小技巧
### 75：批量插入几百万条数据
### 77：redis的使用场景
### 78：redis存储对象的方式
### 79：redis数据淘汰机制
### 80：java访问redis级redis集群
