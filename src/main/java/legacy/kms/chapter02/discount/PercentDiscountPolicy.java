package legacy.kms.chapter02.discount;

import legacy.kms.chapter02.Money;
import legacy.kms.chapter02.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition ... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMoveFee().times(percent);
    }
}
