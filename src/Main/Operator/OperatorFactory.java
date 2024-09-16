package Main.Operator;

import Main.Enum.OperatorType;

/**
 * 지정된 연산자 타입에 해당하는 연산자 객체를 생성하고 반환하는 class
 *
 * @author 김현정
 */
public class OperatorFactory {
    /**
     * 지정된 연산자 타입에 해당하는 연산자 객체를 생성하고 반환합니다.
     *
     * @param operatorType 연산자 타입
     * @return 연산자 객체
     * @author 김현정
     */
    public Operator getOperator(OperatorType operatorType) {
        return switch (operatorType) {
            case ADD -> new AddOperator();
            case SUBTRACT -> new SubOperator();
            case MULTIPLY -> new MulOperator();
            case DIVIDE -> new DivOperator();
        };
    }
}
