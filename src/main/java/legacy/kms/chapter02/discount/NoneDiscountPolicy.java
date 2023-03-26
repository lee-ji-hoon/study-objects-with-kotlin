package legacy.kms.chapter02.discount;

import legacy.kms.chapter02.Money;
import legacy.kms.chapter02.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
