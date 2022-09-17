package hexlet.code;

public class StatusDefiner {
    private final Object fistFileValue;
    private final Object secondFileValue;
    private final DefinedStatus status;

    public StatusDefiner(Object oldestValue, Object newestValue, DefinedStatus gotStatus) {
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

    public DefinedStatus getStatus() {
        return status;
    }
}
