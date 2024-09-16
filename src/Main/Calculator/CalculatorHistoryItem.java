package Main.Calculator;

import Main.Enum.OperatorType;

/**
 * 계산기 로그용 클래스
 *
 * @author 김현정
 */
public class CalculatorHistoryItem {
    private double firstNumber;

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    private double secondNumber;

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    private double result;

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    private OperatorType operator;

    public void setOperator(OperatorType operator) {
        this.operator = operator;
    }

    public CalculatorHistoryItem(double firstNumber, double secondNumber, OperatorType operator, double result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.result = result;
    }

    /**
     * 계산 결과 목록 출력
     *
     * @author 김현정
     */
    public void printResult() {
        System.out.println(firstNumber + " " + operator.getSymbol() + " " + secondNumber + " = " + result);
    }
}
