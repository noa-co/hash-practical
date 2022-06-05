package com.company;

public class AQPHashTable extends OAHashTable {

	public AQPHashTable(int m, long p) {
		super(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int hk = this.modHash.Hash(x);
		int sign = i%2==0? 1 : -1; // Same as calculating -1 times i
		return (Math.floorMod(Math.floorMod(hk + (sign)*(i*i), m) +this.m,this.m));
	}
}
