### 01.java中的参数传递——值传递、引用传递
    对象就是传引用
    原始类型就是传值
    String类型因为没有提供自身修改的函数，每次操作都是新生成一个String对象，所以要特殊对待.
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
 
    -如果你拥有一些方法并且想让它们中的一些有默认实现，那么使用抽象类吧。
    -如果你想实现多重继承，那么你必须使用接口。由于Java不支持多继承，子类不能够继承多个类，但可以实现多个接口。因此你就可以使用接口来解决它。
    -如果基本功能在不断改变，那么就需要使用抽象类。如果不断改变基本功能并且使用接口，那么就需要改变所有实现了该接口的类。
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
###String的基本用法
        

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

### 字符流和字节流的区别

    字符流处理的单元为2个字节的Unicode字符，分别操作字符、字符数组或字符串，而字节流处理单元为1个字节， 操作字节和字节数组。
    所以字符流是由Java虚拟机将字节转化为2个字节的Unicode字符为单位的字符而成的，所以它对多国语言支持性比较好！如果是 音频文件、图片、歌曲，就用字节流好点，如果是关系到中文（文本）的，用字符流好点. 
    所有文件的储存是都是字节（byte）的储存，在磁盘上保留的并不是文件的字符而是先把字符编码成字节，再储存这些字节到磁盘。在读取文件（特别是文本文件）时，也是一个字节一个字节地读取以形成字节序列. 
    字节流可用于任何类型的对象，包括二进制对象，而字符流只能处理字符或者字符串； 2. 字节流提供了处理任何类型的IO操作的功能，但它不能直接处理Unicode字符，而字符流就可以

### final、finally、finalize的区别
- 1、final 修饰符（关键字）
        final用于控制成员、方法或者是一个类是否可以被重写或者继承等功能，如果要学好java，那么这个关键字很重要，必须掌握。如果类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。将变量或者方法声明为final，可以保证他们在使用中不被改变。其初始化可以在两个地方：一是其定义处，也就是说，在final变量定义时直接给其赋值；二是构造函数中。这2个地方只能选其一，要么在定义处直接给其赋值，要么在构造函数中给值，并且在以后的引用中，只能读取，不可修改。被声明为final的方法也同样只能使用，不能重写。

- 2、finally(用于异常处理)
        一般是用于异常处理中，提供finally块来执行任何的清楚操作，try{} catch(){} finally{}。finally关键字是对java异常处理模型的最佳补充。finally结构使代码总会执行，不关有无异常发生。使得finally可以维护对象的内部状态，并可以清理非内存资源。finally在try,catch中可以有，可以没有。如果trycatch中有finally则必须执行finally快中的操作。一般情况下，用于关闭文件的读写操作，或者是关闭数据库的连接等等。

- 3、finalize（用于垃圾回收）
         finalize这个是方法名。在java中，允许使用finalize()方法在垃圾收集器将对象从内存中清理出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用是对这个对象调用的。它是Object类中定义的，因此，所有的类都继承了它。finalize()方法是在垃圾收集器删除对象之前对这个对象调用的。

### Iterator和 for each的区别： 

    1.for each 不能删除集合元素 
    2.Iterator 只能使用自身的remove()方法来删除元素，不能用集合的删除操作 
    3.ArrayList里，for循环较快，LinkedList里，使用iterator较快

### 位运算符

    假设a = 60，b = 13;它们的二进制格式表示将如下：

    A = 0011 1100
    B = 0000 1101

-----------------

    A&b = 0000 1100
    A | B = 0011 1101
    A ^ B = 0011 0001
    ~A= 1100 0011

### char 型变量中能不能存贮一个中文汉字?为什么?
    char 型变量是用来存储 Unicode 编码的字符的， unicode 编码字符集中包含了汉字，所以，char 型变量中当然可以存储汉字。
    不过，如果某个特殊的汉字没有被包含在 unicode 编码字符集中，那么，这个 char 型变量中就不能存储这个特殊汉字。 
补充说明： unicode 编码占用两个字节，所以， char 类型的变量也是占用两个字节。

### Java数组与内存控制

    JVM的内存可分为3个区：堆(heap)、栈(stack)和方法区(method)
    堆区:
    1.存储的全部是对象，每个对象都包含一个与之对应的class的信息。(class的目的是得到操作指令)
    2.jvm只有一个堆区(heap)被所有线程共享，堆中不存放基本类型和对象引用，只存放对象本身栈区:1.每个线程包含一个栈区，栈中只保存基础数据类型的对象和自定义对象的引用(不是对象)，对象都存放在堆区中
    3.每个栈中的数据(原始类型和对象引用)都是私有的，其他栈不能访问。3.栈分为3个部分：基本类型变量区、执行环境上下文、操作指令区(存放操作指令)。方法区:1.又叫静态区，跟堆一样，被所有的线程共享。方法区包含所有的class和static变量。
    4.方法区中包含的都是在整个程序中永远唯一的元素，如class，static变量。

### 12.实现一个拷贝文件的工具类要使用字节流还是字符串
    拷贝的文件具有不确定性，可能有字节流（图片、声音等）或字符流，为考虑通用性要使用字节流
### 13.线程的的实现方式？怎么启动线程？怎么区分线程？
    1、继承Thread类      
    2、实现Runnable接口
    区分:可以Set线程名，或获得线程Id
### 线程生命周期
    当线程被创建并启动以后，它既不是一启动就进入了执行状态，也不是一直处于执行状态。在线程的生命周期中，它要经过新建(New)、就绪（Runnable）、运行（Running）、阻塞(Blocked)和死亡(Dead)5种状态。尤其是当线程启动以后，它不可能一直"霸占"着CPU独自运行，所以CPU需要在多条线程之间切换，于是线程状态也会多次在运行、阻塞之间切换
    
    1. 新建状态，当程序使用new关键字创建了一个线程之后，该线程就处于新建状态，此时仅由JVM为其分配内存，并初始化其成员变量的值
    
    2. 就绪状态，当线程对象调用了start()方法之后，该线程处于就绪状态。Java虚拟机会为其创建方法调用栈和程序计数器，等待调度运行
    
    3. 运行状态，如果处于就绪状态的线程获得了CPU，开始执行run()方法的线程执行体，则该线程处于运行状态
    
    4. 阻塞状态，当处于运行状态的线程失去所占用资源之后，便进入阻塞状态
    
    5. 在线程的生命周期当中，线程的各种状态的转换过程
