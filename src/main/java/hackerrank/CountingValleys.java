package hackerrank;

import java.io.*;

class Result {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int valleyCount = 0;
        boolean isCheck = false;
        int answer = 0;
        for(char c : path.toCharArray()){
            if(c == 'U'){
                valleyCount++;
            }else {
                valleyCount--;
            }
            if(valleyCount < 0 && !isCheck){
                isCheck = true;
                continue;
            }
            if(isCheck && valleyCount == 0){
                answer++;
                isCheck = false;
            }
        }
        return answer;
    }

}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
