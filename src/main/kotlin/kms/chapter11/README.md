### 상속 (is-a 관계)

>부모 클래스의 코드를 재사용 

- 부모 클래스의 정의 대부분을 물려받아 다른 부분만 추가하거나 재정의
- 기존 코드를 쉽게 확장할 수 있다
- 부모 클래스의 내부 구현에 대해 상세하게 알아야 한다
	- 결합도가 높아진다 
- 컴파일 의존성에 속박된다

#### 상속시 발생하는 문제

- 불필요한 인터페이스 상속
	- Base Class 를 만들고 기능을 추가하다보면 특정 자식에서는 필요 없을 수 있다
- 메서드 오버라이딩의 오작동
- 부모 클래스와 자식 클래스의 동시 수정 문제
	- 부모 클래스를 다양한 곳에서 사용하면 영향 범위를 측정하기 힘들어진다

### 합성 (has-a 관계)

>부분을 표현하는 객체를 포함해서 재사용

- 객체 사이의 관계가 동적인 관계다
- 합성을 이용하면 퍼블릭 인터페이스에 의존한다
	- 결합도가 낮다
- 런타임에 의존성을 구성할 수 있다
	- 설계의 복잡도가 상승하여 코드를 이해가기 어려워진다
