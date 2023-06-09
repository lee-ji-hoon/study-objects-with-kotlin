### 클래스를 재사용 하는 기법

- 상속 : 클래스 안에 정의된 인스턴스 변수와 메서드를 새로운 클래스에 추가
- 합성 : 클래스의 인스턴스 안에 기존 클래스의 인스턴스 포함

### DRY 원칙

> **D**on\`t **R**epeat **Y**ourself

- 중복 코드는 변경을 방해한다
	- 중복 코드를 제거해야 하는 가장 큰 이유 
- 한 번, 단 한번 원칙 (Once and Only Once)
- 단일 지점 제어 원칙 (Single Point Control)

### 타입 코드 사용하기

- **낮은 응집도**와 **높은 결합도**를 가지게 된다
- 자식에서 부모의 함수를 호출하면 너무 강하게 결합된다
	- 개발자의 가정을 알아야함
- 상속 관계로 연결된 지식 클래스가 부모 클래스의 변경에 취약해지는 현상을 취약한 기반 **클래스 문제**라고 부른다

### 취약한 기반 클래스 문제

- 상속은 자식 클래스가 부모 클래스의 구현 세부사항에 의존하기 때문에 캡슐화를 약화시킨다
- 상속받은 부모 클래스의 메서드가 자식 클래스의 내부 구조에 대한 규칙을 깨트릴 수 있다
- 자식 클래스가 부모 클래스의 메서드를 오버라이딩할 경우 부모클래스가 자신의 메서드를 사용하는 방법에 자식 클래스가 결합될 수 있다
- 자식과 부모를 영원히 변경하지 않거나 자식과 부모를 동시에 변경하거나 둘 중 하나를 선택할 수 밖에 없다

### 추상화에 의존하자

- 두 메서드가 유사하면 차이점을 메서드로 추출하라
	- 변하는 것과 변하지 않는 것을 분리하라
	- 변하는 부분을 찾고 이를 캡슐화 하라
- 부모 클래스의 코드를 하위로 내리지 말고 자식 클래스의 코드를 상위로 올려라