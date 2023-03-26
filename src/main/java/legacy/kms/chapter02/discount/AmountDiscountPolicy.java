package legacy.kms.chapter02.discount;

import legacy.kms.chapter02.Money;
import legacy.kms.chapter02.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition ... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
