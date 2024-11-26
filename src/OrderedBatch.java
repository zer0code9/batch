// OrderedBatch: Class
// -> OpenedBatch: Abstract
import java.util.*;
public class OrderedBatch extends OpenedBatch {

    public OrderedBatch()
    { super(); }
    public OrderedBatch(Collection<Object> batch)
    { super(batch); }

    // Add Object at index
    public void add(int i, Object o) {
        OpenedBatch newBatch = new OrderedBatch();
        for (int z = 0; z < i - 1; z++)
            newBatch.add(this.get(z));
        newBatch.add(o);
        for (int z = i; z < this.size(); z++)
            newBatch.add(this.get(z));
        super.setBatch(newBatch);
    }

    // Add Collection at index
    public void add(int i, Collection<Object> c) {
        OpenedBatch newBatch = new OrderedBatch();
        for (int z = 0; z < i - 1; z++)
            newBatch.add(this.get(z));
        for (Object object : c)
            newBatch.add(object);
        for (int z = i; z < this.size(); z++)
            newBatch.add(this.get(z));
        super.setBatch(newBatch);
    }

    // Add Array at index
    public void add(int i, Object[] a) {
        OpenedBatch newBatch = new OrderedBatch();
        for (int z = 0; z < i - 1; z++)
            newBatch.add(this.get(z));
        for (Object object : a)
            newBatch.add(object);
        for (int z = i; z < this.size(); z++)
            newBatch.add(this.get(z));
        super.setBatch(newBatch);
    }

    // Remove at index
    public Object remove(int i) {
        OpenedBatch newBatch = new OrderedBatch();
        for (int z = 0; z < i; z++)
            newBatch.add(this.get(z));
        Object o = this.get(i);
        for (int z = i + 1; z < this.size(); z++)
            newBatch.add(this.get(z));
        super.setBatch(newBatch);
        System.out.print(o);
        return o;
    }

    // Remove at indices as Array
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

    public Object retain(int i) {
        OpenedBatch newBatch = new OrderedBatch();
        Object o = this.get(i);
        newBatch.add(o);
        super.setBatch(newBatch);
        return o;
    }

    public int retain(Object o) {
        OpenedBatch newBatch = new OrderedBatch();
        int i = this.indexOf(o);
        newBatch.add(o);
        super.setBatch(newBatch);
        return i;
    }

    public void clear() {
        OpenedBatch newBatch = new OrderedBatch();
        super.setBatch(newBatch);
    }
}
