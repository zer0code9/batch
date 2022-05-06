package jvalt;
import java.util.*;

public class Batch extends Batches {

	public Batch()
	{ super(); }
	public Batch(Collection<Object> batch)
	{ super(batch); }
	
	// ADD
	// Add Object
	public boolean add(Object o) {
		super.getBatchAsCollection().add(o);
		return true;
	}
	public void add(int i, Object o) {
		Batch newBatch = new Batch();
		for (int z = 0; z < i - 1; z++)
			newBatch.add(this.get(z));
		newBatch.add(o);
		for (int z = i; z < this.size(); z++)
			newBatch.add(this.get(z));
		super.setBatch(newBatch);
	}
	// Add Collection
	public boolean add(Collection<Object> c) {
		for (Object object : c)
			this.add(object);
		return true;
	}
	public void add(int i, Collection<Object> c) {
		Batch newBatch = new Batch();
		for (int z = 0; z < i - 1; z++)
			newBatch.add(this.get(z));
		for (Object object : c)
			newBatch.add(object);
		for (int z = i; z < this.size(); z++)
			newBatch.add(this.get(z));
		super.setBatch(newBatch);
	}
	// Add Array
	public boolean add(Object[] a) {
		for (Object object : a)
			this.add(object);
		return true;
	}
	public void add(int i, Object[] a) {
		Batch newBatch = new Batch();
		for (int z = 0; z < i - 1; z++)
			newBatch.add(this.get(z));
		for (Object object : a)
			newBatch.add(object);
		for (int z = i; z < this.size(); z++)
			newBatch.add(this.get(z));
		super.setBatch(newBatch);
	}
	
	// REMOVE
	public Object remove(int i) {
		Batch newBatch = new Batch();
		for (int z = 0; z < i; z++)
			newBatch.add(this.get(z));
		Object o = this.get(i);
		for (int z = i + 1; z < this.size(); z++)
			newBatch.add(this.get(z));
		super.setBatch(newBatch);
		System.out.print(o);
		return o;
	}

	public int remove(Object o) {
		int i = this.indexOf(o);
		this.remove(i);
		return i;
	}
	
	public int[] remove(Collection<Object> c) {
		int[] indices = new int[c.size()];
		int index = 0;
		for (Object object : c) {
			int i = this.remove(object);
			indices[index] = i;
			index++;
		}
		return indices;
	}
	
	public int[] remove(Object[] a) {
		int[] indices = new int[a.length];
		int index = 0;
		for (Object object : a) {
			int i = this.remove(object);
			indices[index] = i;
			index++;
		}
		return indices;
	}
	
	public Object[] remove(int[] indices) {
		Object[] a = new Object[indices.length];
		int index = 0;
		for (int i : indices) {
			Object o = this.remove(i);
			a[index] = o;
			index++;
		}
		return a;
	}

	// RESTAIN
	public Object retain(int i) {
		Batch newBatch = new Batch();
		Object o = this.get(i);
		newBatch.add(o);
		super.setBatch(newBatch);
		return o;
	}
	
	public int retain(Object o) {
		Batch newBatch = new Batch();
		int i = this.indexOf(o);
		newBatch.add(o);
		super.setBatch(newBatch);
		return i;
	}

	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void clear() {
		Batch newBatch = new Batch();
		super.setBatch(newBatch);
	}
	
	public LockedBatch lock() {
		LockedBatch lockedBatch = new LockedBatch(super.getBatchAsCollection());
		return lockedBatch;
	}
}
