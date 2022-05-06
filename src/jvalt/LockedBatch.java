package jvalt;
import java.util.*;

public class LockedBatch extends Batch {
	private Collection<Object> batch;
	private boolean arshLock;

	public LockedBatch(Collection<Object> batch) {
		super(batch);
		this.batch = batch;
	}
	
	public Batches getBatch() {
		Batches batch = new Batch();
		return batch;
	}
	
	public Collection<Object> getBatchAsCollection() {
		Collection<Object> c = new ArrayList<Object>();
		return c;
	}
	
	public void setBatch(Batches b) {
		System.out.println("This Batch is locked");
	}

}
