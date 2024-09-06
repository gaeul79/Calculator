import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public enum OperatorType {
    ADD("+") ,
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("-");

    private String name;

    OperatorType(String name) {
        this.name = name;
    }

    public String getName() { // 문자를 받아오는 함수
        return name;
    }
}