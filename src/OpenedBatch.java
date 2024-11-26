// OpenedBatch: Abstract
// -> Batches: Abstract
import java.util.*;
public abstract class OpenedBatch extends Batches {

    public OpenedBatch()
    { super(); }
    public OpenedBatch(Collection<Object> batch)
    { super(batch); }

    // Add: takes Object; returns boolean
    public boolean add(Object o) {
        super.getBatchAsCollection().add(o);
        return true;
    }

    // Add: takes Collection; returns boolean
    public boolean add(Collection<Object> c) {
        for (Object object : c)
            this.add(object);
        return true;
    }

    // Add: takes Array; return boolean
    public boolean add(Object[] a) {
        for (Object object : a)
            this.add(object);
        return true;
    }

    // Removes an element
    // Remove: takes Object; returns int
    public int remove(Object o) {
        int i = this.indexOf(o);
        this.remove(i);
        return i;
    }
    // Remove at indices as Collection
    public Object[] remove(Collection<Integer> indices) {
        Object[] a = new Object[indices.size()];
        int index = 0;
        for (int i : indices) {
            Object o = this.remove(i);
            a[index] = o;
            index++;
        }
        return a;
    }
    // Remove as Collection
    public int[] removeCollectionObject(Collection<Object> c) {
        int[] indices = new int[c.size()];
        int index = 0;
        for (Object object : c) {
            int i = this.remove(object);
            indices[index] = i;
            index++;
        }
        return indices;
    }

    // Remove as Array
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

    // RETAIN


    public abstract int retain(Object o);

    public Object set(int index, Object element) {
        // TODO Auto-generated method stub
        return null;
    }

    public abstract void clear();

    public ClosedBatch close() {
        return new ClosedBatch(super.getBatchAsCollection());
    }
    public LockedBatch lock() {
        return new LockedBatch(super.getBatchAsCollection());
    }
}
