### 추상화

문제 해결에 필요한 핵심만 남기는 작업

### 분해

문제의 크기를 줄이는 것

###  추상화

#### 프로시저 추상화를 중심

- 기능 분해 (= 알고리즘 분해)

#### 데이터 추상화를 중심

- 타입을 추상화 (= 추상 데이터 타입)
- 데이터를 중심으로 프로시저를 추상화 (= 객체지향)

### 프로시저 추상화와 기능 분해

> 알고리즘 분해, 기능 분해 라고 부른다

#### 하향식 접근법 (Top-Down Approach)

- 최상위 기능을 정의
- 좀 더 작은 단계의 하위 기능으로 분해
- 설계가 어느 정도 안정화된 후에는 논리적을오 설명하고 문서화하기 용이하다

##### 문제점

- 시스템은 **하나의 메인 함수**로 구성되지 않는다
- 기능 추가나 요구사항 변경으로 인해 메인 함수를 **빈번하게 수정**해야 한다
- 비즈니스 로직이 사용자 인터페이스와 **강하게 결합**된다
- 하향식 분해는 너무 이른 시기에 함수들의 실행 순서를 고정시키기 때문에 유연성과 재사용성이 저하된다
- 데이터 형식이 변경될 경우 파급효과를 예측할 수 없다.

### 모듈

#### 복잡성

- 모듈이 너무 복잡한 경우 이해하고 사용하기 어렵다

#### 변경가능성

- 변경 발생 시 하나의 모듈만 수정하면 되도록 변경 가능한 설계로 내부를 감추고 외부에는 쉽게 변경되지 않을 인터페이스를 제공한다

>[!note] 정보은닉
>- 시스템을 모듈 단위로 분해하기 위한 기본 원리
>- 자주 변경되는 부분을 상대적으로 덜 변경되는 인터페이스 뒤로 감춰야 한다

>[!note] 캡슐화
>- 데이터와 메서드를 하나로 통합하고 public method 로만 접근하도록 허용하는방법
>- 정보 은닉과 동일한 개념이 아니다

#### 장점

- 모듈 내부의 변수가 변경되더라도 모듈 내부에만 영향을 미친다
- 비지니스 로직과 사용자 인터페이스에 대한 관심사를 분리한다
- 전역 변수와 전역 함수를 제거함으로써 네이스페이스 오염을 방지한다

#### 단점

- 인스턴스의 개념을 제공하지 않는다
	- 이를 만족하기위한 개념이 **추상 데이터 타입**

### 데이터 추상화와 추상 데이터 타입

>[!note] 타입
>- 변수에 저장할 수 있는 내용물의 종류와 변수에 적용될 수 있는 연산의 가짓수
>- 저장된 값에 대해 수행될 수 있는 연산의 집합을 결정

#### 추상데이터 타입의 필요조건

- 타입 정의를 선언할 수 있어야 한다
- 타입의 인스턴스를 다루기 위해 사용할 수 있는 오퍼레이션의 집합을 정의할 수 있어야 한다
- 제공된 오퍼레이션을 통해서만 조작할 수 있도록 데이터를 외부로부터 보호할 수 있어야 한다
- 타입에 대해 여러 개의 인스턴스를 생성할 수 있어야 한다

### 클래스

> 상속과 다형성을 지원하는 객체지향 프로그래밍 (Object-Oriented Programming)

- 절차를 추상화

#### 추상 데이터 기반

- 객체기반 프로그래밍 (Object-Based-Programming)
- 상속, 다형성을 지원하지 못함
- **타입**을 추상화