### sleep和wait,yield的区别
    在这3个在Java中能够用来暂停线程的方法中，sleep()和yield()方法是定义在Thread类中，而wait()方法是定义在Object类中的.
    wait()和sleep()的关键的区别在于，wait()是用于线程间通信的，而sleep()是用于短时间暂停当前线程。
    更加明显的一个区别在于，当一个线程调用wait()方法的时候，会释放它锁持有的对象的管程和锁，但是调用sleep()方法的时候，不会释放他所持有的管程。
    回到yield()方法上来，与wait()和sleep()方法有一些区别，它仅仅释放线程所占有的CPU资源，从而让其他线程有机会运行，
    但是并不能保证某个特定的线程能够获得CPU资源。谁能获得CPU完全取决于调度器，在有些情况下调用yield方法的线程甚至会再次得到CPU资源。
    所以，依赖于yield方法是不可靠的，它只能尽力而为。
### 乐观锁与悲观锁
    悲观锁：假定会发生并发冲突，屏蔽一切可能违反数据完整性的操作。
    Java synchronized 就属于悲观锁的一种实现，每次线程要修改数据时都先获得锁，保证同一时刻只有一个线程能操作数据，其他线程则会被block。
    
    乐观锁：假设不会发生并发冲突，只在提交操作时检查是否违反数据完整性。
    乐观锁一般来说有以下2种方式：
    使用数据版本（Version）记录机制实现，这是乐观锁最常用的一种实现方式。何谓数据版本？即为数据增加一个版本标识，一般是通过为数据库表增加一个数字类型的 “version” 字段来实现。当读取数据时，将version字段的值一同读出，数据每更新一次，对此version值加一。当我们提交更新的时候，判断数据库表对应记录的当前版本信息与第一次取出来的version值进行比对，如果数据库表当前版本号与第一次取出来的version值相等，则予以更新，否则认为是过期数据。
    使用时间戳（timestamp）。乐观锁定的第二种实现方式和第一种差不多，同样是在需要乐观锁控制的table中增加一个字段，名称无所谓，字段类型使用时间戳（timestamp）, 和上面的version类似，也是在更新提交的时候检查当前数据库中数据的时间戳和自己更新前取到的时间戳进行对比，如果一致则OK，否则就是版本冲突。
### Volatile 变量
    volatile是一个特殊的修饰符，只有成员变量才能使用它。在Java并发程序缺少同步类的情况下，多线程对成员变量的操作对其它线程是透明的。
    volatile变量可以保证下一个读取操作会在前一个写操作之后发生.
    
    Volatile 变量具有 synchronized 的可见性特性，但是不具备
    原子特性(原子是世界上的最小单位，具有不可分割性。比如 a=0；（a非long和double类型） 这个操作是不可分割的，那么我们说这个操作时原子操作。
    再比如：a++； 这个操作实际是a = a + 1；是可分割的，所以他不是一个原子操作。)。
    volatile关键字具有许多特性，其中最重要的特性就是保证了用volatile修饰的变量对所有线程的可见性。
    这里的可见性是什么意思呢？当一个线程修改了变量的值，新的值会立刻同步到主内存当中。而其他线程读取这个变量的时候，也会从主内存中拉取最新的变量值。
    这就是说线程能够自动发现 volatile 变量的最新值。
    Volatile 变量可用于提供线程安全，但是只能应用于非常有限的一组:
    1.运行结果并不依赖变量的当前值，或者能够确保只有单一的线程修改变量的值。
    2.变量不需要与其他的状态变量共同参与不变约束。
    
    第一条很好理解，就是上面的代码例子。第二条是什么意思呢？可以看看下面这个场景：
    volatile static int start = 3;
    volatile static int end = 6;
    线程A执行如下代码：
    while (start < end){
      //do something
    }
    线程B执行如下代码：
    start+=3;
    end+=3;
    这种情况下，一旦在线程A的循环中执行了线程B，start有可能先更新成6，造成了一瞬间 start == end，从而跳出while循环的可能性。
    如果读操作远远大于写操作，volatile 变量还可以提供优于锁的性能优势。

### 14.线程并发库和线程池的作用

### 15.设计模式和常用的设计模式
  ####单例模式(singleton)
    有些时候，允许自由创建某个类的实例没有意义，还可能造成系统性能下降。如果一个类始终只能创建一个实例，则这个类被称为单例类，这种模式就被称为单例模式。
        一般建议单例模式的方法命名为：getInstance()，这个方法的返回类型肯定是单例类的类型了。getInstance方法可以有参数，这些参数可能是创建类实例所需要的参数，
        当然，大多数情况下是不需要的
