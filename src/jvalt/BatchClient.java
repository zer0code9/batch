package jvalt;
import java.util.*;
import java.lang.*;
import java.awt.*;

public class BatchClient {

	public static void main(String[] args) {
		Batch batch = new Batch();
		boolean v = batch.add("String");
		batch.add("String");
		String[] a = {"S", "T", "R", "I", "N", "G"};
		batch.add(0, a);
		batch.add(0, "Hi");
		System.out.println(batch.toString());
		int[] i = {2, 4, 6};
		batch.remove(i);
		System.out.println(batch.toString());
		
		LockedBatch lbatch = batch.lock();
		lbatch.setBatch(batch);

	}

}
