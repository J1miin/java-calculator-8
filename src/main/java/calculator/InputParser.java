package calculator;

import java.util.Vector;

public class InputParser {
    public static final String NOT_POSITIVE = "양수가 아닙니다.";
    public static final String DELIMITER_LENGTH = "커스텀구분자가 1개보다 많습니다.";
    public static final String STRANGE_DELIMITER = "커스텀구분자가 이상합니다.";
    public static final String STRANGE_INPUT = "입력값이 이상합니다.";
    public static final String EMPTY_INPUT = "입력값이 없습니다.";

    private int startIdx =0;
    private String customDelimiter ="";
    private Vector<Integer> nums;

    InputParser(){
        this.nums = new Vector<>();
    }

    public void checkInput(String sInput) {
        isEmpty(sInput);
        findDelimiter(sInput);
        separateNum(sInput);
        checkPositive();
    }

    public void isEmpty(String sInput) {
        if (sInput.isEmpty()) {
            exception(EMPTY_INPUT);
        }
    }

    public void findDelimiter(String sInput){
        if (sInput.charAt(0)=='/' && sInput.charAt(1)=='/'){
            if (sInput.charAt(3)=='\\' && sInput.charAt(4)=='n'){
                customDelimiter += sInput.charAt(2);
                this.startIdx=5;
            } else {
                exception(DELIMITER_LENGTH);
            }
        }
    }

    public void separateNum(String sInput){
        String[] splitter ;
        if (customDelimiter.length() == 1) {
            sInput= sInput.substring(this.startIdx);
            if (customDelimiter.equals(".")) {
                splitter = sInput.split("\\.");
            } else {
                splitter = sInput.split(customDelimiter);
            }
        } else {
            splitter = sInput.split("[,:]");
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
