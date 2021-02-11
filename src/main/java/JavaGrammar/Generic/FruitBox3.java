package JavaGrammar.Generic;
import java.util.ArrayList;
import java.util.List;

/**
 * ? extends T 와일드 카드의 상한 제한 - T와 그 자손들만 가능
 * ? super T 와일드카드 하한 제한 - T와 그 조상들만 가능
 * <?>모든 ㅌ입가능 ? extends Object와 같은 의미
 */

class Fruit3 implements Eatable1{
    @Override
    public String toString() {
        return "Fruit{}";
    }
}
class Apple3 extends Fruit3{
    @Override
    public String toString() {
        return "Apple{}";
    }
}
class Grape3 extends Fruit3{
    @Override
    public String toString() {
        return "Grape{}";
    }
}
class Juice{
    String name;

    public Juice(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Juice{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Juicer{
    static Juice makeJuice(FruitBox0<? extends Fruit3> box){
        String tmp = "";

        for(Fruit3 f : box.list){
            tmp+= f + " ";
        }
        return new Juice(tmp);

    }
}
class FruitBox0<T extends Fruit3> extends Box3<T>{

}
// Frit의 자손이면서 Eatable을 구현한 클래스만 타입 매개변수 T에 대입될 수 있다.
class Box3<T>{
    List<T> list = new ArrayList<T>();

    public Box3() {
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
// 여기에 &기호로 T타입이랑 연결한다. Eatable을 구현한 클래스만 타입 매개변수 T에 대입될 수 있다.
interface Eatable1{

}
class FruitBox3 {
    public static void main(String[] args) {
        FruitBox0<Fruit3> fruitBox1 = new FruitBox0<Fruit3>();
        FruitBox0<Apple3> fruitBox2 = new FruitBox0<Apple3>();

        fruitBox1.add(new Fruit3());
        fruitBox1.add(new Apple3());     // 타입 실패
        System.out.println("fruitBox1 = " + fruitBox1);
        fruitBox2.add(new Apple3());
        fruitBox2.add(new Apple3());
        // fruitBox2.add(new Toy());      apple만 담을 수 있음.
        System.out.println("fruitBox2 = " + fruitBox2);
        System.out.println(Juicer.makeJuice(fruitBox1));
        System.out.println(Juicer.makeJuice(fruitBox2));


//        fruitBox4.add(new Toy2());
        // fruitBox4.add(new Apple());      toy만 담을 수 있음

//        System.out.println("fruitBox4 = " + fruitBox4);
    }
}
