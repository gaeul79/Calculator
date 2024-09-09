package Main.Calculator;

import Main.Enum.OperatorType;

/**
 * 계산기 로그용 클래스
 */
public class CalculatorItem {
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

    /**
     * 계산 결과 목록 출력
     *
     * @author 김현정
     */
    public void printResult() {
        System.out.println(firstNumber + " " + operator.getName() + " " + secondNumber + " = " + result);
    }
}
