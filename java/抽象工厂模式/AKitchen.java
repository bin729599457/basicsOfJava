package 抽象工厂模式;

public class AKitchen implements KitchenFactory {
    @Override
    public Food getFood() {
        return new Apple();
    }

    @Override
    public TableWare getTableWare() {
        return new Knife();
    }
}
