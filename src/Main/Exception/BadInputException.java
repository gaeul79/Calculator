package Main.Exception;

/**
 * 입력 관련 예외처리 클래스
 */
public class BadInputException extends Exception {
    public BadInputException(String type) {
        super("잘못된 입력입니다! " + type + "을(를) 입력해주세요 >> ");
    }
}