```java
    public class Singleton {
        public staticvoid main(String[] args)
        {
           //创建Singleton对象不能通过构造器，只能通过getInstance方法
           Singleton s1 = Singleton.getInstance();
           Singleton s2 = Singleton.getInstance();
           //将输出true
           System.out.println(s1 == s2);
        }
        //使用一个变量来缓存曾经创建的实例
        private static Singleton instance;
        //将构造器使用private修饰，隐藏该构造器
        private Singleton(){
           System.out.println("Singleton被构造！");
        }
        //提供一个静态方法，用于返回Singleton实例
        //该方法可以加入自定义的控制，保证只产生一个Singleton对象
        public static Singleton getInstance()
        {
           //如果instance为null，表明还不曾创建Singleton对象
           //如果instance不为null，则表明已经创建了Singleton对象，将不会执行该方法
           if (instance == null)
           {
               //创建一个Singleton对象，并将其缓存起来
               instance = new Singleton();
           }
           return instance;
        }
    }
 ```
 
    单例模式主要有如下两个优势：
    1)      减少创建Java实例所带来的系统开销
    2)      便于系统跟踪单个Java实例的生命周期、实例状态等。
    
    
   ####简单工厂(StaticFactory Method)
    简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例。简单工厂模式是工厂模式家族中最简单实用的模式，可以理解为是不同工厂模式的一个特殊实现。
    A实例调用B实例的方法，称为A依赖于B。如果使用new关键字来创建一个B实例（硬编码耦合），然后调用B实例的方法。
    一旦系统需要重构：需要使用C类来代替B类时，程序不得不改写A类代码。而用工厂模式则不需要关心B对象的实现、创建过程。
    Output，接口
    public interface Output
    {
        //接口里定义的属性只能是常量
        intMAX_CACHE_LINE = 50;
        //接口里定义的只能是public的抽象实例方法
        void out();
        void getData(String msg);
    }
    Printer，Output的一个实现
    //让Printer类实现Output
    public class Printer implements Output
    {
        private String[] printData = new String[MAX_CACHE_LINE];
        //用以记录当前需打印的作业数
        privateintdataNum = 0;
        public void out()
        {
           //只要还有作业，继续打印
           while(dataNum > 0)
           {
               System.out.println("打印机打印：" + printData[0]);
               //把作业队列整体前移一位，并将剩下的作业数减1
               System.arraycopy(printData , 1, printData, 0, --dataNum);
           }
        }
        public void getData(String msg)
        {
           if (dataNum >= MAX_CACHE_LINE)
           {
               System.out.println("输出队列已满，添加失败");
           }else
           {
               //把打印数据添加到队列里，已保存数据的数量加1。
               printData[dataNum++] = msg;
           }
        }
    }
    BetterPrinter，Output的一个实现
    public class BetterPrinter implements Output
    {
        private String[] printData = new String[MAX_CACHE_LINE * 2];
        //用以记录当前需打印的作业数
        private int dataNum = 0;
        public void out()
        {
           //只要还有作业，继续打印
           while(dataNum > 0)
           {
               System.out.println("高速打印机正在打印：" + printData[0]);
               //把作业队列整体前移一位，并将剩下的作业数减1
               System.arraycopy(printData , 1, printData, 0, --dataNum);
           }
        }
        public void getData(String msg)
        {
           if (dataNum >= MAX_CACHE_LINE * 2)
           {
               System.out.println("输出队列已满，添加失败");
           }
           else
           {
               //把打印数据添加到队列里，已保存数据的数量加1。
               printData[dataNum++] = msg;
           }
        }
    }
    OutputFactory，简单工厂类
        public Output getPrinterOutput(String type) {
           if (type.equalsIgnoreCase("better")) {
               returnnew BetterPrinter();
           } else {
               returnnew Printer();
           }
        }
    Computer
    public class Computer
    {
        private Output out;
        public Computer(Output out)
        {
           this.out = out;
        }
        //定义一个模拟获取字符串输入的方法
        public void keyIn(String msg)
        {
           out.getData(msg);
        }
        //定义一个模拟打印的方法
        publicvoid print()
        {
           out.out();
        }
        publicstaticvoid main(String[] args)
        {
           //创建OutputFactory
           OutputFactory of = new OutputFactory();
           //将Output对象传入，创建Computer对象
           Computer c = new Computer(of.getPrinterOutput("normal"));
           c.keyIn("建筑永恒之道");
           c.keyIn("建筑模式语言");
           c.print();
           c = new Computer(of.getPrinterOutput("better"));
           c.keyIn("建筑永恒之道");
           c.keyIn("建筑模式语言");
           c.print();
        }
    使用简单工厂模式的优势：让对象的调用者和对象创建过程分离，当对象调用者需要对象时，直接向工厂请求即可。从而避免了对象的调用者与对象的实现类以硬编码方式耦合，以提高系统的可维护性、可扩展性。工厂模式也有一个小小的缺陷：当产品修改时，工厂类也要做相应的修改。

  ####代理模式(Proxy)
    代理模式是一种应用非常广泛的设计模式，当客户端代码需要调用某个对象时，客户端实际上不关心是否准确得到该对象，它只要一个能提供该功能的对象即可，此时我们就可返回该对象的代理（Proxy）。
    代理就是一个Java对象代表另一个Java对象来采取行动。如：
```java
    public class ImageProxy implements Image
{
    //组合一个image实例，作为被代理的对象
    private Image image;
    //使用抽象实体来初始化代理对象
    public ImageProxy(Image image)
    {
       this.image = image;
    }
    /**
     * 重写Image接口的show()方法
     * 该方法用于控制对被代理对象的访问，
     * 并根据需要负责创建和删除被代理对象
     */
    public void show()
    {
       //只有当真正需要调用image的show方法时才创建被代理对象
       if (image == null)
       {
           image = new BigImage();
       }
       image.show();
    }
}
```
    调用时，先不创建：
    Image image = new ImageProxy(null);
    Hibernate默认启用延迟加载，当系统加载A实体时，A实体关联的B实体并未被加载出来，A实体所关联的B实体全部是代理对象——只有等到A实体真正需要访问B实体时，系统才会去数据库里抓取B实体所对应的记录。
    借助于Java提供的Proxy和InvocationHandler，可以实现在运行时生成动态代理的功能，而动态代理对象就可以作为目标对象使用，而且增强了目标对象的功能。如：
    Panther
```java
    public interface Panther
{
    //info方法声明
    public void info();
    //run方法声明
    public void run();
}
```
    GunPanther
```java
public class GunPanther implements Panther
{
    //info方法实现，仅仅打印一个字符串
    publicvoid info()
    {
       System.out.println("我是一只猎豹！");
    }
    //run方法实现，仅仅打印一个字符串
    publicvoid run()
    {
       System.out.println("我奔跑迅速");
    }
}
```
    MyProxyFactory，创建代理对象
```java
public class MyProxyFactory
{
    //为指定target生成动态代理对象
    publicstatic Object getProxy(Object target)
       throws Exception
    {
       //创建一个MyInvokationHandler对象
       MyInvokationHandler handler =
           new MyInvokationHandler();
       //为MyInvokationHandler设置target对象
       handler.setTarget(target);
       //创建、并返回一个动态代理
       return Proxy.newProxyInstance(target.getClass().getClassLoader()
           , target.getClass().getInterfaces(), handler);
    }
}
```
    MyInvokationHandler，增强代理的功能
```java
public class MyInvokationHandler implements InvocationHandler
{
    //需要被代理的对象
    private Object target;
    publicvoid setTarget(Object target)
    {
       this.target = target;
    }
    //执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
    public Object invoke(Object proxy, Method method, Object[] args)
       throws Exception
    {
       TxUtil tx = new TxUtil();
       //执行TxUtil对象中的beginTx。
       tx.beginTx();
       //以target作为主调来执行method方法
       Object result = method.invoke(target , args);
       //执行TxUtil对象中的endTx。
       tx.endTx();
       return result;
    }
}
```
    TxUtil
```java
public class TxUtil
{
    //第一个拦截器方法:模拟事务开始
    public void beginTx()
    {
       System.out.println("=====模拟开始事务=====");
    }
    //第二个拦截器方法:模拟事务结束
    public void endTx()
    {
       System.out.println("=====模拟结束事务=====");
    }
}
```
测试
```java
    public static void main(String[] args)
       throws Exception
    {
       //创建一个原始的GunDog对象，作为target
       Panther target = new GunPanther();
       //以指定的target来创建动态代理
       Panther panther = (Panther)MyProxyFactory.getProxy(target);
       //调用代理对象的info()和run()方法
       panther.info();
       panther.run();
    }
```
    Spring所创建的AOP代理就是这种动态代理。但是SpringAOP更灵活。

### 16.http get post请求的区别
    Get和Post是两种Http请求方式：
    1) Get:从服务器请求数据，而且请求包含在Url之中，如：
    /test/demo_form.asp?name1=value1&name2=value2
    有长度限制；可以用来作电子书签；敏感数据不应该用Get请求；可以缓存；保存在浏览器历史记录之中；仅仅用来检索数据
    2) Post:提交数据到服务器，如：
    POST /test/demo_form.asp HTTP/1.1
    Host: w3schools.com
    name1=value1&name2=value2
    不可以缓存；不存在浏览历史记录当中；没有长度限制；不可用作电子书签；POST请求相对GET请求更加安全；
    GET被强制服务器支持
    All general-purpose servers MUST support the methods GET and HEAD. All other methods are OPTIONAL.
    GET 通常用于请求服务器发送某个资源。在HTTP/1.1中，要求服务器实现此方法；POST请求方法起初是用来向服务器输入数据的。在HTTP/1.1中，POST方法是可选被实现的，没有明确规定要求服务器实现。
    浏览器对URL的长度有限制，所以GET请求不能代替POST请求发送大量数据
    RFC 2616 (Hypertext Transfer Protocol — HTTP/1.1) states in section 3.2.1 that there is no limit to the length of an URI (URI is the official term for what most people call a URL)
    RFC 2616 中明确对 uri 的长度并没有限制。不过虽然在RFC中并没有对uri的长度进行限制，但是各大浏览器厂家在实现的时候限制了URL的长度，可查到的是IE对长度限制为2083；而chrome遇到长度很长的URL时，会直接崩溃。
    所以这条结论算是正确的。
    GET请求发送数据更小
    只能通过写代码验证了：下面第一个文件是服务器代码，作用是在客户端发送GET和POST请求的时候返回200状态码。第二个文件是客户端HTML文件，点击两个button，分别发送GET请求和POST请求。
    GET请求是幂等的
    A request method is considered "idempotent" if the intended effect on the server of multiple identical requests with that method is the same as the effect for a single such request. Of the request methods defined by this specification, PUT, DELETE, and safe request methods are idempotent.
    从上面可以看到GET请求是安全的，在幂等性中说PUT和DELETE以及安全method都是幂等的，所以GET自然也被包括了。
    其他的请求方式：
    HEAD：Same as GET but returns only HTTP headers and no document body
    PUT： Uploads a representation of the specified URI
    DELETE： Deletes the specified resource
    OPTIONS： Returns the HTTP methods that the server supports
    CONNECT： Converts the request connection to a transparent TCP/IP tunnel

