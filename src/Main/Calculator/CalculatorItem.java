package Main.Calculator;

/** 계산기 로그용 클래스 */
public class CalculatorItem {
    private double firstNumber;
    public double getFirstNumber() {
        return firstNumber;
    }
    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    private double secondNumber;
    public double getSecondNumber() {
        return secondNumber;
    }
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

    private String operator;
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void printResult() {
        System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result);
    }
}
