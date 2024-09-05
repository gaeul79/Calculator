import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int firstNum = 0;
        int secondNum = 0;
        double result = 0;
        String operator = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Lv1. 계산기를 시작합니다. ===");

        while (true) {
            System.out.print("첫번째 숫자를 입력해주세요 >> ");
            while (true) {
                firstNum = sc.nextInt();
                sc.nextLine();
                if (firstNum > 0) {
                    break;
                } else {
                    System.out.print("양의 정수를 입력해주세요 >> ");
                }
            }

            System.out.print("사칙연산 기호를 입력해주세요 >> ");
            while (true) {
                operator = sc.nextLine();
                if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                    break;
                } else {
                    System.out.print("올바른 사칙연산 기호(+, -, *, /)를 입력해주세요 >> ");
                }
            }

            System.out.print("두번째 숫자를 입력해주세요 >> ");
            while (true) {
                secondNum = sc.nextInt();
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

            switch (operator) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "*":
                    result = firstNum * secondNum;
                    break;
                case "/":
                    result = (double) firstNum / secondNum;
                    break;
                default:
                    break;
            }

            System.out.println("결과 >> " + result);
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) >> ");
            if(sc.nextLine().equals("exit"))
                break;
        }

        System.out.println("=== Lv1. 계산기를 종료합니다. ===");
    }
}