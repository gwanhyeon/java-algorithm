import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {
    public static void main(String[] args) {

        //String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        //String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        //String[] operations = {"I 16","D 1"};
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        int[] answer = new int[2];
        for(int i=0; i<operations.length; i++){
            StringTokenizer st = new StringTokenizer(" ",operations[i]);
            String[] tmp = operations[i].split(" ");

            String command = tmp[0];
            String value = tmp[1];

            if(command.equals("I")){
                max_heap.add(Integer.parseInt(value));
                min_heap.add(Integer.parseInt(value));
            }else {
                // min delete

                    if (Integer.parseInt(value) == -1 && !min_heap.isEmpty()) {
                        min_heap.poll();
                        max_heap.remove();

                        //q.remove(q.size() - 1);
                        //System.out.println(q.peek());
                    }// max delete
                    else if(Integer.parseInt(value) == 1 && !max_heap.isEmpty()){
                        max_heap.poll();
                        max_heap.remove();

                        //min_heap.remove();
                        //System.out.println(q.peek());
                    }

            }
        }
        if(!max_heap.isEmpty() && !min_heap.isEmpty()){
            if(!max_heap.peek().equals(min_heap.peek())){
                answer[0] = max_heap.poll();
                answer[1] = min_heap.poll();
            }

        }

        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}
