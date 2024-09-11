package Main.Calculator;

import Main.Exception.BadInputException;

import java.util.regex.Pattern;


/**
 * 입력받은 값이 올바른 값인지 체크하는 함수들을 모은 클래스
 */
public class CalcParser {
    private static final String NUMBER_REG = "-?[0-9]*\\.?[0-9]*"; // 숫자 정규 표현식

    /**
     * 입력받은 문자가 숫자인지 체크.
     *
     * @param strNum 분석할 문자열
     * @return double 타입으로 변환하여 반환
     * @throws BadInputException 잘못된 숫자 입력
     * @author 김현정
     */
    public static double ParserNumber(String strNum) throws BadInputException {
        if (Pattern.matches(NUMBER_REG, strNum)) {
            return Double.parseDouble(strNum);
        } else {
            throw new BadInputException("숫자");
        }
    }
}
