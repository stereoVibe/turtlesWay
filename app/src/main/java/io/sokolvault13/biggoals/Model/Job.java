package io.sokolvault13.biggoals.Model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "jobs")
public class Job extends Intention implements Performable {

    @DatabaseField(generatedId = true, canBeNull = false, index = true)
    private int id;
    @DatabaseField (canBeNull = true)
    private String title;
    @DatabaseField
    private String description;
    @DatabaseField (canBeNull = false, dataType = DataType.DATE_STRING, columnName = "start_date")
    private Date startDate;
    @DatabaseField (dataType = DataType.DATE_STRING, columnName = "end_date")
    private Date endDate;
    @DatabaseField (canBeNull = false, columnName = "is_due")
    private int isOutOfDate;
    @DatabaseField (canBeNull = false, columnName = "is_complete")
    private int isComplete;
    @DatabaseField (canBeNull = false, columnName = "priority")
    private int mPriority;
    @DatabaseField (foreign = true, index = true, foreignAutoRefresh = true, canBeNull = false, columnName = BIGGOAL_FIELD)
    private BigGoal mBigGoal;
    @DatabaseField (canBeNull = false, columnName = BIGGOAL_ID_FIELD)
    private int mBigGoalId;

    public Job() {
        this.startDate = new Date();
        this.isOutOfDate = 0;
        this.isComplete = 0;
    }

    public int getPriority() {
        return mPriority;
    }
    public void setPriority(int priority) {
        mPriority = priority;
    }

    @Override
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }
    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }
    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public int getOutOfDate() {
        return isOutOfDate;
    }
    @Override
    public void setOutOfDate(int isOutOfDate) {
        this.isOutOfDate = isOutOfDate;
    }

    @Override
    public int getCompleteStatus() {
        return isComplete;
    }
    public void setCompleteStatus(int isComplete) {
        this.isComplete = isComplete;
    }

    @Override
    public void setBigGoal(BigGoal bigGoal) {
        this.mBigGoal = bigGoal;
    }
    @Override
    public BigGoal getBigGoal() {
        return this.mBigGoal;
    }
    @Override
    public int getBigGoalId() {
        return mBigGoalId;
    }
    @Override
    public void setBigGoalId (BigGoal bigGoal) { this.mBigGoalId = bigGoal.getId(); }

}