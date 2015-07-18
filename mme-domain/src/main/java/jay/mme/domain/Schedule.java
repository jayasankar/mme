package jay.mme.domain;

import java.util.Date;

/**
 * Created by gkaiswarya on 21/06/15.
 */
public class Schedule {

    private final Date startDate;

    private final Date endDate;

    private final boolean recurring;

    public Schedule(Date startDate, Date endDate, boolean recurring) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.recurring = recurring;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isRecurring() {
        return recurring;
    }
}
