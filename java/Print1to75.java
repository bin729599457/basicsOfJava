/**
 * 要求创建三个线程，输出1-75， 
 * 最开始第一个线程输出1-5，第二个输出6-10，第三个输出11-15 
 * 接着再第一个线程输出16-20...就这样循环下去，直到打印出75个数 
 */
public class Print1to75 {
    static class Printer implements Runnable{
        static int num = 1; //开始数字  
        static final int END = 75;
        int id;

        public Printer(int id) {
            this.id = id;
        }

        @Override
        public void run(){
            synchronized (Printer.class) {
                while(num <= END){
                    if(num / 5 % 3 == id){ //如果是属于自己的数，依次打印出来五个  
                        System.out.print(id + ":");
                        for(int i = 0; i < 5; i++){
                            System.out.print(num++ + ", ");
                        }
                        System.out.println();

                        Printer.class.notifyAll();//放弃CPU使用权，唤醒等待在Print.class队列上的的打印线程  
                    }else{
                        try {
                            Printer.class.wait();//如果不属于自己的数，把当前线程挂在Printer.class这个对象的等待队列上（也是放弃CPU使用权），等待唤醒  
                        } catch (InterruptedException e) {
                            System.out.println("id" + "被打断了");
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        //下面可以不按0，1，2的顺序来,而且在两两中间随便sleep()，都会正确打印出来  
        new Thread( new Printer(0)).start();
        new Thread( new Printer(1)).start();
        new Thread( new Printer(2)).start();
    }
} 