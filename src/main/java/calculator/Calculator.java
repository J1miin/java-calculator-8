package calculator;

import java.util.Vector;

public class Calculator {
    private int answer;
    Calculator(){
        this.answer = 0;
    }

    public void calculate (Vector<Integer> vNum){
        for (Integer i : vNum) {
            this.answer += i;
        }
    }
    public int getAnswer() {
        return answer;
    }
}
