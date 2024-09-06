import java.util.regex.Pattern;

public class Parser<T> {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    public void parser(String inputData, InputType inputType) throws BadInputException {
        switch (inputType) {
            case Operand:
                if(!Pattern.matches(NUMBER_REG, inputData)) {
                    throw new BadInputException("숫자");
                }
            case Operator:
                if(!Pattern.matches(OPERATION_REG, inputData)) {
                    throw new BadInputException("[+, -, *, /]중 하나");
                }
            default:
                break;
        }
    }
}
