package Main.Calculator;

import Main.Enum.OperatorType;

import java.util.List;

/** 계산을 수행하는 클래스 */
public class ArithmeticCalculator<T> {
    private List<CalculatorItem> calcHistoryItems;

    public List<CalculatorItem> getCalcHistoryItems() {
        return calcHistoryItems;
    }

    public void setCalcHistoryItems(List<CalculatorItem> calcHistoryItems) {
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
     * @return 사칙연산 결과
     */
    public double calculate(T firstNum, T secondNum, OperatorType operator) {
        double num1 = (double) firstNum; // 이렇게 해도 되는걸까..ㅠ
        double num2 = (double) secondNum;

        CalculatorItem calcItem = new CalculatorItem();
        calcItem.setFirstNumber(num1);
        calcItem.setSecondNumber(num2);
        calcItem.setOperator(operator);

        if (operator == OperatorType.ADD)
            calcItem.setResult(num1 + num2);
        else if (operator == OperatorType.SUBTRACT)
            calcItem.setResult(num1 - num2);
        else if (operator == OperatorType.MULTIPLY)
            calcItem.setResult(num1 * num2);
        else
            calcItem.setResult(num1 / num2);

        calcHistoryItems.add(calcItem);
        return calcItem.getResult();
    }
}
