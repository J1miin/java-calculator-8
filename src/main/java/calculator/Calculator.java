package calculator;

import java.util.ArrayList;

public class Calculator {
    private int answer;
    Calculator(){
        this.answer = 0;
    }

    public void calculate (ArrayList<Integer> nums){
        for (Integer i : nums) {
            this.answer += i;
        }
    }
    public int getAnswer() {
        return answer;
    }
}
