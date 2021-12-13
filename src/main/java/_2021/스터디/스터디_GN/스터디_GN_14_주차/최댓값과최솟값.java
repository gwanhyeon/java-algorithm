package _2021.스터디.스터디_GN.스터디_GN_14_주차;

public class 최댓값과최솟값 {
    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));
    }
    static String solution(String s) {
        int max = (int) -1e9;
        int min = Integer.MAX_VALUE;
        String[] splitStr = s.split(" ");
        for (String c : splitStr) {
            min = Math.min(min, Integer.parseInt(c));
            max = Math.max(max, Integer.parseInt(c));
        }
        return min + " " + max;
    }
}
