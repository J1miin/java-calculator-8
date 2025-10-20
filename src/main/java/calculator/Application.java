package calculator;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.start();

        InputParser inputParser = new InputParser();
        inputParser.checkInput(inputView.getInput());
        ArrayList<Integer> nums = inputParser.getNums();

        Calculator calculator = new Calculator();
        calculator.calculate(nums);

        OutputView outputView = new OutputView();
        outputView.printResult(calculator.getAnswer());
    }
}
