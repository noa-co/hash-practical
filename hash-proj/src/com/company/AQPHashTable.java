package com.company;

public class AQPHashTable extends OAHashTable {

	public AQPHashTable(int m, long p) {
		super(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int hk = this.modHash.Hash(x);
		int sign = (int) Math.pow(-1,(i));
		return (hk + (sign)*(i*i))% this.m;
	}
}
