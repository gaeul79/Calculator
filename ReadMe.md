# 계산기 설명 및 구조
- 두 숫자와 연산자를 입력받아 사칙연산을 수행하는 계산기
- 계산기를 실행한동안 수행한 연산 결과를 `조회/삭제`할 수 있다.
- `exit`를 입력받으면 계산기를 종료한다.

| 폴더/파일명                                   | 설명                                   |                        
|------------------------------------------|--------------------------------------|
| `Main`                                   | 계산기와 관련된 폴더/파일들을 모아놓은 폴더             |                
| ├── `Calculator`                         | 계산과 관련된 파일들을 모아놓은 폴더                 |
| │   ├── `ArithmeticCalculator.java`      | 계산을 수행하는 class                       |
| │   ├── `CalcParser.java`                | 입력된 정보가 올바른지 체크하는 함수들을 모은 class      |
| │   ├── `CalculatorHistory.java`         | 계산 기록을 관리하는 class                    |
| │   └── `CalculatorHistoryItem.java`     | 계산 결과 리스트에 들어가는 class                |
| ├── `Enum`                               | Enum들을 모아놓은 폴더                       |
| │   ├── `Menu.java`                      | 계산기 메뉴 Enum                          |
| │   └── `OperatorType.java`              | 사칙연산자 Enum                           |
| ├── `Exception`                          | 예외처리와 관련된 파일들을 모아놓은 폴더               |
| │   └── `InvalidTypeInputException.java` | 잘못된 입력시 발생하는 BadInputException class |
| ├── `Operator`                           | 연산과 관련된 파일들을 모아놓은 폴더                 |
| │   └── `Operator.java`                  | 두 숫자에 대한 연산을 정의한 interface           |
| │   └── `AddOperator.java`               | 덧셈을 수행하는 class                       |
| │   └── `SubOperator.java`               | 뺄셈을 수행하는 class                       |
| │   └── `MulOperator.java` | 곱셈을 수행하는 class                       |
| │   └── `DivOperator.java` | 나눗셈을 수행하는 class                      |
| │   └── `OperatorFactory.java` | 지정된 연산자 타입에 해당하는 연산자 객체를 생성하고 반환하는 class |
| └── `App.java`                           | 계산기 프로젝트 메인 class                    |

### 그외
- 주석은 `JavaDoc`구조를 따름
- 변수나 함수명은 `네이밍 컨벤션(Naming Conventions)`을 최대한 따르도록 함
    - 변수랑 함수는 소문자로시작 카멜 표기(단어 첫글자를 대문자 나머지는 소문자로 표기)
    - 함수는 동사로 시작한다.
    - 변수는 몀사로 시작하고 한글자 금지 ex) int i, j, k...
    - `Enum`이나 상수처럼 한번 정해진뒤 바뀌지 않는 값은 스네이크(전부 대문자 단어는 언더바(_)로 구분) 표기법
    - 읽기만해도 알 수 있도록 최대한 자세히
- `git` 커밋내용은 가능한 자세히 적었고, 마크다운 언어를 사용함
- `stream.filter()`를 활용하여 리스트에서 원하는 데이터만 추출