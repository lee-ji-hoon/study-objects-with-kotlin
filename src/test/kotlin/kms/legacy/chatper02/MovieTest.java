package kms.legacy.chatper02;

import legacy.kms.chapter02.Money;
import legacy.kms.chapter02.Movie;
import legacy.kms.chapter02.discount.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

@DisplayName("영화관 클래스 테스트")
public class MovieTest {

    @BeforeEach
    void initMovie(){
        Movie avatar = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
                ));

        Movie titanic = new Movie("타이타닉", Duration.ofMinutes(180), Money.wons(11000),
                new PercentDiscountPolicy(0.1,
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
                ));

        Movie starWars = new Movie("스타워즈", Duration.ofMinutes(210), Money.wons(10000), new NoneDiscountPolicy());
    }
}
