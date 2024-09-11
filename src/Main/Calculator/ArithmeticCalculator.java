package Main.Calculator;

import Main.Enum.OperatorType;

import java.util.List;

/**
 * 계산을 수행하는 클래스
 */
public class ArithmeticCalculator<N extends Number> {
    private List<CalculatorItem> calcHistoryItems;

    public List<CalculatorItem> getAllCalcHistoryItems() {
        return calcHistoryItems;
    }

    public void setCalcHistoryItems(List<CalculatorItem> calcHistoryItems) {
        this.calcHistoryItems = calcHistoryItems;
    }

    /**
     * 첫번째 계산 결과 삭제
     *
     * @author 김현정
     */
    public void removeFirstResult() {
        if (!calcHistoryItems.isEmpty()) {
            calcHistoryItems.remove(0);
        }
    }

    /**
     * 입력받은 두 숫자와 연산자로 사칙연산을 수행한다.
     *
     * @param firstNum  첫번째 숫자
     * @param secondNum 두번째 숫자
     * @param operator  사칙 연산자
     * @return 사칙연산 결과
     * @author 김현정
     */
    public N calculate(N firstNum, N secondNum, OperatorType operator) {
        double num1 = firstNum.doubleValue();
        double num2 = secondNum.doubleValue();

        CalculatorItem calcItem = new CalculatorItem();
        calcItem.setFirstNumber(num1);
        calcItem.setSecondNumber(num2);
        calcItem.setOperator(operator);

        switch (operator) {
            case ADD -> calcItem.setResult(num1 + num2);
            case SUBTRACT -> calcItem.setResult(num1 - num2);
            case MULTIPLY -> calcItem.setResult(num1 * num2);
            case DIVIDE -> calcItem.setResult(num1 / num2);
        }

        calcHistoryItems.add(calcItem);
        return (N) (Number) calcItem.getResult();
    }
}
