package Main.Operator;

/**
 * 곱셈을 수행하는 클래스
 *
 * @author 김현정
 */
public class MulOperator implements Operator {
    @Override
    public double operate(double firstNum, double secondNum) {
        return firstNum * secondNum;
    }
}
