package Main.Calculator;
import Main.Enum.OperatorType;
import java.util.ArrayList;

/** 계산을 수행하는 클래스 */
public class ArithmeticCalculator<T> {
    private ArrayList<T> calcHistoryItems;

    public ArrayList<T> getCalcHistoryItems() {
        return calcHistoryItems;
    }

    public void setCalcHistoryItems(ArrayList<T> calcHistoryItems) {
        this.calcHistoryItems = calcHistoryItems;
    }

    /**
     * 첫번째 계산 결과 삭제
     * @author 김현정
     */
    public void removeFirstResult() {
        if (!calcHistoryItems.isEmpty()) {
            calcHistoryItems.remove(0);
        }
    }

    /**
     * 입력받은 두 숫자와 연산자로 사칙연산을 수행한다.
     * @author 김현정
     * @param firstNum 첫번째 숫자
     * @param secondNum 두번째 숫자
     * @param operator 사칙 연산자
     * @return <T> 사칙연산 결과
     */
    public T calculate(T firstNum, T secondNum, T operator) {
        Double result;
        double num1 = (double) firstNum; // 이렇게 해도 되는걸까..ㅠ
        double num2 = (double) secondNum;

        if (operator == OperatorType.ADD) {
            result = num1 + num2;
            calcHistoryItems.add((T) result);
        } else if (operator == OperatorType.SUBTRACT) {
            result = num1 - num2;
            calcHistoryItems.add((T) result);
        } else if (operator == OperatorType.MULTIPLY) {
            result = num1 * num2;
            calcHistoryItems.add((T) result);
        } else {
            result = num1 / num2;
            calcHistoryItems.add((T) result);
        }

        return calcHistoryItems.get(calcHistoryItems.size() - 1);
    }
}
