package Main;

import Main.Calculator.ArithmeticCalculator;
import Main.Calculator.CalcParser;
import Main.Calculator.CalculatorHistoryItem;
import Main.Enum.Menu;
import Main.Enum.OperatorType;
import Main.Exception.InvalidTypeInputException;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static ArithmeticCalculator<Double> calculator;
    public static Scanner sc;

    public static void main(String[] args) {
        createCalculator();
        start();
    }

    /**
     * 계산기를 생성한다.
     *
     * @author 김현정
     */
    public static void createCalculator() {
        calculator = new ArithmeticCalculator<>();
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
     * @author 김현정
     */
    public static Menu selectMenu() {
        // stream 으로 람다식(?) 처리
        // 계산기 메뉴 출력
        Arrays.stream(Menu.values()).forEach(menu ->
                System.out.println(menu.getIndex() + ". " + menu.getDescription()));

        while (true) {
            try {
                System.out.print("메뉴를 선택하세요. >> ");
                int inputNum = (int) CalcParser.ParserNumber(sc.nextLine());
                return Menu.getMenu(inputNum);
            } catch (InvalidTypeInputException e) {
                System.out.println(e.getErrorMsg());
            }
        }
    }

    /**
     * 숫자와 연산자를 입력받은 뒤 사칙연산을 수행한다.
     *
     * @param printInputMsg 숫자를 입력받을때 콘솔창에 출력할 메세지
     * @return 입력한 숫자
     * @author 김현정
     */
    public static double inputNumber(String printInputMsg) {
        while (true) {
            try {
                System.out.print(printInputMsg);
                return CalcParser.ParserNumber(sc.nextLine());
            } catch (InvalidTypeInputException e) {
                System.out.println(e.getErrorMsg());
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
        while (true) {
            try {
                System.out.print(printInputMsg);
                return OperatorType.getOperatorType(sc.nextLine());
            } catch (InvalidTypeInputException e) {
                System.out.println(e.getErrorMsg());
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
        OperatorType operatorType = inputOperator("사칙연산 기호를 입력해주세요 >> ");
        double secondNum = inputNumber("두번째 숫자를 입력해주세요 >> ");
        CalculatorHistoryItem calculatorHistoryItem = calculator.calculate(firstNum, secondNum, operatorType);
        calculator.addCalculatorHistoryItem(calculatorHistoryItem);
        System.out.println("결과 >> " + calculatorHistoryItem.getResult());
    }

    /**
     * 계산 결과 목록 출력
     *
     * @param menu 선택한 메뉴
     * @author 김현정
     */
    public static void printCalcHistory(Menu menu) {
        if (menu == Menu.HISTORY) {
            calculator.printAllHistories();
        } else {
            double num = inputNumber("숫자를 입력해주세요 >> ");
            calculator.printHistoriesBiggerThanTarget(num);
        }
    }

    /**
     * 첫번째 계산 결과 삭제
     *
     * @author 김현정
     */
    public static void removeFirstCalcHistory() {
        calculator.removeFirstCalcHistory();
    }
}