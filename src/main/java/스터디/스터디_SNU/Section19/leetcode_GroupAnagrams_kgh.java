package 스터디.스터디_SNU.Section19;

import java.util.*;

/**
 * 1. 풀이시간: 50분
 * 2. 컴퓨팅사고
 * (1) 모든값들을 정렬하고나서 해당 키값에 해당되는 값을 정렬되지 않은 값으로 넣어준다.
 * (2) 그렇게 되면 정상적인 애나그램의 그룹을 구할 수 있게된다.
 * (3) computeIfAbsent를 통하여 모든 값들을 람다를 통해 재생성후 넣어주게된다.
 */
public class leetcode_GroupAnagrams_kgh {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        System.out.println(map.values());
        return new ArrayList<>(map.values());
    }
}
