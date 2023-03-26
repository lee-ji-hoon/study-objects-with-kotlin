package legacy.kms.chapter02.discount;

import legacy.kms.chapter02.Money;
import legacy.kms.chapter02.Screening;

public interface DiscountPolicy {

    public Money calculateDiscountAmount(Screening screening);
}
