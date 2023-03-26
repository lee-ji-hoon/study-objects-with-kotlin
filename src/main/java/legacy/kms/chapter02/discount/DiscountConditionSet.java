package legacy.kms.chapter02.discount;

import legacy.kms.chapter02.Screening;

import java.util.Arrays;
import java.util.List;

// 등록된 모든 조건을 만족해야한다
public class DiscountConditionSet implements DiscountCondition {

    private List<DiscountCondition> conditions;

    DiscountConditionSet(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        boolean isSatisfied = true;
        for(DiscountCondition condition : conditions){
            if(!condition.isSatisfiedBy(screening)){
                isSatisfied = false;
                break;
            }
        }
        return isSatisfied;
    }
}
