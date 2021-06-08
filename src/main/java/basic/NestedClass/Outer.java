package basic.NestedClass;

public class Outer {
    int a = 10;
    private int b = 20;
    static int c = 30;

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.print();
    }
    class Inner{
        public void print(){
            System.out.println(a + " "+ b + " " + c);
        }
    }

}
