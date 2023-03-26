package legacy.kms.chapter02.discount;

import legacy.kms.chapter02.Money;
import legacy.kms.chapter02.Screening;

import java.util.Arrays;
import java.util.List;

// 등록된 할인 정책중 가장 최고의 할인 정보를 가져온다
// ("최고의 할인 정보를 가져온다" 라는 것을 이름으로 판단할 수 없음)
public class DiscountPolicySet implements DiscountPolicy{

    private List<DiscountPolicy> policies;

    DiscountPolicySet(DiscountPolicy ... policies){
        this.policies = Arrays.asList(policies);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        Money best = Money.ZERO;
        for(DiscountPolicy policy : policies){
            Money cur = policy.calculateDiscountAmount(screening);
            if(cur.isGreaterThanOrEqual(best)){
                best = cur;
            }
        }
        return best;
    }
}
