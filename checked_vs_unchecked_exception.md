
# Checked Exception vs Unchecked Exception

자바(Java)에서는 예외(Exception)를 크게 두 가지로 나눌 수 있습니다: **Checked Exception**과 **Unchecked Exception**. 이 두 예외는 예외 처리 방식과 목적에 차이가 있으며, 프로그램 안정성과 관련된 중요한 개념입니다.

---

![image description](./assets/asset1.png)

## 1. 정의 (Definition)

### ✅ Checked Exception
- 컴파일 시점에 확인되는 예외
- 반드시 `try-catch`로 처리하거나 `throws`로 선언해야 함
- 예외 처리를 강제하여 **안정적인 프로그램 흐름**을 보장

### ⚠️ Unchecked Exception
- 실행(Runtime) 중 발생하는 예외
- `RuntimeException`과 그 하위 클래스들
- 컴파일러가 예외 처리를 강제하지 않음

---

## 2. 예시 (Examples)

| Exception Type     | 예시 클래스                                      | 설명                              |
|--------------------|--------------------------------------------------|-----------------------------------|
| Checked Exception  | `IOException`, `SQLException`, `FileNotFoundException` | 외부 환경이나 입출력 작업에서 자주 발생 |
| Unchecked Exception| `NullPointerException`, `ArrayIndexOutOfBoundsException`, `IllegalArgumentException` | 개발자의 실수로 인한 버그 중심     |

---

## 3. 문법적 차이 (Syntax Difference)

```java
// Checked Exception
public void readFile(String filePath) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
}
```

```java
// Unchecked Exception
public void divide(int a, int b) {
    int result = a / b; // b가 0일 경우 ArithmeticException 발생
}
```

---

## 4. 사용 목적 (Usage Purpose)

| 항목                    | Checked Exception                             | Unchecked Exception                         |
|-------------------------|-----------------------------------------------|---------------------------------------------|
| 예외 처리 강제 여부     | ✅ 컴파일러가 강제                             | ❌ 강제하지 않음                             |
| 발생 위치               | 주로 외부 자원 처리 (I/O, DB 등)               | 코드 논리 오류 (Null, 배열 범위 초과 등)     |
| 예외 처리 목적          | 안정적인 프로그램 실행 보장                    | 개발자 실수 조기 발견                        |
| 예외 처리 방식 권장 여부 | 실제 예외 처리 권장                            | 코드 수정을 통한 예방 권장                   |

---

## 5. 어떤 걸 언제 써야 할까?

- **Checked Exception**은 회복 가능한 예외 상황 (예: 파일이 없을 때)을 처리할 때 사용
- **Unchecked Exception**은 프로그래밍 오류 (예: 널 참조, 잘못된 인덱스 접근)를 처리할 때 사용

> ✅ "복구 가능한 예외인가?" → Checked  
> ⚠️ "코드 수정으로 해결해야 하는 문제인가?" → Unchecked

---

## 6. 정리 (Summary)

| 구분              | Checked Exception         | Unchecked Exception          |
|-------------------|----------------------------|-------------------------------|
| 상속 클래스       | `Exception`                | `RuntimeException`            |
| 컴파일러 체크     | 예                          | 아니오                        |
| 예외 처리 강제    | 예                          | 아니오                        |
| 대표 예시         | `IOException`, `SQLException` | `NullPointerException`, `ArithmeticException` |
| 주요 용도         | 외부 자원 접근 시 예외 처리 | 논리적 오류 감지 및 디버깅     |

---

- Checked Exception을 지나치게 남발하지 않도록 주의
- Unchecked Exception은 명확한 사유와 함께 문서화할 것
- 예외 메시지는 **사용자**가 이해할 수 있도록 작성하는 것이 중요
