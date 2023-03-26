package legacy.kms.chapter02.discount;

import legacy.kms.chapter02.Screening;

public class SequenceCondition implements DiscountCondition{

    private int sequence;

    public SequenceCondition(int sequence){
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
