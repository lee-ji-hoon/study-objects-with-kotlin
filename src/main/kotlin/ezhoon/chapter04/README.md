## 설계 품질과 트레이드오프

### 가장 중요한 것은 책임이다.

- 역할, 책임, 협럭 중에서 가장 중요한 것은 책임이다.
- 책임이 적절해야 역할과 협력이 적절하게 조화를 이룬다.
- 그렇기에 책임이 객체지향 어플리케이션 전체의 품질을 결정하게 된다.

> 훌륭한 설계는 합리적인 비용안에서 변경을 수용할 수 있는 구조를 만드는 것이다.
> 적절한 비용 안에서 쉽게 변경할 수 있는 설계는 응집도가 높고, 서로 느슨하게 결합돼 있는 요소로 구성된다.

### 시스템을 객체로 분할하는 방법

객체지향 설계에서는 두 가지 방법을 이용해 시스템을 객체로 분할할 수 있다.
- 상태를 분할의 중심축으로 삼는 방법
  - 객체를 독립된 데이터 덩어리로 본다.
- 책임을 분할의 중심축으로 삼는 방법
  - 객체를 협력하는 공동체의 일원으로 본다.

## 설계 트레이드오프

### 캡슐화

> 보편적으로 캡슐화라고 하면 객체의 내부 구현을 외부로부터 감추는 것을 의미한다.

변경될 가능성이 높은 부분을 구현이라고 부르고, 상대적으로 안정적인 부분을 인터페이스라고 부른다.

- 이 부분에서 익숙한게 우리가 객체지향을 만들 때 인터페이스를 써야하는 이유랑 겹쳐서 생각하면 편하다.
- 우리가 가변적인 List를 사용해야 한다고 하면 보편적으로 MutableList와 ArrayList를 생각하게 된다.
- 둘의 공통점은 ArrayList를 사용한다.

```kotlin
public inline fun <T> mutableListOf(): MutableList<T> = ArrayList()
public interface MutableList<E> : List<E>, MutableCollection<E>

public inline fun <T> arrayListOf(): ArrayList<T> = ArrayList()
expect class ArrayList<E> : MutableList<E>, RandomAccess
```

- mutableListOf는 실제로 MutableList interface를 반환하고 arrayList는 ArrayList라는 구현체를 반환한다.
- 이 때 우리는 mutableListOf를 사용해야 한다.
- 이유는 뭘까? 잘 생각해보자.
  - 만약 내가 arrayListOf를 사용중인데 kotlin version이 올라가면서 기본 arrayList대신 더 좋은 가변 list가 나온다면?
  - arrayListOf를 사용중인 곳을 찾아서 전부 바꿔줘야 하고 그것은 개발자에게 실수를 야기할 수 있다.
  - 하지만 mutableListOf의 경우 MutableList라는 interface이고 나중에 실제 구현체가 다른 것으로 변경이 돼도 우린 신경을 안써도 된다.
  - 이처럼 인터페이스는 구현보다 상대적으로 안정적인 부분이라는 것을 알 수 있다.

> 추가적으로 ArrayList도 잘 보면 MutableList interface를 구현한 객체이다.    
> 그렇기에 mutableListOf에서 실제 구현체가 ArrayList가 될 수 있던 것이고 반환으로 MutableList interface가 가능했던 것이다.


### 응집도와 결합도

응집도는 모듈에 포함된 내부 요소들이 연관돼 있는 정도를 의미한다.     

결합도는 의존성의 정도를 나타내며 다른 모듈에 대해 얼마나 많은 지식을 갖고 있는지를 나타내는 척도이다.



