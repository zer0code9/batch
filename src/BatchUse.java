public class BatchUse {
    public static void main(String[] args) {
        OrderedBatch batch = new OrderedBatch();
        batch.add(0, 1);
        batch.add("hi");
        batch.close();
        System.out.println(batch.toString());
    }
}
