package calculator;

import java.util.Vector;

public class InputParser {
    public static final String NOT_POSITIVE = "양수가 아닙니다.";
    public static final String DELIMITER_LENGTH = "커스텀구분자가 1개보다 많습니다.";
    public static final String STRANGE_INPUT = "입력값이 이상합니다.";
    public static final String EMPTY_INPUT = "입력값이 없습니다.";

    private int startIdx =0;
    private String customDelimiter ="";
    private final Vector<Integer> nums;

    InputParser(){
        this.nums = new Vector<>();
    }

    public void checkInput(String input) {
        isEmpty(input);
        findDelimiter(input);
        separateNum(input);
        checkPositive();
    }

    public void isEmpty(String input) {
        if (input.isEmpty()) {
            exception(EMPTY_INPUT);
        }
    }

    public void findDelimiter(String input){
        if (input.charAt(0)=='/' && input.charAt(1)=='/'){
            if (input.charAt(3)=='\\' && input.charAt(4)=='n'){
                customDelimiter += input.charAt(2);
                this.startIdx=5;
            } else {
                exception(DELIMITER_LENGTH);
            }
        }
    }

    public void separateNum(String input){
        String[] splitter ;
        if (customDelimiter.length() == 1) {
            input= input.substring(this.startIdx);
            if (customDelimiter.equals(".")) {
                splitter = input.split("\\.");
            } else {
                splitter = input.split(customDelimiter);
            }
        } else {
            splitter = input.split("[,:]");
        }

        for (String s : splitter) {
            try {
                nums.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                exception(STRANGE_INPUT);
            }
        }
    }

    private void checkPositive(){
        if (!nums.isEmpty()){
            for (Integer i : nums) {
                if (i<=0) {
                    exception(NOT_POSITIVE);
                }
            }
        }
    }

    public Vector<Integer> getNums() {
        return nums;
    }

    private static void exception(String msg){
        throw new IllegalArgumentException(msg);
    }
}
