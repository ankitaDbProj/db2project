package entities;

import java.sql.Date;

public class Election {
    private int id;
    private Date startDate, resultDate;
    private String topic;

    // Configuration...
    private static final String TABLE = "election";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_START_DATE = "start_date";
    private static final String COLUMN_TOPIC = "topic";
    private static final String COLUMN_RESLUT_DATE = "result_date";

    public Election(Date startDate, String topic, Date resultDate) {
        init(startDate, topic, resultDate);
    }

    public Election(int id, Date startDate, String topic, Date resultDate) {
        init(startDate, topic, resultDate);
        this.id = id;
    }

    public Election(){
    }

    private void init(Date startDate, String topic, Date resultDate){
        if(startDate == null || topic == null || resultDate == null){
            throw new IllegalArgumentException();
        }

        this.startDate = startDate;
        this.topic = topic;
        this.resultDate = resultDate;
    }

    public int getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public String getTopic() {
        return topic;
    }
}
