package com.company;

public class QPHashTable extends OAHashTable {

	public QPHashTable(int m, long p) {
		super(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int hk = this.modHash.Hash(x);
		return (hk + (i*i))% this.m;
	}
}
