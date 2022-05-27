package com.company;

public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	protected ModHash modHash;
	protected int m;
	private static final HashTableElement deletedElement = new HashTableElement(-999,-999);
	
	public OAHashTable(int m, long p) {
		this.table = new HashTableElement[m];
		this.m = m;
		this.modHash = ModHash.GetFunc(m, p);
	}

	@Override
	public HashTableElement Find(long key){
		int index;
		HashTableElement element;
		for (int i = 0; i < this.m; i++) {
			index = this.Hash(key, i);
			element = table[index];
			if (element == null)
				return null;
			if (element.GetKey() == key)
				return element;
		}
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		// TODO implement insertion
	}

	private Integer FindIndex(long key){
		int index;
		HashTableElement element;
		for (int i = 0; i < this.m; i++) {
			index = this.Hash(key, i);
			element = table[index];
			if (element == null)
				return null;
			if (element.GetKey() == key)
				return index;
		}
		return null;
	}


	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		Integer indexElement = this.FindIndex(key);
		if (indexElement == null){
			throw new KeyDoesntExistException(key);
		}
		this.table[indexElement] = deletedElement;
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
