package basic.NestedClass;

public class Outer1 {
    int a = 10;
    private int b = 20;
    static int c = 30;

    public void outer1Method(){
        class Inner{
            public void print(){
                System.out.println(a + " " + b + " "+ c);
            }
        }

        Inner iner = new Inner();
        iner.print();
    }

    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        outer.outer1Method();
    }
}