### 18.Servlet的生命周期
    Servlet 通过调用 init () 方法进行初始化。
    Servlet 调用 service() 方法来处理客户端的请求。
    Servlet 通过调用 destroy() 方法终止（结束）。
    最后，Servlet 是由 JVM 的垃圾回收器进行垃圾回收的。
### 19.Servlet中forward和redirect的区别
    1.从地址栏显示来说
    forward是服务器请求资源,服务直接访问目标地址的URL,把那个URL的响应内容读取过来,然后把这些内容再发给浏览器.浏览器根本不知道服务器发送的内容从哪里来的,所以它的地址栏还是原来的地址.
    redirect是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址.所以地址栏显示的是新的URL.
    2.从数据共享来说
    forward:转发页面和转发到的页面可以共享request里面的数据.
    redirect:不能共享数据.
    3.从运用地方来说
    forward:一般用于用户登陆的时候,根据角色转发到相应的模块.
    redirect:一般用于用户注销登陆时返回主页面和跳转到其它的网站等.
    解释一
    一句话，转发是服务器行为，重定向是客户端行为。为什么这样说呢，这就要看两个动作的工作流程：
    转发过程：客户浏览器发送http请求----》web服务器接受此请求--》调用内部的一个方法在容器内部完成请求处理和转发动作----》将目标资源发送给客户;在这里，转发的路径必须是同一个web容器下的url，其不能转向到其他的web路径上去，中间传递的是自己的容器内的request。在客户浏览器路径栏显示的仍然是其第一次访问的路径，也就是说客户是感觉不到服务器做了转发的。转发行为是浏览器只做了一次访问请求。
    重定向过程：客户浏览器发送http请求----》web服务器接受后发送302状态码响应及对应新的location给客户浏览器--》客户浏览器发现是302响应，则自动再发送一个新的http请求，请求url是新的location地址----》服务器根据此请求寻找资源并发送给客户。在这里 location可以重定向到任意URL，既然是浏览器重新发出了请求，则就没有什么request传递的概念了。在客户浏览器路径栏显示的是其重定向的路径，客户可以观察到地址的变化的。重定向行为是浏览器做了至少两次的访问请求的。
    解释二
    重定向，其实是两次request,
    第一次，客户端request A,服务器响应，并response回来，告诉浏览器，你应该去B。这个时候IE可以看到地址变了，而且历史的回退按钮也亮了。重定向可以访问自己web应用以外的资源。在重定向的过程中，传输的信息会被丢失。
    例子：
    请求转发是服务器内部把对一个request/response的处理权，移交给另外一个
    对于客户端而言，它只知道自己最早请求的那个A，而不知道中间的B，甚至C、D。 传输的信息不会丢失。
### 20.jsp和Servlet的相同点和不同点
    JSP 是 Servlet 技术的扩展，本质上是 Servlet 的简易方式，更强调应用的外表表达。 JSP
    编译后是"类 servlet"。 Servlet 和 JSP 最主要的不同点在于， Servlet 的应用逻辑是在 Java
    文件中，并且完全从表示层中的 HTML 里分离开来。而 JSP 的情况是 Java 和 HTML 可以
    组合成一个扩展名为.jsp 的文件。 JSP 侧重于视图， Servlet 主要用于控制逻辑。 
### 21.内置对象和四大作用域和页面传值

