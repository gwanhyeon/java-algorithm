public class 방금그곡 {
    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String answer = solution(m,musicinfos);
        System.out.println(answer);
    }

    private static String solution(String m, String[] musicinfos){
        String answer = "";
        int max = 0;
        m = upperConvert(m);

        for (String musicinfo : musicinfos) {

            String[] arr = musicinfo.split(",");
            String st_time = arr[0];
            String end_time = arr[1];

            String st_h = st_time.substring(0, 2);
            String st_m = st_time.substring(3, 5);
            String en_h = end_time.substring(0, 2);
            String en_m = end_time.substring(3, 5);

            int start_h = Integer.parseInt(st_h
            );
            int start_m = Integer.parseInt(st_m);
            int end_h = Integer.parseInt(en_h);
            int end_m = Integer.parseInt(en_m);

            int hour = end_h - start_h;
            int min = end_m - start_m;
            int minutes = (hour * 60) + min;

            // 곡 정보
            arr[3] = upperConvert(arr[3]);

            char[] paper = arr[3].toCharArray();

            int a = minutes / paper.length;
            int b = minutes % paper.length;

            StringBuilder sb = new StringBuilder();

            // 시간 14 m 7 일경우 몫 2 나머지 0 이므로 a만큼 넣어주고 나머지 값만큼 문자하나씩넣어주기
            // 몫 만큼
            for (int j = 0; j < a; j++) {
                sb.append(arr[3]);
            }
            // 나머지 값만큼
            for (int j = 0; j < b; j++) {

                sb.append(arr[3].charAt(j));
            }

            String target = sb.toString();
            if (target.contains(m)) {
                if (max < minutes) {
                    answer = arr[2];
                    max = minutes;
                }
            }

        }

        if(answer.equals("")){
            answer = "(None)";
        }

        return answer;
    }

    private static String upperConvert(String m){
        m = m.replaceAll("A#","a");
        m = m.replaceAll("C#","c");
        m = m.replaceAll("D#","d");
        m = m.replaceAll("F#","f");
        m = m.replaceAll("G#","g");
        return m;
    }




}
