package 손코딩준비;

import java.util.Stack;
// https://limkydev.tistory.com/185
public class 스택두개로_큐만들기 {
    public static void main(String[] args) {
        StackToQueue q = new StackToQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());

    }

    private static class StackToQueue {
        Stack<Object> inStack = new Stack();
        Stack<Object> outStack = new Stack();

        public void add(Object obj){
            inStack.add(obj);
        }
        public Object pop(){
            if(outStack.isEmpty()){
                while(!inStack.isEmpty()){
                    outStack.add(inStack.pop());
                }
            }
            return outStack.pop();
        }

    }
}

// 스택에 아무것도 없는 상태에서 pop을 수행하려고 할 때 첫번째 스택에 쌓여있는 값들을 전부 2번째 스택으로 이관시키는 것이 포인트입니다!