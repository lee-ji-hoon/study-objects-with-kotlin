### 초기 코드의 문제 점 

- 관람객과 판매원이 소극장의 통제를 받는 **수동적**인 존재
	- 소극장이 관람객의 가방을 뒤지고 있다
	- 소극장이 티켓과 현금에 마음대로 접근한다

- 여러 세부적인 내용을 **한꺼번에 기억**하고 있어야 한다.
	- enter 메서드
		- Audience 에 Bag 의 존재를 알아야함
		- Bag 에 현금과 티켓의 존재를 알아야함
		- TicketSeller 가 TicketOffice에서 판매하고 돈과 티켓이 보관되있다는 사실을 알아야 한다 

- Audience 와 TicketSeller 의 변경이 있을 때 Theater 도 변경되야 한다
	- **변경에 취약하다** = 객체 사이의 **의존성**이 강하다

#### 객체지향 설계

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

#### 의아한 점

- 판매자가 있을 뿐 티켓을 검사하는 사람이 없다
	 - 즉, 극장에서 티켓 존재의 여부를 판단해서 입장을 시켜야하지 않을까
- 만약 티켓을 사지 못한 경우는 ?

