import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box<T extends Fruit> implements Iterable<T> {
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public int getWeight() {
        int totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public void move(Box<? super T> another) {
        for (T fruit : fruits) {
            another.add(fruit);
        }
        fruits.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return fruits.iterator();
    }

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple(2));
        appleBox.add(new Apple(4));

        Box<GoldenApple> goldenAppleBox = new Box<>();
        goldenAppleBox.add(new GoldenApple(20));

        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange(8));

        System.out.println("Общий вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Общий вес коробки с золотыми яблоками: " + goldenAppleBox.getWeight());
        System.out.println("Общий вес коробки с апельсинами: " + orangeBox.getWeight());
        System.out.println("Вес пустой коробки: " + new Box<>().getWeight());
    }
}