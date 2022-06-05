package com.company;
/*
username1 - nc7
id1      - 209223114
name1    - noa cohen
username2 - ec1
id2      - 205882236
name2    - eyal cohen
*/

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
		int index;
		HashTableElement element;
		Integer deletedIndex = null;
		long keyToInsert = hte.GetKey();

		for (int i = 0; i < this.m; i++) {
			index = this.Hash(keyToInsert, i);
			element = table[index];

			if (element == null){ // reached end of search, insert to deleted index if exists otherwise to null spot
				if (deletedIndex != null)
					table[deletedIndex] = hte;
				else
					table[index] = hte;
				return;
			}

			if (deletedIndex == null && element == deletedElement) { // reached possible insert spot containing deleted
				deletedIndex = index;
				continue;
			}

			if (element.GetKey() == keyToInsert) // found an existing element with the same key
				throw new KeyAlreadyExistsException(hte);
		}
		// got here meaning didn't get to a null spot in search.
		// if there wasn't an index with deleted- the table is full.
		if (deletedIndex == null)
			throw new TableIsFullException(hte);
		table[deletedIndex] = hte;
	}

	/**
	 *
	 * @param key - the key to find the index of element in the table
	 * @return the index of table entry with the required key if exists, or null otherwise.
	 */
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
