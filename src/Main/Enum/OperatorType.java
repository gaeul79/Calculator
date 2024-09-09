package Main.Enum;

/** 사칙연산 종류 */
public enum OperatorType {
    ADD("+"), // 더하기
    SUBTRACT("-"), // 빼기
    MULTIPLY("*"), // 곱하기
    DIVIDE("/"); // 나누기

    private String name;

    OperatorType(String name) {
        this.name = name;
    }

    /**
     * 연산자 기호 반환.
     * @author 김현정
     * @return 연산 기호 반환
     */
    public String getName() { // 문자를 받아오는 함수
        return name;
    }
}