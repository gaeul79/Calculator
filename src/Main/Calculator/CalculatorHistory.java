package Main.Calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 계산 기록을 관리하는 클래스
 *
 * @author 김현정
 */
public class CalculatorHistory {
    private List<CalculatorHistoryItem> calcHistoryItems;

    public CalculatorHistory() {
        calcHistoryItems = new ArrayList<>();
    }

    /**
     * 계산기의 이전 계산 결과를 저장하는 목록에 새로운 항목을 추가합니다.
     *
     * @param calcItem 추가할 계산 기록 항목
     * @author 김현정
     */
    public void addCalculatorHistoryItem(CalculatorHistoryItem calcItem) {
        calcHistoryItems.add(calcItem);
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

        if (calcHistoryItems.isEmpty()) {
            System.out.println("History is empty.");
        } else {
            calcHistoryItems.remove(0);
            System.out.println("첫번째 기록을 삭제하였습니다.");
        }
    }

    /**
     * 계산 결과가 입력한 값보다 큰 계산 기록을 출력합니다.
     *
     * @param inputNum 비교할 기준 값
     * @author 김현정
     */
    public void printHistoriesBiggerThanTarget(double inputNum) {
        printCalcHistory(getHistoriesBiggerThanTarget(inputNum));
    }

    /**
     * 계산 결과가 입력한 값보다 큰 계산 기록을 반환합니다.
     *
     * @param inputNum 비교할 기준 값
     * @author 김현정
     */
    private List<CalculatorHistoryItem> getHistoriesBiggerThanTarget(double inputNum) {
        return calcHistoryItems.stream()
                .filter(item -> item.getResult() > inputNum).toList();
    }

    /**
     * 모든 계산 기록을 출력합니다.
     *
     * @author 김현정
     */
    public void printAllCalcHistory() {
        printCalcHistory(calcHistoryItems);
    }

    /**
     * 계산 기록 목록을 출력합니다.
     *
     * @param calcHistoryItems 출력할 계산 기록 목록
     * @author 김현정
     */
    private void printCalcHistory(List<CalculatorHistoryItem> calcHistoryItems) {
        System.out.println("=== 연산 기록 ===");
        if (calcHistoryItems.isEmpty()) {
            System.out.println("History is empty...");
        } else {
            calcHistoryItems.forEach(CalculatorHistoryItem::printResult);
        }
        System.out.println("================");
    }
}
