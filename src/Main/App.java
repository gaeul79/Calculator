package Main;

import Main.Calculator.ArithmeticCalculator;
import Main.Calculator.CalcParser;
import Main.Calculator.CalculatorItem;
import Main.Enum.Menu;
import Main.Enum.OperatorType;
import Main.Exception.BadInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static ArithmeticCalculator calculator;
    public static Scanner sc;

    public static void main(String[] args) throws BadInputException {
        createCalculator();
        start();
    }

    /**
     * 계산기를 생성한다.
     *
     * @author 김현정
     */
    public static void createCalculator() {
        calculator = new ArithmeticCalculator();
        calculator.setCalcHistoryItems(new ArrayList<CalculatorItem>());
    }

    /**
     * 계산기를 시작한다.
     *
     * @author 김현정
     */
    public static void start() {
        sc = new Scanner(System.in);
        System.out.println("=== Lv3. 계산기를 시작합니다. ===");
        while (true) {
            Menu menu = selectMenu();
            switch (menu) {
                case CALCULATOR:
                    basicCalculator();
                    break;
                case HISTORY:
                case HIGH_RESULT_HISTORY:
                    printCalcHistory(menu);
                    break;
                case REMOVE_FIRST_HISTORY:
                    removeFirstCalcHistory();
                    break;
                case END:
                    finish();
                    return;
                default:
                    break;
            }

            if (!repeat()) {
                finish();
                break;
            }
        }
    }

    /**
     * 계산을 반복할지 여부를 받는다.
     *
     * @return 반복여부
     * @author 김현정
     */
    public static boolean repeat() {
        System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) >> ");
        return !sc.nextLine().equals("exit");
    }

    /**
     * 계산기 종료 메세지 출력.
     *
     * @author 김현정
     */
    public static void finish() {
        System.out.println("=== Lv3. 계산기를 종료합니다. ===");
    }

    /**
     * 계산기 종료 메세지 출력.
     *
     * @return 선택한 메뉴
     * @throws BadInputException 선택 범위를 벗어난 메뉴
     * @author 김현정
     */
    public static Menu selectMenu() {
        // stream 으로 람다식(?) 처리
        // 계산기 메뉴 출력
        Arrays.stream(Menu.values()).forEach(menu ->
                System.out.println(menu.getIndex() + ". " + menu.getDescription()));

        System.out.print("메뉴를 선택하세요. >> ");
        while (true) {
            try {
                int inputNum = (int) CalcParser.ParserNumber(sc.nextLine());
                for (Menu menu : Menu.values()) {
                    if (menu.getIndex() == inputNum) {
                        return menu;
                    }
                }
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }

    /**
     * 숫자와 연산자를 입력받은 뒤 사칙연산을 수행한다.
     *
     * @author 김현정
     */
    public static void basicCalculator() {
        double firstNum = inputNumber("첫번째 숫자를 입력해주세요 >> ");
        OperatorType operator = inputOperator("사칙연산 기호를 입력해주세요 >> ");
        double secondNum = inputNumber("두번째 숫자를 입력해주세요 >> ");
        double result = calculator.calculate(firstNum, secondNum, operator);
        System.out.println("결과 >> " + result);
    }

    /**
     * 숫자와 연산자를 입력받은 뒤 사칙연산을 수행한다.
     *
     * @param printInputMsg 숫자를 입력받을때 콘솔창에 출력할 메세지
     * @return 입력한 숫자
     * @author 김현정
     */
    public static double inputNumber(String printInputMsg) {
        System.out.print(printInputMsg);
        while (true) {
            try {
                return CalcParser.ParserNumber(sc.nextLine());
            } catch (BadInputException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    /**
     * 숫자와 연산자를 입력받은 뒤 사칙연산을 수행한다.
     *
     * @param printInputMsg 숫자를 입력받을때 무슨 숫자를 입력할지 콘솔창에 출력할 메세지
     * @return 입력한 숫자
     * @author 김현정
     */
    public static OperatorType inputOperator(String printInputMsg) {
        System.out.print(printInputMsg);
        while (true) {
            try {
                return CalcParser.ParserOperator(sc.nextLine());
            } catch (BadInputException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    /**
     * 계산 결과 목록 출력
     *
     * @param menu 선택한 메뉴
     * @author 김현정
     */
    public static void printCalcHistory(Menu menu) {
        List<CalculatorItem> historyItems;
        if (menu == Menu.HISTORY) {
            historyItems = calculator.getCalcHistoryItems();
        } else {
            double num = inputNumber("숫자를 입력해주세요 >> ");
            historyItems = ((List<CalculatorItem>) calculator.getCalcHistoryItems()).stream()
                    .filter(item -> item.getResult() > num).toList();
        }

        System.out.println("=== 연산 기록 ===");
        if (historyItems.isEmpty()) {
            System.out.println("History is empty...");
        } else {
            historyItems.forEach(CalculatorItem::printResult);
        }
        System.out.println("================");
    }

    /**
     * 첫번째 계산 결과 삭제
     *
     * @author 김현정
     */
    public static void removeFirstCalcHistory() {
        if (calculator.getCalcHistoryItems().isEmpty()) {
            System.out.println("History is empty.");
        } else {
            calculator.removeFirstResult();
            System.out.println("첫번째 기록을 삭제하였습니다.");
        }
    }
}