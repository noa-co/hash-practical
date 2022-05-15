package com.company;

public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	protected ModHash modHash;
	protected int m;
	
	public OAHashTable(int m, long p) {
		this.table = new HashTableElement[m];
		this.m = m;
		this.modHash = ModHash.GetFunc(m, p);
	}

	@Override
	public HashTableElement Find(long key) {
		// TODO implement find
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		// TODO implement insertion	
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		// TODO implement deletion
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
