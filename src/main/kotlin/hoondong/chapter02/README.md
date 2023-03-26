## 객체지향 프로그래밍에서 집중해야 할 것

1. 어떤 클래스가 필요한지 고민하기 전에 어떤 객체가 필요한지 고민하기
    1. 객체가 어떤 상태와 행동을 가지는지 결정해야함
2. 객체를 독립적인 존재가 아닌 기능을 구현하기 위해 협력하는 일원으로 생각하기
    1. 협력적인 존재로 생각하면 설계를 유연하고 확장 가능하게 만듦
    2. 공통된 특성과 상태를 가진 객체를 기반으로 클래스를 구현

## 객체의 자율성

클래스의 내부와 외부를 구분하여 객체의 자율성 보장 → 구현의 자유를 제공

객체는?

1. **상태와 행동**을 함께 가지는 복합적인 존재
2. 스스로 판단하고 행동하는 **자율적인** 존재

## 도메인

문제를 해결하기 위해 사용자가 프로그램을 사용하는 분야

객체지향 언어에서는 도메인 개념을 위해 **클래스**를 사용

## 캡슐화

데이터와 기능을 객체 내부로 함께 묶는 것

- 객체지향 언어에서는 **접근 수정자**를 제공하여 캡슐화를 위한 매커니즘을 제공

⇒ 위의 개념들을 통해 객체를 두 부분으로 나눌 수 있음

1. 퍼블릭 인터페이스
    - 외부에서 접근 가능한 부분
2. 구현
    - 오직 내부에서만 접근 가능한 부분

인터페이스와 구현의 분리 원칙은 객체지향을 위한 핵심 원칙

## 협력

시스템의 어떤 기능을 구현하기 위해 객체들 사이에 이뤄지는 상호작용

객체는 다른 객체의 인터페이스에 공개된 행동을 수행하도록 **요청**

→ 메세지 전송

요청받은 객체는 자율적인 방법에 따라 요청을 처리한 후 **응답**

→ 메세지 수신

**메서드** : 객체가 수신된 메세지를 처리하기 위한 자신만의 방법

## 추상화

객체지향에서 중요하게 여겨지는 두가지 개념 : 상속, 다형성

**Template Method Pattern**

- 부모 클래스에 기본적인 흐름을 구현하고, 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴
- 이를 위해 부모 클래스(추상 클래스)는 추상 메서드로 선언

## 의존성

**코드의 의존성**과 **실행 시점의 의존성**은 서로 다를 수 있다!

그렇지만 둘의 차이가 커질수록 코드를 이해하기 어렵다.

그러나 둘의 차이가 커질수록 코드는 더 유연해지고 확장 가능해진다.

즉, 이해도 ↔ 유연성 은 트레이드오프 관계이다.

## 상속

객체지향에서 코드를 재사용하기 위해 가장 널리 사용되는 방법

기존 클래스가 가지고 있는 모든 속성과 행동을 포함시킬 수 있다.

부모 클래스와 다른 부분만 추가해서 동작하게 할 수 있다.

⇒ **차이에 의한 프로그래밍**

## 다형성

동일한 메세지를 전송해도 클래스에 따라 실행되는 메서드가 달라지는 것

코드를 작성할 때에는 부모 클래스(또는 추상 클래스)에 의존하지만
실행 시점에서는 생성된 인스턴스를 통해 메서드를 실행한다.

- 메시지와 메서드를 컴파일 시점에 결정하는 것

  → **초기 바인딩, 정적 바인딩**

- 메시지와 메서드를 실행 시점에 바인딩하는 것

  → **지연 바인딩, 동적 바인딩**


객체지향에서는 **지연 바인딩** 매커니즘을 사용하고 있음

### 인터페이스

구현까지는 필요없고 인터페이스만 공유하고 싶을 때 사용하는 요소