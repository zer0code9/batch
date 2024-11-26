import java.lang.*;
import java.util.*;

public abstract class Batches {

    private Collection<Object> batch;

    public Batches()
    { this.batch = new ArrayList<Object>(); }
    public Batches(Collection<Object> batch)
    { this.batch = batch; }

    public Batches getBatch() {
        return new Batch(this.batch);
    }

    public Collection<Object> getBatchAsCollection() {
        return this.batch;
    }

    public void setBatch(Batches b) {
        this.batch = b.toCollection();
    }

    public int size() {
        int count = 0;
        for (Object object : batch)
            count++;
        return count;
    }

    public Object get(int index) {
        int i = 0;
        for (Object object : batch) {
            if (index == i)
                return object;
            i++;
        }
        return "Object?";
    }

    public int indexOf(Object o) {
        int i = 0;
        for (Object object : batch) {
            if (object.equals(o))
                return i;
            i++;
        }
        return -1;
    }


    public int lastIndexOf(Object o) {
        for (int i = this.size() - 1; i >= 0; i--)
            if (this.get(i).equals(o))
                return i;
        return -1;
    }

    public boolean contains(Object o) {
        for (Object object : this.batch)
            if (object.equals(o))
                return true;
        return false;
    }

    public boolean containsAll(Collection<Object> c) {
        int count = 0;
        for (Object object : c)
            if (this.contains(object))
                count++;
        return count == c.size();
    }

    public Object[] toArray() {
        if (this.isEmpty()) {
            Object[] a = new Object[0];
            return a;
        }

        Object[] a = new Object[this.size()];
        for (int i = 0; i < this.size(); i++)
            a[i] = this.get(i);
        return a;
    }

    public Collection<Object> toCollection() {
        if (this.isEmpty()) {
            Collection<Object> c = new ArrayList<Object>();
            return c;
        }

        Collection<Object> c = new ArrayList<Object>();
        for (int i = 0; i < this.size(); i++)
            c.add(this.get(i));
        return c;
    }

    public String toString() {
        String string = "(";
        for (int i = 0; i < this.size() - 1; i++)
            string += this.get(i).toString() + ", ";
        return string + this.get(this.size() - 1).toString() +")";
    }

    public boolean isEmpty() {
        return (batch == null) || (this.size() < 1);
    }

    public Batches subBatch(int from, int to) {
        Batch newBatch = new Batch();
        for (int i = 0; i < this.size(); i++) {
            newBatch.add(this.get(i));
        }
        return newBatch;
    }

}