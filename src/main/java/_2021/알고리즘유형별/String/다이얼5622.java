package _2021.알고리즘유형별.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 다이얼5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();


        HashMap<Character, Integer> hs = new HashMap<>();
        hs.put('A',2); hs.put('B',2); hs.put('C',2);
        hs.put('D',3); hs.put('E',3); hs.put('F',3);
        hs.put('G',4); hs.put('H',4); hs.put('I',4);
        hs.put('J',5); hs.put('K',5); hs.put('L',5);
        hs.put('M',6); hs.put('N',6); hs.put('O',6);
        hs.put('P',7); hs.put('Q',7); hs.put('R',7); hs.put('S',7);
        hs.put('T',8); hs.put('U',8); hs.put('V',8);
        hs.put('W',9); hs.put('X',9); hs.put('Y',9); hs.put('Z',9);

        int ans = 0;

        for(int i=0; i<str.length(); i++){
            if(hs.containsKey(str.charAt(i))){
                ans += hs.get(str.charAt(i));
            }
        }
        System.out.println(ans + str.length());











    }
}
