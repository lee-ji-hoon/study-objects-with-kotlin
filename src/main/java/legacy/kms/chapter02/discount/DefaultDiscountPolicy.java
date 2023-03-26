package legacy.kms.chapter02.discount;

import legacy.kms.chapter02.Money;
import legacy.kms.chapter02.Screening;

import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {

    private List<DiscountCondition> conditions;

    public DefaultDiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions){
            if(each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}