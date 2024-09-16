package Main.Operator;

/**
 * 빼기 연산을 수행하는 클래스
 *
 * @author 김현정
 */
public class SubOperator implements Operator{
    @Override
    public double operate(double firstNum, double secondNum) {
        return firstNum - secondNum;
    }
}
