package _2023;

import java.util.*;
import java.util.stream.Collectors;

class Student implements Comparable {
    String name;
    int score;


    Student (String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;	// 비교할 다른 Student 객체
        return this.score - other.score;	// 다른 학생과 이 학생의 score 비교 정렬
    }
}

public class Test {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student("han", 20));
        list.add(new Student("lee", 15));
        list.add(new Student("kim", 8));
        list.add(new Student("bae", 11));
        Collections.sort(list);
        Collections.reverse(list);
        int[] a = new int[10];

        Integer[] b = Arrays.stream(a).boxed().toArray(Integer[]::new);
        List<Integer> c = Arrays.stream(a).boxed().collect(Collectors.toList());
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
        c.forEach(v -> System.out.println(v));

        Integer d[] = {1,2,3,4};
        int e[] = Arrays.stream(d).mapToInt(Integer::intValue).toArray();

        List<Integer> list2 = new ArrayList<>();
        int[] example2 = list2.stream().mapToInt(Integer::intValue).toArray();


        list.forEach(v -> System.out.println(v.name + "" + v.score));
    }
}
