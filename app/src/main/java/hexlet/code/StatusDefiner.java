package hexlet.code;

public class StatusDefiner {
    private final Object fistFileValue;
    private final Object secondFileValue;
    private final String status;

    public StatusDefiner(Object oldestValue, Object newestValue, String gotStatus) {
        this.fistFileValue = oldestValue;
        this.secondFileValue = newestValue;
        this.status = gotStatus;
    }

    public Object getFistFileValue() {
        return fistFileValue;
    }

    public Object getSecondFileValue() {
        return secondFileValue;
    }

    public String getStatus() {
        return status;
    }
}
