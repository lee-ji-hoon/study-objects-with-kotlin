# 1장 객체, 설계

## 소프트웨어 설계 이론

실무가 어느정도 발전하고 난 다음에야 실용성을 입증하는 이론이 만들어진다.

소프트웨어 설계에 대한 이론은 비교적 최근에 나타났다.

유지보수에 대한 이론은 더더욱 발표가 되지 않고 있다.

결국 이론보다 실무에 초점을 맞추어야 효과적이다.

## 이해하기 어려운 코드

우리의 상식에서 벗어난 동작을 하는 코드

객체 사이의 의존성이 높아 변경에 취약한 코드

## 객체지향의 이점

캡슐화를 이용해 의존성을 적절히 관리함으로써 객체 사이의 결합도를 낮추는 것

데이터와 프로세스가 동일한 모듈에 위치하기에 이해하기 쉬움

객체 내부의 변경이 외부에 파급되지 않도록 하여 변경에 용이함

## 의인화

현실 세계에서는 수동적인 존재이더라도 객체지향의 관점에서는 능동적인 존재로 설계하는 것

객체지향에서는 각 객체가 책임져야 할 데이터와 프로세스는 각자 가져야함

## 좋은 설계란?

오늘 요구하는 기능을 온전히 수행하면서 내일의 변경을 매끄럽게 수용할 수 있는 것

- 요구사항이 항상 변경되기 때문
- 코드를 변경할 때 버그가 추가될 가능성이 높기 때문

⇒ 변경에 유연하게 대응할 수 있는 코드

## 의존성을 낮추기만 하면 좋은 코드일까?

의존성을 낮추게 된다면, 각 객체가 갖는 자율성이 떨어진다.

결국 결합도와 자율성은 트레이드오프이기 때문에 적절히 설계하는 것이 중요하다.