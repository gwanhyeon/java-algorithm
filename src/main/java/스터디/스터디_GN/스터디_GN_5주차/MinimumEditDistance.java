package 스터디.스터디_GN.스터디_GN_5주차;

/**
 * https://www.youtube.com/watch?v=We3YDTzNXEk
 * 참고 */
public class MinimumEditDistance {
    public int M[][] = new int[100][100];

    public static void main(String[] args)
    {
        String a = "abcdef";
        String b = "azced";
        MinimumEditDistance m = new MinimumEditDistance();
        m.getDistance(a, b);
        m.getTrace(m.M, a, b);
    }

    public int getMin(int a, int b, int c)
    {
        int min = a;
        if(min > b)
            min = b;
        if(min > c)
            min = c;
        return min;
    }

    public void getDistance(String a, String b)
    {
        for(int i = 0; i < a.length(); i++)
        {
            M[i][0] = i;
        }
        for(int j = 0; j < b.length(); j++)
        {
            M[0][j] = j;
        }
        for(int i = 1; i < a.length(); i++)
        {
            for(int j = 1; j < b.length(); j++)
            {
                if(a.charAt(i) == b.charAt(j))
                {
                    M[i][j] = M[i - 1][j - 1];
                }
                else
                {
                    M[i][j] = getMin(M[i - 1][j], M[i - 1][j - 1], M[i][j - 1]) + 1;
                }
            }
        }
        System.out.println(a + "와(과) " + b + "의 최소 편집 거리는 " + M[a.length() - 1][b.length() - 1] + "입니다.");
    }

    public void getTrace(int M[][], String a, String b)
    {
        System.out.println("[ " + b + "을(를) " + a + "로 바꾸는 과정 추적 ]");
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(!(i == 0 && j == 0))
        {
            int s = getMin(M[i - 1][j], M[i - 1][j - 1], M[i][j - 1]);
            if(s == M[i][j])
            {
                i -= 1;
                j -= 1;
            }
            else
            {
                if(s == M[i][j - 1])
                {
                    System.out.println(b.charAt(j) + "을(를) 삭제합니다.");
                    j -= 1;
                }
                else if(s == M[i - 1][j - 1])
                {
                    System.out.println(b.charAt(j) + "을(를) " + a.charAt(i) + "(으)로 변경합니다.");
                    i -= 1;
                    j -= 1;
                }
                else
                {
                    System.out.println(a.charAt(i) + "을(를) 추가합니다.");
                    i -= 1;
                }
            }
        }
    }



}