## 캡슐화

객체지향은 한 곳에서 일어난 변경이 전체에 영향을 끼치지 않도록 조절하는 장치를 제공함

구현 : 변경될 가능성이 높은 부분

인터페이스 : 상대적으로 안정적인 부분

캡슐화 : 외부에서 알 필요가 없는 부분을 감춤으로써 대상을 단순화하는 방법

캡슐화가 필요한 이유

- 불안정한 부분과 안정한 부분을 분리함으로써 변경의 영향을 통제할 수 있음

## 응집도와 결합도

응집도 : 모듈에 포함된 내부 요소들이 연관돼 있는 정도

결합도 : 다른 모듈에 대해 얼마나 많은 지식을 갖고 있는지를 나타내는 척도

좋은 설계 → 높은 응집도 & 낮은 결합도

## 파급 효과

내부 구현의 변경이 외부로 퍼져나가는 효과

→ 캡슐화가 부족하다는 명백한 증거

## 데이터 중심 설계의 문제점

1. 객체의 행동보다 상태에 초점을 맞춘다.
- 기존의 절차적 프로그래밍 패러다임을 따라가다 보니 캡슐화가 무너짐
- 인터페이스에 데이터가 모두 드러나고, 이는 캡슐화를 실패하게 하는 원인

⇒ 응집도와 결합도에 나쁜 영향을 미침

1. 객체를 고립시킨 채 연산을 정의하도록 만든다.
- 올바른 객체지향은 다른 객체와 협력하는 방법을 고민해야 한다. 그러나 데이터 중심 설계는 객체의 내부에 더욱 집중한다.
- 인터페이스에 구현이 노출되어 있으면 협력하는 객체 모두가 영향을 받는다.