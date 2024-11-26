import java.util.*;
public class LockedBatch extends Batches {
    private Collection<Object> batch;

    public LockedBatch(Collection<Object> batch) {
        super(batch);
        this.batch = batch;
    }

    public Batches getBatch() { return new Batch(); }
    public Collection<Object> getBatchAsCollection() { return new ArrayList<Object>(); }
    public void setBatch(Batches b) {
        System.out.println("This Batch is locked");
    }
    public Object[] toArray() { return new Object[1]; }
    public Collection<Object> toCollection() { return new ArrayList<Object>(); }

}