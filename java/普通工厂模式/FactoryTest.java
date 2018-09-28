package 普通工厂模式;

public class FactoryTest {

    public static void main(String[] args) {
/*        HumanFactory factory=new HumanFactory();
        Human male=factory.createHuman("male");
        male.eat();
        male.sleep();
        male.beat();

        Human female=factory.createHuman("female");
        female.eat();
        female.sleep();
        female.beat();

        Human male=factory.createMale();
        male.eat();
        male.sleep();
        male.beat();

        Human female=factory.createFemale();
        female.eat();
        female.sleep();
        female.beat();*/

        Human male=HumanFactory.createMale();
        male.sleep();
        male.eat();
        male.beat();
    }
}
