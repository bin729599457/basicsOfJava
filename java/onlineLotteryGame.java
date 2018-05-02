import static java.lang.Thread.sleep;

public class onlineLotteryGame {
    static class Printer implements Runnable {
        static int NUM = 1;
        static final int SIZE = 100;
        int id;

        public Printer(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (NUM<=SIZE){
                synchronized(Printer.this){
                    System.out.println(id+"号用户抽中了"+NUM+"号奖品！");
                    try {
                        sleep(100);
                        NUM++;

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
        public static void main(String[] args) {
            new Thread( new Printer(0)).start();
            new Thread( new Printer(1)).start();
            new Thread( new Printer(2)).start();
        }
    }


}