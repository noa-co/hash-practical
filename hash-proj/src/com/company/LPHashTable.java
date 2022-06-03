package com.company;

public class LPHashTable extends OAHashTable {
	
	public LPHashTable(int m, long p) {
		super(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int hk = this.modHash.Hash(x);
		return ((hk + i) % this.m);
	}
	
}
