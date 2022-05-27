package com.company;

public class AQPHashTable extends OAHashTable {

	public AQPHashTable(int m, long p) {
		super(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int hk = this.modHash.Hash(x);
		int sign = (int) Math.pow(-1,(i));
		int to_return = (((hk + (sign)*(i*i))% this.m)+this.m)%this.m;
		boolean d = (to_return >= m);
		return to_return;
	}
}
