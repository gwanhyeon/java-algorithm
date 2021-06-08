package basic.NestedClass;

interface Student {
    public void getInfo();
}

public class Anonymous {

    public static void main(String[] args) {
        Student student = new Student() {
            @Override
            public void getInfo() {
                System.out.println("anonymous class");
            }
        };
        student.getInfo();
    }

}
