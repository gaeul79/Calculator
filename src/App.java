import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Lv3. 계산기를 시작합니다. ===");

//        Calculator calculator = new Calculator();
//        calculator.setCalcHistoryItems(new ArrayList<>());
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        calculator.setCalcHistoryItems(new ArrayList<String>());

        while (true) {
            System.out.println("1. 연산 기록 보기");
            System.out.println("2. 계산");
            System.out.println("3. 첫번째 연산 기록 삭제");
            int menu = 0;
            System.out.print("메뉴를 선택하세요. >> ");
            while (true) {
                menu = sc.nextInt();
                sc.nextLine();
                if (menu < 1 || menu > 3) {
                    System.out.print("메뉴(1~3)를 선택하세요. >> ");
                } else {
                    break;
                }
            }

            switch (menu) {
                case 1:
                    int idx = 1;
                    System.out.println("=== 연산 기록 ===");
                    if (calculator.getCalcHistoryItems().isEmpty()) {
                        System.out.println("History is empty...");
                    } else {
                        for (var calcHistoryItem : calculator.getCalcHistoryItems()) {
                            System.out.println(idx + ". " + calcHistoryItem.toString());
                        }
                    }
                    System.out.println("================");
                    break;
                case 2:
                    double firstNum = 0;
                    System.out.print("첫번째 숫자를 입력해주세요 >> ");
                    while (true) {
                        firstNum = sc.nextDouble();
                        sc.nextLine();
                        if (firstNum > 0) {
                            break;
                        } else {
                            System.out.print("양의 정수를 입력해주세요 >> ");
                        }
                    }

                    String operator = null;
                    System.out.print("사칙연산 기호를 입력해주세요 >> ");
                    while (true) {
                        operator = sc.nextLine();
                        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                            break;
                        } else {
                            System.out.print("올바른 사칙연산 기호(+, -, *, /)를 입력해주세요 >> ");
                        }
                    }

                    double secondNum = 0;
                    System.out.print("두번째 숫자를 입력해주세요 >> ");
                    while (true) {
                        secondNum = sc.nextDouble();
                        sc.nextLine();
                        if (secondNum > 0) {
                            break;
                        } else if (secondNum == 0 && operator.equals("/")) {
                            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                            System.out.print("양의 정수를 입력해주세요 >> ");
                        } else {
                            System.out.println("양의 정수를 입력해주세요 >> ");
                        }
                    }

                    var result = calculator.calculate(firstNum, secondNum, OperatorType.ADD);
                    System.out.println("결과 >> " + result.toString());
                    break;
                case 3:
                    //calculator.();
                    System.out.println("첫번째 기록을 삭제하였습니다.");
                    break;
                default:
                    break;
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) >> ");
            if (sc.nextLine().equals("exit"))
                break;
        }

        System.out.println("=== Lv2. 계산기를 종료합니다. ===");
    }
}