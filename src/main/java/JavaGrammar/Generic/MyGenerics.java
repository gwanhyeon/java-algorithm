package JavaGrammar.Generic;

public class MyGenerics {
    public static <T> T get(T[] any, int index){
        return any[index];
    }
    public static <T> T getLast(T[] any){
        return any[any.length-1];
    }

    public static void main(String[] args) {
        Integer[] n = {3,4,5,7};
        System.out.println(MyGenerics.get(n,2));
    }
}
