package Main.Enum;

import Main.Exception.BadInputException;

/**
 * 계산기 메뉴
 */
public enum Menu {
    CALCULATOR("계산", 1),
    HISTORY("연산 기록 보기", 2),
    HIGH_RESULT_HISTORY("입력받은 값보다 큰 결과값 출력", 3),
    REMOVE_FIRST_HISTORY("첫번째 연산 기록 삭제", 4),
    END("종료", 5); // 이게 맞나...?? 점점 이상해지는 느낌이

    private String description;

    Menu(String description, int index) {
        this.description = description;
        this.index = index;
    }

    /**
     * 메뉴 이름을 반환한다.
     *
     * @return 메뉴 이름 반환
     * @author 김현정
     */
    public String getDescription() {
        return description;
    }

    private int index;

    /**
     * 메뉴 번호를 반환한다.
     *
     * @return 메뉴 번호 반환
     * @author 김현정
     */
    public int getIndex() {
        return index;
    }

    /**
     * 입력받은 숫자에 해당하는 메뉴 반환.
     *
     * @param index 입력받은 숫자
     * @return 메뉴 반환
     * @throws BadInputException 범위를 벗어난 메뉴 입력
     * @author 김현정
     */
    public static Menu getMenu(int index) throws BadInputException {
        for (Menu menu : Menu.values()) {
            if (menu.getIndex() == index)
            {
                return menu;
            }
        }

        throw new BadInputException("범위를 벗어난 메뉴");
    }
}