### 22.Session和Cookie的区别和使用场景
    区别和联系：
        Cookies是属于Session对象的一种。但有不同，Cookies不会占服务器资源，是存在客服端内存或者一个cookie的文本文件中；而“Session”则会占用服务器资源。
        所以，尽量不要使用Session，而使用Cookies。但是我们一般认为cookie是不可靠的，session是可靠地，但是目前很多著名的站点也都以来cookie。有时候为了解决禁用cookie后的页面处理，通常采用url重写技术，调用session中大量有用的方法从session中获取数据后置入页面。
    Cookies与Session的应用场景：
         Cookies的安全性能一直是倍受争议的。虽然Cookies是保存在本机上的，但是其信息的完全可见性且易于本地编辑性，往往可以引起很多的安全问题。
         所以Cookies到底该不该用，到底该怎样用，就有了一个需要给定的底线。 
### 23.mvc模式和mvc各部分的实现

### 25.关系型数据库的三范式
    第一范式（1NF）：属性不可分（1NF是对属性的原子性约束，要求属性具有原子性，不可再分解）
    name       tel                             age
                 手机            座机
    Josh      13612345678    021－9876543      22
    Wang      13988776655    010－1234567      21
    
    很明显，tel这个属性还可以进行分解，分解成手机和座机这两个属性，不满足第一范式的数据库，不是关系数据库.
    所以，我们在任何关系数据库管理系统中，做不出这样的“表”来。
    
    第二范式（2NF）：符合1NF，并且非主属性完全依赖于码。
         （2NF是对记录的惟一性约束，要求记录有惟一标识，即实体的惟一性，更通俗说有主键ID）
    如果这都不能理解，只能看看如下科学的解释了：
          一个候选码中的主属性也可能是好几个。如果一个主属性，它不能单独做为一个候选码，那么它也不能确定任何一个非主属性。
          给一个反例：我们考虑一个小学的教务 管理系统，学生上课指定一个老师，一本教材，一个教室，一个时间，大家都上课去吧，没有问题。那么数据库怎么设计？（学生上课表）
    
    学生       课程            老师    老师职称         教材            教室      上课时间
    小明       一年级语文（上）  大宝     副教授        《小学语文1》      101       14：30
    
    一个学生上一门课，一定在特定某个教室。所以有（学生，课程）－>教室
    
    一个学生上一门课，一定是特定某个老师教。所以有（学生，课程）－>老师
    
    一个学生上一门课，他老师的职称可以确定。所以有（学生，课程）－>老师职称
    
    一个学生上一门课，一定是特定某个教材。所以有（学生，课程）－>教材
    
    一个学生上一门课，一定在特定时间。所以有（学生，课程）－>上课时间
    
    因此（学生，课程）是一个码。
    
            然而，一个课程，一定指定了某个教材，一年级语文肯定用的是《小学语文1》，那么就有课程－>教材。（学生，课程）是个码，课程却决定了教材，这就叫做不完全依赖，或者说部分依赖。出现这样的情况，就不满足第二范式！有什么不好吗？你可以想想：
    
           1、校长要新增加一门课程叫“微积分”，教材是《大学数学》，怎么办？学生还没选课，而学生又是主属性，主属性不能空，课程怎么记录呢，教材记到哪呢? ……郁闷了吧?(插入异常)
    
           2、下学期没学生学一年级语文（上）了，学一年级语文（下）去了，那么表中将不存在一年级语文（上），也就没了《小学语文1》。这时候，校长问：一年级语文（上）用的什么教材啊？……郁闷了吧?(删除异常)
    
           3、校长说：一年级语文（上）换教材，换成《大学语文》。有10000个学生选了这么课，改动好大啊！改累死了……郁闷了吧？（修改异常）
    
    那应该怎么解决呢？投影分解，将一个表分解成两个或若干个表
     
    学生     课程           老师     老师职称     教室      上课时间
    小明     一年级语文（上） 大宝      副教授        101       14：30
    
    学生上课表
    课程                  教材
    一年级语文（上）     《小学语文1》
     
    第三范式（3NF）：符合2NF，并且，消除传递依赖。
          （3NF是对字段冗余性的约束，即任何字段不能由其他字段派生出来，它要求字段没有冗余）
    正如前面所说：没有数据冗余的数据库并不一定是最好的数据库，所以有没有冗余的设计，要综合来考虑。
    
    上面的“学生上课表”符合2NF，可以这样验证：两个主属性单独使用，不用确定其它四个非主属性的任何一个。但是它有传递依赖！在“老师”和“老师职称”这里，一个老师一定能确定一个老师职称。
    
    如果不消除这种传递依赖，有可能会出现：
    
    1、老师升级了，变教授了，要改数据库，表中有N条，改了N次……（修改异常）
    
    2、没人选这个老师的课了，老师的职称也没了记录……（删除异常）
    
    3、新来一个老师，还没分配教什么课，他的职称记到哪？……（插入异常）
    
    那应该怎么解决呢？和上面一样，投影分解：
    
    学生      课程              老师    教室        上课时间
    小明      一年级语文（上）   大宝    101         14：30
     
    老师      老师职称
    大宝      副教授

### 26.事务的四大特征
    https://www.cnblogs.com/fjdingsd/p/5273008.html
    ⑴ 原子性（Atomicity）
    　　原子性是指事务包含的所有操作要么全部成功，要么全部失败回滚，这和前面两篇博客介绍事务的功能是一样的概念，因此事务的操作如果成功就必须要完全应用到数据库，如果操作失败则不能对数据库有任何影响。
    ⑵ 一致性（Consistency）
    　　一致性是指事务必须使数据库从一个一致性状态变换到另一个一致性状态，也就是说一个事务执行之前和执行之后都必须处于一致性状态。
    　　拿转账来说，假设用户A和用户B两者的钱加起来一共是5000，那么不管A和B之间如何转账，转几次账，事务结束后两个用户的钱相加起来应该还得是5000，这就是事务的一致性。
    ⑶ 隔离性（Isolation）
    　　隔离性是当多个用户并发访问数据库时，比如操作同一张表时，数据库为每一个用户开启的事务，不能被其他事务的操作所干扰，多个并发事务之间要相互隔离。
    　　即要达到这么一种效果：对于任意两个并发的事务T1和T2，在事务T1看来，T2要么在T1开始之前就已经结束，要么在T1结束之后才开始，这样每个事务都感觉不到有其他事务在并发地执行。
    　　关于事务的隔离性数据库提供了多种隔离级别，稍后会介绍到。
    ⑷ 持久性（Durability）
    　　持久性是指一个事务一旦被提交了，那么对数据库中的数据的改变就是永久性的，即便是在数据库系统遇到故障的情况下也不会丢失提交事务的操作。
