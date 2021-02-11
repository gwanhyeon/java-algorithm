package 스터디.스터디_SNU.Section10;

/**
 * 1.
 * 2. 컴퓨팅사고
 */
public class programmers_조이스틱_kgh {
    public static void main(String[] args) {
        System.out.println(solution("JAN"));
    }
    public static int solution(String name) {
        char[] word = name.toCharArray();
        int answer = 0;
        int wordsSize = word.length;
        int nowIdx =0;
        boolean isCheck = true; // 변경이 있는 지 확인하는 플래그

        //변경이 없을 때 까지
        while(isCheck) {
            //왼쪽에서 오른쪽으로 가는 인덱스
            int leftToright = 0;
            //오른쪽에서 왼쪽으로 가는 인덱스
            int rightToleft = 0;

            //플래그 초기화
            isCheck = false;

            //A인 경우가 아닌 인덱스를 탐색
            for(int i=0;i<wordsSize;i++) {

                //인덱스가 범위를 넘어가지 않았을 때
                if(nowIdx+i<wordsSize) {
                    leftToright = nowIdx + i;
                }
                //인덱스가 범위를 넘어갔을 때
                else {
                    leftToright = nowIdx + i - wordsSize;
                }

                if(nowIdx-i>=0)
                    rightToleft = nowIdx -i;
                else
                    rightToleft = nowIdx -i + wordsSize;

                if(word[leftToright]!='A') {
                    //i는 오른쪽으로 움직인 횟수이므로 answer에 더해줌
                    answer += i;
                    //위로 움직일지 아래로 움직일지
                    if(word[leftToright]-'A'>13) answer += 26-(word[leftToright]-'A');
                    else answer += word[leftToright] - 'A';
                    //값을 A로 바꾸어주어 다시 탐색되는 경우가 없도록 한다.
                    word[leftToright] = 'A';
                    nowIdx = leftToright;
                    //A가 아닌 경우가 존재하면 변화가 있는 것이므로 flag를 true로 바꾸어주어 변화가 있다고 알려줌
                    isCheck =true;
                    break;
                }else if(word[rightToleft]!='A') {
                    //i는 왼쪽으로 움직인 횟수이므로 answer에 더해줌
                    answer += i;
                    if(word[rightToleft]-'A'>13) answer += 26-(word[rightToleft]-'A');
                    else answer += word[rightToleft] - 'A';
                    word[rightToleft] = 'A';
                    nowIdx = rightToleft;
                    isCheck = true;
                    break;
                }
            }
        }
        return answer;
    }
}
