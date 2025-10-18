package calculator;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.start();

        InputParser inputParser = new InputParser();

        try {
            inputParser.checkInput(inputView.getInput());
            inputView.setNums(inputParser.getNums());

            Calculator calculator = new Calculator();
            calculator.calculate(inputView.getNums());

            OutputView outputView = new OutputView();
            outputView.printResult(calculator.getAnswer());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
