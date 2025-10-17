package calculator;

import java.util.Vector;

import static java.lang.Character.isDigit;

public class InputParser {
    public static final String NOT_POSITIVE = "양수가 아닙니다.";
    public static final String STRANGE_DELIMITER = "커스텀구분자가 이상합니다.";
    public static final String STRANGE_INPUT = "입력값이 이상합니다.";

    private int startIdx =0;
    private char customDelimiter =' ';
    private Vector<Integer> nums;

    InputParser(){
        this.nums = new Vector<>();
    }

    public void checkInput(String sInput) {
        findDelimiter(sInput);
        separateNum(sInput);
        checkPositive();
    }

    public void findDelimiter(String sInput){
        if (sInput.charAt(0)=='/' && sInput.charAt(1)=='/'){
            customDelimiter= sInput.charAt(2);
            this.startIdx=5;
        }
    }

    public void separateNum(String sInput){
        String sTmp = "";
        for (int i = this.startIdx; i<sInput.length(); i++){
            char cTmp = sInput.charAt(i);
            if (isDigit(cTmp)){
                sTmp = sTmp + cTmp;
            }else {
                if (i== this.startIdx) exception(STRANGE_DELIMITER);
                if (customDelimiter!=' '){
                    if (cTmp==customDelimiter){
                        if (!sTmp.isEmpty()) {
                            nums.add(Integer.parseInt(sTmp));
                        }
                    }
                }else{
                    if (cTmp == ',' || cTmp==':') {
                        nums.add(Integer.parseInt(sTmp));
                    }else{
                        exception(STRANGE_INPUT);
                    }
                }
                sTmp = "";
            }
        }
        nums.add(Integer.parseInt(sTmp));
    }

    private void checkPositive(){
        if (!nums.isEmpty()){
            for (Integer i : nums) {
                if (i<=0) {
                    exception(NOT_POSITIVE);
                }
            }
        }else {
            exception(STRANGE_INPUT);
        }
    }

    public Vector<Integer> getNums() {
        return nums;
    }

    private static void exception(String msg){
        throw new IllegalArgumentException(msg);
    }
}
