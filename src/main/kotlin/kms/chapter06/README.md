### 협력과 메시지

#### 클라이언트 - 서버 모델

- **클라이언트**
	- 메시지를 전송하는 객체
- **서버**
	- 메시지를 수신하는 객체
- 객체는 협력하는 동안 클라이언트, 서버 역할을 동시에 수행한다

### 용어 정리

#### 메시지

- 객체들이 협력하기 위해 사용할 수 있는 의사소통 수단
- **오퍼레이션명**과 **인자** 로 구성

#### 메시지 전송

- 메시지에 **메시지 수신자**가 추가된 것

```kotlin
condition.isSatisfiedBy(screening)
```
- `condition` : 메시지 수신자
- `isSatisfiedBy` : 오퍼레이션명
- `screening` : 인자

#### 메서드

- 실제로 실행되는 구현된 함수 또는 프로시저
- 동일한 이름의 변수에게 메시지를 전송해도 객체의 타입에 따라 실행되는 메서드가 달라질 수 있다
	- 같은 Interface 를 상속받은 다른 클래스의 객체

#### 퍼블릭 인터페이스

- 객체가 의사소통을 위해 외부에 공개하는 메시지의 집합

#### 오퍼레이션

- 퍼블릭 인터페이스에 포함된 메시지

#### 시그니처

- 오퍼레이션의 이름과 파라미터의 목록을 합쳐 **시그니처**라고 부른다
- 타입 반환까지 포함하는 언어도 존재

### 설계 원칙 및 기법

#### 디미터 법칙

- 객체의 내부 구조에 결합되지 않도록 협력 경로를 제한하라
	- Android 에서 데이터를 단방향으로 두는 것과 같은 맥락으로 보인다
- "오직 하나의 도트만 사용해라"
- **예외 케이스**
	- Builder 같은 경우 다른객체를 가져오는게 아닌 자신을 가져오기 때문에 허용
	- 내부 구현에 대한 정보를 노출하지 않으며 허용
- 메세지 전송의 대상
	- 전역 변수
	- 해당 클래스가 반환하거나 인자로 사용하는 객체
	- 해당 클래스의 객체

#### 묻지말고 시켜라

- 객체의 상태를 묻지말고 원하는 것을 시켜야 한다 
- 자연스럽게 **정보 전문가** 에게 책임을 할당하게 된다
	- **응집도가 높은** 클래스가 만들어진다

#### 의도를 드러내는 인터페이스

- 어떻게 하는지가 아닌 무엇을 하는지만 드러낸다
	- 이름이 다르기 때문에 내부 구현을 정확하게 이해하지 못하면 동일한 작업인지 알아채기 어렵다
	- 메서드이름에서 협력하는 객체의 종류를 알도록 강요하므로 캡슐화를 위반

```kotlin
// 어떻게 하는지를 드러내는 코드
class PeriodCondition {
	fun isSatisfiedByPeriod(screening: Screening): Boolean
}

class SequenceCondition {
	fun isSatisfiedBySequence(screening: Screening): Boolean
}

// 무엇을 하는지만 드러내는 코드
class PeriodCondition {
	fun isSatisfiedBy(screening: Screening): Boolean
}
```

#### 명령-쿼리 분리 원칙

- 프로시저 = **명령**
	- 부수효과를 발생시킬 수 있지만 값을 반환할 수 없다
- 함수 = **쿼리**
	- 값을 반환할 수 있지만 부수효과를 발생시킬 수 없다.
