# 8장 의존성 관리하기

### 의존성의 의미

- 실행 시점 : 의존하는 객체가 실행 시에 존재해야 함
- 구현 시점 : 의존 대상 객체가 변경될 경우 의존하는 객체도 변경해야 함

어떤 객체가 예정된 작업을 정상적으로 수행하기 위해 다른 객체를 필요로 하는 경우

→ **의존성이 존재**

### 의존성 전이


: 연쇄적으로 의존하는 객체의 경우, 잠재적으로 의존성이 생김

**직접 의존성** : 직접 다른 요소에 접근하는 경우

**간접 의존성** : 의존성 전이에 의해 영향이 전파되는 경우

**런타임 의존성** : 애플리케이션이 실행되는 시점의 의존성

**컴파일타임 의존성** : 코드 자체에서의 의존성

두 의존성의 차이가 생길 수 있음 → 상속을 사용할 때

⇒ 두 의존성의 거리가 멀수록 설계가 유연해지고 재사용 가능해짐

### 컨텍스트 독립성


: 클래스는 자신과 협력할 객체의 구체적인 클래스에 대해 알아서는 안 됨

**의존성 해결** : 컴파일타임 의존성을 컨텍스트에 맞는 적절한 런타임 의존성으로 교체하는 것

### 유연성과 의존성

확실한 정답은 없다.

설계 단계에서 각 객체에 부여한 책임과 역할을 토대로 최대한 의존하지 않게 코드를 작성할 것.

추상화를 적극적으로 이용하여 의존성을 줄이고 재사용성을 높일 것.

각 객체들이 알고 있는 정보를 십분 활용하여 코드를 작성할 것.