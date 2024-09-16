package Main.Calculator;

import Main.Enum.OperatorType;
import Main.Operator.Operator;
import Main.Operator.OperatorFactory;

/**
 * 사칙연산을 수행하고 계산 결과를 관리하는 클래스
 *
 * @author 김현정
 */
public class ArithmeticCalculator<N extends Number> {
    private CalculatorHistory calculatorHistory;

    public OperatorFactory operatorFactory;

    public Operator getOperator(OperatorType operatorType) {
        return operatorFactory.getOperator(operatorType);
    }

    public ArithmeticCalculator() {
        calculatorHistory = new CalculatorHistory();
        operatorFactory = new OperatorFactory();
    }

    /**
     * 입력받은 두 숫자와 연산자로 사칙연산을 수행한다.
     *
     * @param firstNum     첫번째 숫자
     * @param secondNum    두번째 숫자
     * @param operatorType 사칙 연산자
     * @return 사칙연산 결과
     * @author 김현정
     */
    public CalculatorHistoryItem calculate(N firstNum, N secondNum, OperatorType operatorType) {
        double num1 = firstNum.doubleValue();
        double num2 = secondNum.doubleValue();
        double result = getOperator(operatorType).operate(num1, num2);
        return new CalculatorHistoryItem(num1, num2, operatorType, result);
    }

    /**
     * 계산 기록에 새로운 항목을 추가합니다.
     *
     * @param calculatorHistoryItem 추가할 계산 기록 항목
     * @author 김현정
     */
    public void addCalculatorHistoryItem(CalculatorHistoryItem calculatorHistoryItem) {
        calculatorHistory.addCalculatorHistoryItem(calculatorHistoryItem);
    }

    /**
     * 계산 기록에서 가장 최근의 항목을 삭제합니다.
     *
     * @author 김현정
     */
    public void removeFirstCalcHistory() {
        calculatorHistory.removeFirstResult();
    }

    /**
     * 모든 계산 기록을 출력합니다.
     *
     * @author 김현정
     */
    public void printAllHistories() {
        calculatorHistory.printAllCalcHistory();
    }

    /**
     * 결과가 특정 값보다 큰 계산 기록만을 출력합니다.
     *
     * @param inputNum 비교할 기준 값
     * @author 김현정
     */
    public void printHistoriesBiggerThanTarget(double inputNum) {
        calculatorHistory.printHistoriesBiggerThanTarget(inputNum);
    }
}
