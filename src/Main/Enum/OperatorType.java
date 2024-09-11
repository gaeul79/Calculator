package Main.Enum;

import Main.Exception.BadInputException;

/**
 * 사칙연산 종류
 */
public enum OperatorType {
    ADD("+"), // 더하기
    SUBTRACT("-"), // 빼기
    MULTIPLY("*"), // 곱하기
    DIVIDE("/"); // 나누기

    private String symbol;

    OperatorType(String name) {
        this.symbol = name;
    }

    /**
     * 연산자 기호 반환.
     *
     * @return 연산 기호 반환
     * @author 김현정
     */
    public String getSymbol() { // 문자를 받아오는 함수
        return symbol;
    }

    /**
     * 입력받은 문자열에 해당하는 연산자 반환.
     *
     * @param symbol 입력받은 문자열
     * @return 연산자 반환
     * @throws BadInputException 잘못된 연산자 입력
     * @author 김현정
     */
    public static OperatorType getOperatorType(String symbol) throws BadInputException {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.getSymbol().equals(symbol))
            {
                return operatorType;
            }
        }

        throw new BadInputException("사칙 연산자");
    }
}