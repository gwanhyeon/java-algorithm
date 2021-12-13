package _2021.basic.NestedClass;

public class Outer2 {
    int a = 10;
    private int b = 20;
    static int c = 30;

    static class Inner{
        static int d = 40;
        public void print(){
            System.out.println(c);
        }
        public static void staticPrint(){
            System.out.println(c);
        }

    }

    public static void main(String[] args) {
        Outer2.Inner inner = new Outer2.Inner();
        inner.print();

        System.out.println(Outer2.Inner.d);
        Outer2.Inner.staticPrint();

    }
}
