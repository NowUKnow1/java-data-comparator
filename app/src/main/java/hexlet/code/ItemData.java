package hexlet.code;

public class ItemData {
    private final Object fistFileValue;
    private final Object secondFileValue;
    private final DefinedStatus status;

    public ItemData(Object oldestValue, Object newestValue, DefinedStatus gotStatus) {
        this.fistFileValue = oldestValue;
        this.secondFileValue = newestValue;
        this.status = gotStatus;
    }

    public final Object getFistFileValue() {
        return fistFileValue;
    }

    public final Object getSecondFileValue() {
        return secondFileValue;
    }

    public final DefinedStatus getStatus() {
        return status;
    }
}
