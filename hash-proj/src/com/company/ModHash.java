package com.company;
import java.util.Random;
import java.util.function.Function;

public class ModHash {

	private final Function<Long, Integer> func;

	private ModHash(long a, long b, int m, long p){
		this.func = (Long x)-> (int)(((a*x + b) % p) % m);
	}
	
	public static ModHash GetFunc(int m, long p){
		Random r = new Random();
		long a = (r.nextLong()  % (p - 1)) + 1;
		long b = (r.nextLong()  % p);
		return new ModHash(a, b, m, p);

	}
	
	public int Hash(long key) {
		return this.func.apply(key);
	}
}
