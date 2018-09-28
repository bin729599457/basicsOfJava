package 抽象工厂模式;

public class Foodaholic {

    public void eat(KitchenFactory kitchenFactory){
        System.out.println("A foodaholic is eating "+ kitchenFactory.getFood().getFoodName()
                + " with " + kitchenFactory.getTableWare().getToolName() );
    }

    public static void main(String[] args) {
        Foodaholic foodaholic=new Foodaholic();
        KitchenFactory kitchenFactory=new AKitchen();
        foodaholic.eat(kitchenFactory);
    }
}
