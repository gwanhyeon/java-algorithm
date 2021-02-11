package JavaGrammar.Generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Fruit4{
    String name;
    int weight;

    public Fruit4(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit4{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
class Apple4 extends Fruit4{
    public Apple4(String name, int weight) {
        super(name, weight);
    }
}
class Grape4 extends Fruit4{
    public Grape4(String name, int weight) {
        super(name, weight);
    }
}

class AppleComp implements Comparator<Apple4>{
    @Override
    public int compare(Apple4 o1, Apple4 o2) {
        return o2.weight - o1.weight;
    }
}
class GrapeComp implements Comparator<Grape4>{

    @Override
    public int compare(Grape4 o1, Grape4 o2) {
        return o2.weight - o1.weight;
    }
}
class FruitComp implements Comparator<Fruit4>{
    @Override
    public int compare(Fruit4 o1, Fruit4 o2) {
        return o1.weight - o2.weight;
    }
}

public class FruitBox4 {
    public static void main(String[] args) {
        FruitBox5<Apple4> appleBox = new FruitBox5<Apple4>();
        FruitBox5<Grape4> grapeBox = new FruitBox5<Grape4>();

        appleBox.add(new Apple4("GreenApple",300));
        appleBox.add(new Apple4("GreenApple",100));
        appleBox.add(new Apple4("GreenApple",200));

        grapeBox.add(new Grape4("GreenGrape",400));
        grapeBox.add(new Grape4("GreenGrape",300));
        grapeBox.add(new Grape4("GreenGrape",200));

        Collections.sort(appleBox.getList(), new AppleComp());
        Collections.sort(grapeBox.getList(), new GrapeComp());

        System.out.println(appleBox);
        System.out.println(grapeBox);
        System.out.println();

        Collections.sort(appleBox.getList(), new FruitComp());
        Collections.sort(grapeBox.getList(), new FruitComp());
        System.out.println(appleBox);
        System.out.println(grapeBox);
    }
}
class FruitBox5<T extends Fruit4> extends Box4<T>{}

class Box4<T>{
    List<T> list = new ArrayList<T>();

    void add(T item){
        list.add(item);
    }
    T getI(int i){
        return list.get(i);
    }
    List<T> getList(){
        return list;
    }
    int size(){
        return list.size();
    }

    @Override
    public String toString() {
        return "Box{" +
                "list=" + list +
                '}';
    }
}
