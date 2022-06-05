package com.company;

public class DoubleHashTable extends OAHashTable {
	protected ModHash modHash2;
	public DoubleHashTable(int m, long p) {
		super(m, p);
		this.modHash2 = ModHash.GetFunc(m-1, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		long hk = this.modHash.Hash(x);
		long hk2 = this.modHash2.Hash(x) + 1;

		long res =  ((hk + (i * hk2)) );
		return Math.floorMod((int) res , this.m);
	}
}
