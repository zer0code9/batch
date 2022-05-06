package jvalt;

public interface Group {
	public int size();
	public Object get(int index);
	public int indexOf(Object o);
	public int lastIndexOf(Object o);
	public int[] indicesOf(Object o);
}