### 28.mysql和oracle的分页语句
    MySQL
    
    MYSQL中有特定的分页查询语句，该sql语句只能在MySQL中使用
    
    select * from t_customer limit ?,?
    
    该sql语句的意思是，从第几行开始，然后取多少行，MySQL中第一行的下标是0
    
    例如：我要取数据库中的前10行数据，我的sql语句应该这样写：select  *  from  t_customer  limit 0,9;
    
    Oracle
    
    select * from(select rownum id, t_customer.* from t_customer where rownum <= ? )where id >= ?;
    
    例如：查询第20行到第30行的数据
    
    select * from(select rownum id, t_customer.* from t_customer where rownum <= 30 )where id >= 20；

### 29.触发器的使用场景？
    https://www.jianshu.com/p/9e293018a536
### 30.存储过程的优点
    存储过程是一组予编译的SQL语句
        它的优点：1.允许模块化程序设计，就是说只需要创建一次过程，以后在程序中就可以调用该过程任意次。
              　　2.允许更快执行，如果某操作需要执行大量SQL语句或重复执行，存储过程比SQL语句执行的要快。
               　 3.减少网络流量，例如一个需要数百行的SQL代码的操作有一条执行语句完成，不需要在网络中发送数百行代码。
    　　　　　　　4.更好的安全机制，对于没有权限执行存储过程的用户，也可授权他们执行存储过程。

