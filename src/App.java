import java.util.ArrayList;
import java.util.Arrays;
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
            switch (selectMenu()) {
                case CALCULATOR:
                    basicCalculator();
                    break;
                case HISTORY:
                    printCalcHistory();
                    break;
                case HIGH_HISTORY:
                    double num = inputNum("숫자를 입력해주세요 >> ");
                    printCalcHistory(num);
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
        if (sc.nextLine().equals("exit")) {
            return false;
        } else {
            return true;
        }
    }

    public static void finish() {
        System.out.println("=== Lv3. 계산기를 종료합니다. ===");
    }

    public static WorkType selectMenu() {
        // stream 으로 람다식(?) 처리
        Arrays.stream(WorkType.values()).forEach( workType ->
                System.out.println(workType.getIndex() + ". " + workType.getDescription()));

        System.out.print("메뉴를 선택하세요. >> ");
        while (true) {
            try {
                int inputNum = (int) CalcParser.ParserNumber(sc.nextLine());
                if (inputNum < 1 || inputNum > WorkType.values().length) {
                    throw new BadInputException("범위안에 메뉴");
                }

                for (WorkType workType : WorkType.values()) {
                    if (workType.getIndex() == inputNum) {
                        return workType;
                    }
                }
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

    public static void printCalcHistory() {
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

    public static void printCalcHistory(double num) {
        System.out.println("=== 연산 기록 ===");
        var bigHistoryItems = calculator.getCalcHistoryItems().stream().filter(calcHistoryItem ->
                Double.parseDouble(calcHistoryItem.toString()) > num).toList();

        if (bigHistoryItems.isEmpty()) {
            System.out.println("History is empty...");
        } else {
            bigHistoryItems.forEach(System.out::println); // 좋은데 stream 사용하니까 왜이리 노란줄이 그이는거지..?
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