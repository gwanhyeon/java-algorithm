package _2021.JavaGrammar.Generic;
import java.util.ArrayList;
import java.util.List;

/**
 * ? extends T 와일드 카드의 상한 제한 - T와 그 자손들만 가능
 * ? super T 와일드카드 하한 제한 - T와 그 조상들만 가능
 * <?>모든 ㅌ입가능 ? extends Object와 같은 의미
 */

class Fruit2 implements Eatable{
    @Override
    public String toString() {
        return "Fruit{}";
    }
}
class Apple2 extends Fruit2{
    @Override
    public String toString() {
        return "Apple{}";
    }
}
class Grape2 extends Fruit2{
    @Override
    public String toString() {
        return "Grape{}";
    }
}
class Toy2{
    @Override
    public String toString() {
        return "Toy{}";
    }
}
// 여기에 &기호로 T타입이랑 연결한다. Eatable을 구현한 클래스만 타입 매개변수 T에 대입될 수 있다.
interface Eatable{

}
public class FruitBox2 {
    public static void main(String[] args) {
        Box2<Fruit2> fruitBox1 = new Box2<Fruit2>();
        Box2<Apple2> fruitBox2 = new Box2<Apple2>();
        Box2<Grape2> fruitBox3 = new Box2<Grape2>();
//        Box2<Toy2> fruitBox4 = new Box2<Toy2>();
        //Box<Grape> fruitBox5 = new Box<Apple>();        // 에러타입 불일치

        fruitBox1.add(new Fruit2());
        fruitBox1.add(new Apple2());     // 타입 실패
        System.out.println("fruitBox1 = " + fruitBox1);
        fruitBox2.add(new Apple2());
        fruitBox2.add(new Apple2());
        // fruitBox2.add(new Toy());      apple만 담을 수 있음.
        System.out.println("fruitBox2 = " + fruitBox2);

//        fruitBox4.add(new Toy2());
        // fruitBox4.add(new Apple());      toy만 담을 수 있음

//        System.out.println("fruitBox4 = " + fruitBox4);
    }
}
// Frit의 자손이면서 Eatable을 구현한 클래스만 타입 매개변수 T에 대입될 수 있다.
class Box2<T extends Fruit2 & Eatable>{
    List<T> list = new ArrayList<T>();

    public Box2() {
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


