package legacy.kms.chapter02.discount;

import legacy.kms.chapter02.Screening;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);
}
