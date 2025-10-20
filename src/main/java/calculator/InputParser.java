package calculator;

import java.util.ArrayList;

public class InputParser {
    private int startIdx = 0;
    private String customDelimiter = "";
    private final ArrayList<Integer> nums;

    InputParser() {
        this.nums = new ArrayList<>();
    }

    public void checkInput(String input) {
        isEmpty(input);
        findDelimiter(input);
        separateNum(input);
        checkPositive();
    }

    public void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT);
        }
    }

    public void findDelimiter(String input) {
        if (input.charAt(0) == '/' && input.charAt(1) == '/') {
            if (input.charAt(3) == '\\' && input.charAt(4) == 'n') {
                customDelimiter += input.charAt(2);
                this.startIdx = 5;
            } else {
                throw new IllegalArgumentException(ErrorMessage.DELIMITER_LENGTH);
            }
        }
    }

    public void separateNum(String input) {
        String[] splitter;
        if (customDelimiter.length() == 1) {
            input = input.substring(this.startIdx);
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
                throw new IllegalArgumentException(ErrorMessage.STRANGE_INPUT);
            }
        }
    }

    private void checkPositive() {
        if (!nums.isEmpty()) {
            for (Integer i : nums) {
                if (i <= 0) {
                    throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE);
                }
            }
        }
    }

    public ArrayList<Integer> getNums() {
        return nums;
    }

}
