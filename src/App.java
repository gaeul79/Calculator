import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static ArithmeticCalculator calculator;
    public static Scanner sc;

    public static void main(String[] args) throws BadInputException {
        createCalculator();
        startCalculator();
    }

    public static int selectMenu() {
        System.out.println("=== Lv3. 계산기를 시작합니다. ===");
        System.out.println("1. 계산");
        System.out.println("2. 연산 기록 보기");
        System.out.println("3. 입력받은 값보다 큰 결과값 출력");
        System.out.println("4. 첫번째 연산 기록 삭제");
        System.out.print("메뉴를 선택하세요. >> ");
        while (true) {
            int menu = sc.nextInt();
            sc.nextLine();
            if (menu < 1 || menu > 3) {
                System.out.print("메뉴(1~4)를 선택하세요. >> ");
            } else {
                return menu;
            }
        }
    }

    public static void createCalculator() {
        calculator = new ArithmeticCalculator();
        calculator.setCalcHistoryItems(new ArrayList<String>());
    }

    public static void startCalculator() {
        sc = new Scanner(System.in);
        while (true) {
            switch (selectMenu()) {
                case 1:
                    basicCalculator();
                    break;
                case 2:
                    printCalcHistory(true);
                    break;
                case 3:
                    printCalcHistory(false);
                    break;
                case 4:
                    removeFirstCalcHistory();
                    break;
                default:
                    break;
            }

            if(finish())
                break;
        }
    }

    public static boolean finish() {
        System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) >> ");
        if(sc.nextLine().equals("exit")) {
            System.out.println("=== Lv3. 계산기를 종료합니다. ===");
            return true;
        }
        else {
            return false;
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
                return CalcParser.ParserOperand(sc.nextLine());
            } catch (BadInputException e) {
                System.out.print(e.getMessage());
            }
            sc.nextLine();
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

    public static void printCalcHistory(boolean isAll) {
        System.out.println("=== 연산 기록 ===");
        if (calculator.getCalcHistoryItems().isEmpty()) {
            System.out.println("History is empty...");
        } else {
            for (var calcHistoryItem : calculator.getCalcHistoryItems()) {
                System.out.println(calcHistoryItem.toString());
            }
        }
        System.out.println("================");
    }

    public static void removeFirstCalcHistory() {
        calculator.removeFirstResult();
        System.out.println("첫번째 기록을 삭제하였습니다.");
    }
}