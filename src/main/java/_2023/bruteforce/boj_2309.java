package _2023.bruteforce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
일곱 난쟁이 성공스페셜 저지

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	106226	43586	31381	42.036%
문제
왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.

아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

입력
아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.

출력
일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.

예제 입력 1
20
7
23
19
10
15
25
8
13
예제 출력 1
7
8
10
13
19
20
23
 */
public class boj_2309 {
    static int n;
    static int selection;
    static List<Integer> arrList;
    static List<Integer> answer;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        n = 9;
        selection = 7;
        arrList = new ArrayList<>();
        isVisited = new boolean[n];
        answer = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<n; i++){
            int v = Integer.parseInt(br.readLine());
            arrList.add(v);
        }
        Collections.sort(arrList);
        dfs(0);

    }

    private static void dfs( int idx) {

        if(answer.size() == selection){
            int sum = 0;
            for(int i=0; i<answer.size(); i++){
                sum += answer.get(i);
            }
            if(sum == 100){
                Collections.sort(answer);
                for(int i=0; i<answer.size(); i++){
                    System.out.println(answer.get(i));
                }
            }
            return;
        }

        for(int i=idx; i<arrList.size(); i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                answer.add(arrList.get(i));
                dfs(i);
                isVisited[i] = false;
                answer.remove(answer.size()-1);
            }
        }
    }
}
