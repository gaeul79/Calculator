package Main.Enum;

public enum Menu {
    CALCULATOR("계산", 1),
    HISTORY("연산 기록 보기", 2),
    HIGH_HISTORY("입력받은 값보다 큰 결과값 출력", 3),
    REMOVE_FIRST_HISTORY("첫번째 연산 기록 삭제", 4),
    END("종료", 5); // 이게 맞나...?? 점점 이상해지는 느낌이

    private String description;

    Menu(String description, int index) {
        this.description = description;
        this.index = index;
    }

    public String getDescription() { // 문자를 받아오는 함수
        return description;
    }

    private int index;

    public int getIndex() { // 문자를 받아오는 함수
        return index;
    }
}
