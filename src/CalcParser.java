import java.util.regex.Pattern;

public class CalcParser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    public static double ParserOperand(String strFirstNum) throws BadInputException {
        if (Pattern.matches(NUMBER_REG, strFirstNum)) {
            return Double.parseDouble(strFirstNum);
        } else {
            throw new BadInputException("숫자");
        }
    }

    public static OperatorType ParserOperator(String operator) throws BadInputException {
        for(OperatorType type : OperatorType.values()){
            if(type.getName().equals(operator)){
                return type;
            }
        }

        throw new BadInputException("사칙 연산자");
    }
}
