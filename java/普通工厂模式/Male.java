package 普通工厂模式;

public class Male implements Human {
    @Override
    public void eat() {
        System.out.println("man eat");
    }

    @Override
    public void sleep() {
        System.out.println("man sleep");

    }

    @Override
    public void beat() {
        System.out.println("man beat");

    }
}
