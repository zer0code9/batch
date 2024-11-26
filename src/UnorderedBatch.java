// UnorderedBatch: Class
// -> OpenedBatch: Abstract
import java.util.*;
public class UnorderedBatch extends OpenedBatch {
    public UnorderedBatch()
    { super(); }
    public UnorderedBatch(Collection<Object> batch)
    { super(batch); }

    public int retain(Object o) {
        OpenedBatch newBatch = new UnorderedBatch();
        int i = this.indexOf(o);
        newBatch.add(o);
        super.setBatch(newBatch);
        return i;
    }

    public void clear() {
        OpenedBatch newBatch = new UnorderedBatch();
        super.setBatch(newBatch);
    }
}
