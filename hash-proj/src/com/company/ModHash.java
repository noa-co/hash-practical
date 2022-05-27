package com.company;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

public class ModHash {

	private final Function<Long, Integer> func;

	private ModHash(long a, long b, int m, long p){
		this.func = (Long x)-> (int)(((a*x + b) % p) % m);
	}
	
	public static ModHash GetFunc(int m, long p){
		Random r = new Random();
		// todo what if p zero
		long a = ThreadLocalRandom.current().nextLong(1, p);
		long b = ThreadLocalRandom.current().nextLong(0, p);
		return new ModHash(a, b, m, p);

	}
	
	public int Hash(long key) {
		return this.func.apply(key);
	}
}
