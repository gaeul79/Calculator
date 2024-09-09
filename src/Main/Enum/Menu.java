package Main.Enum;

/** 계산기 메뉴 */
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

    /**
     * 메뉴 이름을 반환한다.
     * @author 김현정
     * @return 메뉴 이름 반환
     */
    public String getDescription() {
        return description;
    }

    private int index;

    /**
     * 메뉴 번호를 반환한다.
     * @author 김현정
     * @return 메뉴 번호 반환
     */
    public int getIndex() {
        return index;
    }
}
