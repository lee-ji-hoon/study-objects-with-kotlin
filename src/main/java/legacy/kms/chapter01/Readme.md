### 초기 코드의 문제 점 

- 관람객과 판매원이 소극장의 통제를 받는 **수동적**인 존재
	- 소극장이 관람객의 가방을 뒤지고 있다
	- 소극장이 티켓과 현금에 마음대로 접근한다

- 여러 세부적인 내용을 **한꺼번에 기억**하고 있어야 한다.
	- enter 메서드
		- Audience 에 Bag 의 존재를 알아야함
		- Bag 에 현금과 티켓의 존재를 알아야함
		- TicketSeller 가 TicketOffice에서 판매하고 돈과 티켓이 보관되있다는 사실을 알아야 한다 
		- Theater 에 **책임이 집중**돼 있다

- Audience 와 TicketSeller 의 변경이 있을 때 Theater 도 변경되야 한다
	- **변경에 취약하다** = 객체 사이의 **의존성**이 강하다

#### 객체지향 설계

- 모든 객체들을 자율적으로 행동하는 설계를 가진다
- 객체가 서로 의존하면서 협력하는 공동체를 구축하는 것
	- 의존성을 전부 없애는게 답은 아니다

### 해결방법

- Theater 가 Audience와 TicketSeller에 관해 너무 세세한 부분까지 알지 못하도록 정보를 차단 하기
- Audience 와 TicketSeller 를 **자율적인 존재**로 만들기

#### 내가한 리팩토링

- 각각 Bag과 TicketOffice 를 Audience 와 TicketSeller 만 접근할 수 있게 했다
	- 하지만 아직도 Theater 에서 너무 많은 정보를 알고 있다
	- **캡슐화**

### 1차 리팩토링

- TicketSeller 에서 sellTo 함수를 통해 Audience 에게 티켓을 판매
	- TickerOffice 를 캡슐화 한다
- Audience 는 buy 함수를 통해 Ticket을 구매
	- Bag을 캡슐화 한다

### 개선된 사항

- TicketSeller 와 Audience 의 내부를 구현을 변경해도 Theater 에 영향이 없다
	- TicketSeller 가 돈을 TickerOffice 에 보관하지 않아도 된다
	- Audience 는 가방을 무조건 가지고 다닐 필요가 없다

#### 각각 객체의 책임

- Theater - 관람객을 입장
- Audience - 티켓을 구매
- TicketSeller - 티켓을 판매

### 추가적인 개선

- Bag 과 TicketOffice 를 캡슐화 한다?

#### 의아한점

- Bag 에 자율성을 준다
	- 은행이나 카드 지갑이 추가 된다 했을 때 은행이 초대장을 보관할 수 있는가 ? 
	- 역할이 애매하다는 생각이 든다

- TicketOffice 에 Audience 에 대한 의존성이 생긴다 
	- 오히려 더 복잡해지는 느낌

- 금액이나 초대장을 분리해서 사람이 판단해야하지 않을까?

### 좋은 설계란 ?

- 변경하기 쉬워야 한다
	- 요구사항은 항상 변경된다

- 기능을 온전히 수행해야 한다