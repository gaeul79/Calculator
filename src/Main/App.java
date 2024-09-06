package Main;

import Main.Calculator.ArithmeticCalculator;
import Main.Calculator.CalcParser;
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

    public static void createCalculator() {
        calculator = new ArithmeticCalculator();
        calculator.setCalcHistoryItems(new ArrayList<String>());
    }

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
                case HIGH_HISTORY:
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

    public static boolean repeat() {
        System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) >> ");
        return !sc.nextLine().equals("exit");
    }

    public static void finish() {
        System.out.println("=== Lv3. 계산기를 종료합니다. ===");
    }

    public static Menu selectMenu() {
        // stream 으로 람다식(?) 처리
        Arrays.stream(Menu.values()).forEach(menu ->
                System.out.println(menu.getIndex() + ". " + menu.getDescription()));

        System.out.print("메뉴를 선택하세요. >> ");
        while (true) {
            try {
                int inputNum = (int) CalcParser.ParserNumber(sc.nextLine());
                if(Arrays.stream(Menu.values()).filter(menu -> menu.getIndex() == inputNum).findFirst().isEmpty())
                    throw new BadInputException("범위안에 메뉴");

                return Menu.values()[inputNum];
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public static void basicCalculator() {
        double firstNum = inputNum("첫번째 숫자를 입력해주세요 >> ");
        OperatorType operator = inputOperator("사칙연산 기호를 입력해주세요 >> ");
        double secondNum = inputNum("두번째 숫자를 입력해주세요 >> ");
        var result = calculator.calculate(firstNum, secondNum, operator);
        System.out.println("결과 >> " + result.toString());
    }

    public static double inputNum(String printInputMsg) {
        System.out.print(printInputMsg);
        while (true) {
            try {
                return CalcParser.ParserNumber(sc.nextLine());
            } catch (BadInputException e) {
                System.out.print(e.getMessage());
            }
        }
    }

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

    public static void printCalcHistory(Menu menu) {
        List historyItems;
        if(menu == Menu.HISTORY) {
            historyItems = calculator.getCalcHistoryItems();
        }
        else {
            double num = inputNum("숫자를 입력해주세요 >> ");
            historyItems = calculator.getCalcHistoryItems().stream().filter(calcHistoryItem ->
                    Double.parseDouble(calcHistoryItem.toString()) > num).toList();
        }

        System.out.println("=== 연산 기록 ===");
        if (historyItems.isEmpty()) {
            System.out.println("History is empty...");
        } else {
            historyItems.forEach(System.out::println); // 좋은데 stream 사용하니까 왜이리 노란줄이 그이는거지..?
        }
        System.out.println("================");
    }

    public static void removeFirstCalcHistory() {
        if (calculator.getCalcHistoryItems().isEmpty()) {
            System.out.println("History is empty.");
        } else {
            calculator.removeFirstResult();
            System.out.println("첫번째 기록을 삭제하였습니다.");
        }
    }
}