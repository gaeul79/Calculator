package Main.Calculator;
import Main.Enum.OperatorType;
import Main.Exception.BadInputException;
import java.util.regex.Pattern;

public class CalcParser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    public static double ParserNumber(String strNum) throws BadInputException {
        if (Pattern.matches(NUMBER_REG, strNum)) {
            return Double.parseDouble(strNum);
        } else {
            throw new BadInputException("숫자");
        }
    }

    public static OperatorType ParserOperator(String operator) throws BadInputException {
        for (OperatorType type : OperatorType.values()) {
            if (type.getName().equals(operator)) {
                return type;
            }
        }

        throw new BadInputException("사칙 연산자");
    }
}