### 33.写一个jdbc的访问oracle的列子
    /**
     * 一个非常标准的连接Oracle数据库的示例代码
     */
    public void testOracle()
    {
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
            System.out.println("开始尝试连接数据库！");
            String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:XE";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
            String user = "system";// 用户名,系统默认的账户名
            String password = "147";// 你安装时选设置的密码
            con = DriverManager.getConnection(url, user, password);// 获取连接
            System.out.println("连接成功！");
            String sql = "select * from student where name=?";// 预编译语句，“？”代表参数
            pre = con.prepareStatement(sql);// 实例化预编译语句
            pre.setString(1, "小茗同学");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
            while (result.next())
                // 当结果集不为空时
                System.out.println("学号:" + result.getInt("id") + "姓名:"
                        + result.getString("name"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
### 34.jdbc中preparedStatement比Statement的好处
    PreparedStatement 是预编译 ，使用Statement时 sql 中要进行很多的单引号拼接字符串，首先是容易出错也比较麻烦，还有就是存在sql 注入问题这是从安全方面说的。 
    PreparedStatement  传参数时候用 了占位符 “？”很好的解决了以上Statement的问题。我所体会到得的就是这些。 
    
    PreparedStatement是在执行前先输入sql语句，Statement正好相反，是在执行的时候传入sql语句的。
    这样的区别在于，PreparedStatement可以在传入sql后，执行语句前，给参数赋值，避免了因普通的拼接sql字符串语句所带来的安全问题，而且准备sql和执行sql是在两个语句里面完成的，也提高了语句执行的效率。
    Statement，就没有以前所说的功能了，我一般很少用 
### 35.数据库连接池的作用
    1． 资源重用 
    由于数据库连接得到重用，避免了频繁创建、释放连接引起的大量性能开销。在减少系统消耗的基础上，另一方面也增进了系统运行环境的平稳性（减少内存碎片以及数据库临时进程/线程的数量）。 
    2． 更快的系统响应速度 
    数据库连接池在初始化过程中，往往已经创建了若干数据库连接置于池中备用。此时连接的初始化工作均已完成。对于业务请求处理而言，直接利用现有可用连接，避免了数据库连接初始化和释放过程的时间开销，从而缩减了系统整体响应时间。 
    3． 新的资源分配手段 
    对于多应用共享同一数据库的系统而言，可在应用层通过数据库连接的配置，实现数据库连接池技术，几年钱也许还是个新鲜话题，对于目前的业务系统而言，如果设计中还没有考虑到连接池的应用，那么…….快在设计文档中加上这部分的内容吧。某一应用最大可用数据库连接数的限制，避免某一应用独占所有数据库资源。 
    4． 统一的连接管理，避免数据库连接泄漏 
    在较为完备的数据库连接池实现中，可根据预先的连接占用超时设定，强制收回被占用连接。从而避免了常规数据库连接操作中可能出现的资源泄漏。一个最小化的数据库连接池实现.
    连接池类是对某一数据库所有连接的“缓冲池”，主要实现以下功能：①从连接池获取或创建可用连接；②使用完毕之后，把连接返还给连接池；③在系统关闭前，断开所有连接并释放连接占用的系统资源；④还能够处理无效连接（原来登记为可用的连接，由于某种原因不再可用，如超时，通讯问题），并能够限制连接池中的连接总数不低于某个预定值和不超过某个预定值。

### 47.简单说一下对mvc框架的理解
    mvc包括model（模型层）view(视图层)controller(控制层)
    首先介绍一下视图层，这个层比较简单。
    视图层就是jsp或者tpl页面，视图层除了要掌握html css javascript，还要掌握标签语言，比如jsp原生的EL表达式（在jsp中嵌入Java代码），比如struts2提供的标签语言，比如spring提供的jstl标签语言，都是为了能把后台数据嵌入到网页中。
    接下来说一下控制层
    控制层是控制页面跳转的，根据网址栏中的url决定跳转到哪个页面，
    这个url可以是用户直接手动在网址栏输入的，比如刚进入系统，在网址栏中输入
    localhost:8080/projectname/enterRegister.action
    后台的controller就会返回一个注册的网页给前端用户。
    有时在网址栏中输入localhost:8080/projectname/index.jsp
    也会跳转到指定的网页，但这种其实是重定向到指定网页，并不是通过controller返回指定网页。
    这种手动输入url的后缀一定是.action或controller指定的pattern后缀格式。
    第二种能调用controller决定页面跳转的就是网页中的表单提交和超链接，表单提交的url和超链接提交的url如果是以action结尾的（或其他controller指定的pattern格式），这种提交到后台后，就能通过控制器决定跳转到哪个网页。如果提交的url是以.html或者.jsp结尾的，那就是直接重定向到某个网页，而不需要经过控制器。
    最后说一下模型层
    模型层主要完成业务逻辑，包括从数据库中存取数据，模型层一般被controller层调用，controller会从前台接收参数，然后把这些参数作为输入传给service层（model层），service拿着这些参数从数据库中做增删改查，然后把数据库返回的结果给controller层，controller把返回的结果加载进将要跳转的目标jsp页面，并把渲染好的jsp网页展现给前端，这里不仅介绍了service层的功能，在mvc中所处的位置，输入输出参数，还简单介绍了mvc的工作原理。
    之前我一直认为模型层指的是javabean，最近弄了一段时间php，发现人家也没有面向对象，但是人家也是mvc架构，遂发现model层指的是service层。
### 48.struts2的执行流程或者struts2的原理
### 49.Struts2的拦截器是什么
    http://www.blogjava.net/max/archive/2006/12/06/85925.html
### 50.Spring MVC的执行流程
### 51.SpringMVC和Struts2的不同
### 52.简单介绍一下Spring或者Spring的两大核心
    IoC Inverse of Control 反转控制的概念，就是将原本在程序中手动创建UserService对象的控制权，交由Spring框架管理，简单说，就是创建UserService对象控制权被反转到了Spring框架
    
    DI：Dependency Injection 依赖注入，在Spring框架负责创建Bean对象时，动态的将依赖对象注入到Bean组件
    IoC 控制反转，指将对象的创建权，反转到Spring容器 ， DI 依赖注入，指Spring创建对象的过程中，将对象依赖属性通过配置进行注入
    

### 53.AOP是什么？都用它做什么？
    https://zhuanlan.zhihu.com/p/28097563
### 54.Spring事务的传播特性和隔离级别
### 55.ORM是什么？ORM框架是什么？
    对象关系映射（Object Relational Mapping，简称ORM）模式是一种为了解决面向对象与关系数据库存在的互不匹配的现象的技术。
    简单来说，将程序中的兑现自动持久化到关系数据库中。那么，到底如何实现持久化呢？一种简单的反感是采用硬编码的方式（jdbc操作sql方式），为每一种可能的数据库访问操作提供单独的方法：
    这种方案存在以下的不足：
    1.持久化层缺乏弹性。一旦出现业务需求的变更，就必须修改持久化层的接口。
    2.持久化层同时与域模型与关系数据库模型绑定，不管域模型还是关系数据库模型发生变化，都要修改持久化层的相关程序代码，增加了软件的维护难度。
    ORM提供了实现持久化层的另一种模式，它采用映射元数据来描述对象关系的映射，使得ORM中间件能在任何一个应用的业务逻辑层和数据库层之间充当桥梁。Java典型的ORM框架有个：Hibernate，mybatits,speedframework
    ORM的方法论基于三个核心原则：
       简单：以最基本的形式建模数据
       传达性：数据库结构被任何人都能理解的语言文档化
       精准性：基于数据模型创建正确标准化了的结构
    ORM框架：为了解决面型对象与关系数据库存在的互不匹配的现象的框架。
    概括起来 : 对象关系映射（Object Relational Mapping，简称ORM）模式是一种为了解决面向对象与关系数据库存在的互不匹配的现象的技术。简单来说，将程序中的兑现自动持久化到关系数据库中。那么，到底如何实现持久化呢？一种简单的反感是采用硬编码的方式（jdbc操作sql方式），为每一种可能的数据库访问操作提供单独的方法。这种方法存在很多缺陷，所有使用ORM框架（为了解决面型对象与关系数据库存在的互不匹配的现象的框架）来解决。

### 56.ibatis和hibernate有什么不同
    ibatas的sql语句需要自己手动写，而hibernate能够在程序运行时自动生成。但是不要就这样以为hibernate比ibatas方便，其实二者熟悉之后的效率差不多。而hibernate还能够自动建表等等，这样的好处就在于你带着
    这个程序，无论到什么机器上，你都不需要数据库，应为它能自动为你完成，而ibatas就必须要有相应的数据库表才能进行移植
    Hibernate的特点：
    Hibernate功能强大，数据库无关性好，O/R（对象/关系）映射能力强，如果你对Hibernate相当精通，而且对Hibernate进行了适当的封装，那么你的项目整个持久层代码会相当简单，需要写的代码很少，开发速度很快，非常爽。
    Hibernate对数据库结构提供了较为完整的封装，Hibernate的O/R Mapping实现了POJO（实体类） 和数据库表之间的映射，以及SQL 的自动生成和执行。程序员往往只需定义好了POJO 到数据库表的映射关系，即可通过
    Hibernate 提供的方法完成持久层操作。程序员甚至不需要对SQL 的熟练掌握， Hibernate/OJB 会根据制定的存储逻辑，自动生成对应的SQL 并调用JDBC 接口加以执行。Hibernate的缺点就是学习门槛不低，要精通门
    槛更高，而且怎么设计O/R映射，在性能和对象模型之间如何权衡取得平衡，以及怎样用好Hibernate方面需要你的经验和能力都很强才行，但是Hibernate现在已经是主流O/R Mapping框架，从文档的丰富性，产品的完善性，
    版本的开发速度都要强于iBATIS。
    iBATIS的特点：
    iBATIS入门简单，即学即用，提供了数据库查询的自动对象绑定功能，而且延续了很好的SQL使用经验，对于没有那么高的对象模型要求的项目来说，相当完美。iBATIS的缺点就是框架还是比较简陋，功能尚有缺失，虽然简化了
    数据绑定代码，但是整个底层数据库查询实际还是要自己写的，工作量也比较大，而且不太容易适应快速数据库修改。当系统属于二次开发,无法对数据库结构做到控制和修改,那iBATIS的灵活性将比Hibernate更适合。
    系统数据处理量巨大，性能要求极为苛刻，这往往意味着我们必须通过经过高度优化的SQL语句（或存储过程）才能达到系统性能设计指标。在这种情况下iBATIS会有更好的可控性和表现。
### 57.hibernate对象状态及其转换
### 58：hibernate的缓存
### 59.webservice的使用场景

　　  跨越防火墙的通信
　   如果你的应用程序有成千上万的用户，而且他们都分布在世界各地，那么客户端和服务器之间的通信将是一个棘手的问题。那是因为客户端和服务器之间通常都会 有防火墙或者代理服务器。在这种情况下，你想使用DCOM就不是那么简单了，而且，通常你也不愿意把你的客户端程序发布到如此庞大数量的每一个用户手中。 于是，你最终选择了用浏览器作为客户端，写下一堆ASP页面，把应用程序的中间层暴露给最终用户。结果呢?运气好的话，只是开发难度大了一些，运气不好的 话，就会得到一个根本无法维护的应用程序。
　　想象一下你应该怎么在你的应用程序里面加入一个新的页面：你必须先建立好用户界面(Web 页面)，以及在这个页面后面，包含相应商业逻辑的中间层组件。这还不够，你还要再建立至少一个ASP页面，用来接受用户输入的信息，调用中间层组件，把结 果格式化为HTML形式，最后还要把"结果页"送回浏览器。要是客户端代码不再如此依赖于HTML表单，客户端的编程不就简单多了吗?还有，建立ASP页 面的那一步可以省略掉吗?
　　当然。如果你的中间层组件是Web service的话，你完全可以从用户界面直接调用中间层组件，从而省掉建立ASP页面的那一步。要调用Web service，你可以直接使用Microsoft SOAP Toolkit或。NET这样的SOAP客户端，也可以使用你自己开发的SOAP客户端，然后把它和你的应用程序连接起来。这样做，不仅可以缩短开发周 期，还可以减少代码的复杂度，并增强整个应用程序的可维护性。同时，你的应用程序也不再需要在每次调用中间层组件时，都跳转到相应的"结果页"了。
    　　应用程序集成
    　　 企业级的应用程序开发者都知道，企业里经常都要把用不同语言写成的在不同平台上运行的各种程序集成起来，而这种集成将花费很大的开发的力量。你的应用程序 经常都需要从运行在古老的IBM主机上的程序中获取数据; 或者再把数据发送到主机或UNIX应用程序中去。即使是在同一个平台上，不同的软件厂商生产的各种软件也常常需要集成起来。通过Web service，应用程序可以用标准的方法把功能和数据暴露出来，供其它的应用程序使用。

### 62.linux常用命令
    https://gywbd.github.io/posts/2014/8/50-linux-commands.html
### 65：数据库优化方面的事情
### 66：如果查询和定位慢查询
### 67：数据库优化之数据库表设计遵循范式
### 68：选择合适的数据库引擎
### 69：选择合适的索引
### 70：使用索引的一些技巧
### 71：数据库优化之分表
### 72：数据库的读写分离
### 73：数据库优化之缓存
### 74：sql语句优化小技巧
    除了建立索引之外，保持良好的SQL语句编写习惯将会降低SQL性能问题发生。
    ①通过变量的方式来设置参数
    好：
    stringsql = "select * from people p where p.id = ? ";
    坏：
    stringsql = "select * from people p where p.id = "+id;
    数据库的SQL文解析和执行计划会保存在缓存中，但是SQL文只要有变化，就得重新解析。
    “…where p.id = ”+id的方式在id值发生改变时需要重新解析，这会耗费时间。
    ②不要使用select *
    好：
    stringsql = "select people_name,pepole_age from people ";
    坏：
    stringsql = "select * from people ";
    使用select *的话会增加解析的时间，另外会把不需要的数据也给查询出来，数据传输也是耗费时间的，
    比如text类型的字段通常用来保存一些内容比较繁杂的东西，如果使用select *则会把该字段也查询出来。
    ③谨慎使用模糊查询
    好：
    stringsql = "select * from people p where p.id like 'parm1%' ";
    坏：
    stringsql = "select * from people p where p.id like '%parm1%' ";
    当模糊匹配以%开头时，该列索引将失效，若不以%开头，该列索引有效。
    模糊查询可使用instr()函数
    ④不要使用列号
    好：
    stringsql = "select people_name,pepole_age from people order by name,age";
    坏：
    stringsql = "select people_name,pepole_age from people order by 6,8";
    使用列号的话，将会增加不必要的解析时间。
    ⑤优先使用UNION ALL，避免使用UNION
    好：
    stringsql = "select name from student union all select name from teacher";
    坏：
    stringsql = "select name from student union select name from teacher";
    UNION 因为会将各查询子集的记录做比较，故比起UNION ALL ，通常速度都会慢上许多。
    一般来说，如果使用UNION ALL能满足要求的话，务必使用UNION ALL。还有一种情况，如果业务上能够确保不会出现重复记录。
    ⑥在where语句或者order by语句中避免对索引字段进行计算操作
    好：
    stringsql = "select people_name,pepole_age from people where create_date=date1 ";
    坏：
    stringsql = "select people_name,pepole_age from people where trunc(create_date)=date1";
    当在索引列上进行操作之后，索引将会失效。正确做法应该是将值计算好再传入进来。
    ⑦使用not exist代替not in
    好：
    stringsql = "select * from orders where customer_name not exist (select customer_name from customer)";
    坏：
    stringsql = "select * from orders where customer_name not in(select customer_name from customer)";
    如果查询语句使用了not in 那么内外表都进行全表扫描，没有用到索引；而not extsts 的子查询依然能用到表上的索引。
    ⑧ exist和in的区别
    in 是把外表和内表作hash 连接，而exists是对外表作loop循环，每次loop循环再对内表进行查询。因此，in用到的是外表的索引， exists用到的是内表的索引。
    如果查询的两个表大小相当，那么用in和exists差别不大。
    如果两个表中一个较小，一个是大表，则子查询表大的用exists，子查询表小的用in：
    例如：表A（小表），表B（大表）
    select * from A where cc in (select cc from B)
    效率低，用到了A表上cc列的索引；
    select * from A where exists(select cc from B where cc=A.cc)
    效率高，用到了B表上cc列的索引。
    select * from B where cc in (select cc from A)
    效率高，用到了B表上cc列的索引；
    select * from B where exists(select cc from A where cc=B.cc)
    效率低，用到了A表上cc列的索引。
    ⑨避免在索引列上做如下操作：
    ◆避免在索引字段上使用<>，!=
    ◆避免在索引列上使用IS NULL和IS NOT NULL
    ◆避免在索引列上出现数据类型转换（比如某字段是String类型，参数传入时是int类型）
    当在索引列上使用如上操作时，索引将会失效，造成全表扫描。
    ⑩复杂操作可以考虑适当拆成几步
    有时候会有通过一个SQL语句来实现复杂业务的例子出现，为了实现复杂的业务，嵌套多级子查询。造成SQL性能问题。对于这种情况可以考虑拆分SQL，通过多个SQL语句实现，或者把部分程序能完成的工作交给程序完成。
### 75：批量插入几百万条数据
### 77：redis的使用场景
### 78：redis存储对象的方式
### 79：redis数据淘汰机制
### 80：java访问redis级redis集群
