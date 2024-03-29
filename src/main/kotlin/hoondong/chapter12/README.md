# 12장 다형성

상속은 타입 계층을 구조화하기 위해 사용해야함

단순히 코드 재사용을 위해서라면 상속은 올바른 방법이 아님

코드 재사용이 아니라 다형성을 위한 서브타입 계층을 구축하는 것이 올바른 목표

객체지향에서의 다형성

- 유니버셜 다형성
    - 매개변수 다형성
    - 포함 다형성
- 임시 다형성
    - 오버로딩 다형성
    - 강제 다형성

### 오버로딩 다형성

- 하나의 클래스 안에 동일한 이름의 메서드가 존재하는 경우
- 유사한 작업을 수행하는 메서드의 이름을 통일할 수 있음

### 강제 다형성

- 언어가 지원하는 자동 타입 변환이나 구현한 타입 변환을 이용해 동일한 연산자를 다양한 타입에 사용할 수 있는 방식

### 매개변수 다형성

- 클래스 인스턴스 변수, 매개변수 타입을 임의로 선언한 후 사용 시점에 구체적으로 지정하는 방식
- 제네릭 프로그래밍

### 포함 다형성

- 메시지가 동일하더라도 수신한 객체에 따라 행동이 달라지는 능력
- 서브타입 다형성
- 상속이 이를 구현하기 위한 가장 적절한 방법
    - 상황에 맞는 메서드를 선택할 수 있는 메커니즘

데이터 관점의 상속 : 부모 클래스의 모든 데이터를 자식 클래스의 인스턴스에 자동으로 포함시킬 수 있음

행동 관점의 상속 : 부모 클래스에서 정의한 메서드도 자식 클래스에 자동으로 포함시킬 수 있음

## 다형성의 동작 방식 이해하기

- 메서드 오버라이딩
    - 자식 클래스 안에 상속받은 메서드와 동일한 시그니처의 메서드를 재정의해서 부모 클래스의 구현을 새로운 구현으로 대체하는 것
    - 자식 클래스에는 새로운 메서드를 추가하는 것도 가능함
- 메서드 오버로딩
    - 메서드와 이름은 동일하지만 시그니처는 다른 메서드를 자식 클래스에 추가하는 것

### 업캐스팅

- 부모 클래스 타입으로 선언된 변수에 자식 클래스의 인스턴스를 할당하는 것

### 동적 바인딩

- 선언된 변수의 타입이 아니라 메시지를 수신하는 객체의 타입에 따라 실행되는 메서드가 결정되는 것
- 객체지향 시스템이 메시지를 처리할 메서드를 실행 시점에 결정하기 때문

### 동적 메서드 탐색

- self(this) - 메시지를 수신한 객체를 참조하는 임시 변수

- **자동적인 메시지 위임**을 통해 알아서 부모에게 위임
- 메서드 탐색을 위해 **동적인 문맥 사용**

1. 자동적인 메시지 위임
- 적절한 메서드를 찾기 위해 상속 계층을 따라 이동

  → 상속 계층을 정의하는 것은 메서드 탐색 경로를 정의하는 것

    - 자식 클래스가 메서드 오버라이딩을 하면 부모 클래스의 메서드를 감추게 됨
    - 메서드 오버로딩은 시그니처가 다르기 때문에 공존할 수 있음
        - C++ 같은 언어에서는 이름이 같은 메서드를 다른 상속 계층에서 호출하지 못하도록 막음 : 이름 숨기기

1. 동적인 문맥
- self 전송 때문에 실행을 예상하기 어렵게 만듦
- 상속 관계에서 메서드 호출을 통한 self 호출 시 다시 처음으로 돌아가서 호출되기 때문
- super 참조 : self 대신 부모 클래스를 참조 변수로 사용하는 것