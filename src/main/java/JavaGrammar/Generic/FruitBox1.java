package JavaGrammar.Generic;

import java.util.ArrayList;
import java.util.List;

class Fruit1{
    @Override
    public String toString() {
        return "Fruit{}";
    }
}
class Apple1 extends Fruit1{
    @Override
    public String toString() {
        return "Apple{}";
    }
}
class Grape1 extends Fruit1{
    @Override
    public String toString() {
        return "Grape{}";
    }
}
class Toy1 extends Fruit1{
    @Override
    public String toString() {
        return "Toy{}";
    }
}

public class FruitBox1 {
    public static void main(String[] args) {
        Box1<Fruit1> fruitBox1 = new Box1<Fruit1>();
        Box1<Apple1> fruitBox2 = new Box1<Apple1>();
        Box1<Grape1> fruitBox3 = new Box1<Grape1>();
        Box1<Toy1> fruitBox4 = new Box1<Toy1>();
        //Box<Grape> fruitBox5 = new Box<Apple>();        // 에러타입 불일치

        fruitBox1.add(new Fruit1());
        fruitBox1.add(new Apple1());     // 타입 실패
        System.out.println("fruitBox1 = " + fruitBox1);
        fruitBox2.add(new Apple1());
        fruitBox2.add(new Apple1());
        // fruitBox2.add(new Toy());      apple만 담을 수 있음.
        System.out.println("fruitBox2 = " + fruitBox2);

        fruitBox4.add(new Toy1());
        // fruitBox4.add(new Apple());      toy만 담을 수 있음

        System.out.println("fruitBox4 = " + fruitBox4);
    }
}
class Box1<T extends Fruit1>{
    List<T> list = new ArrayList<T>();

    public Box1() {
    }

    void add(T item){
        list.add(item);
    }
    T get(int i){
        return list.get(i);
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
