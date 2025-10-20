package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class InputView {
    private String sInput;
    private ArrayList<Integer> vNum;
    InputView(){}

    public void start(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        setInput();
    }

    public void setInput(){
        this.sInput= Console.readLine();
    }

    public String getInput(){
        return this.sInput;
    }

    public void setNums(ArrayList<Integer> vNum){
        this.vNum = vNum;
    }

    public ArrayList<Integer> getNums(){
        return this.vNum;
    }
}
