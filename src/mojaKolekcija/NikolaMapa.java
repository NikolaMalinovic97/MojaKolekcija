package mojaKolekcija;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class NikolaMapa<K, V> implements Map<K, V> {
	
	private K[] nizKey;
	private V[] nizValue;
	private int size;

	@SuppressWarnings("unchecked")
	public NikolaMapa() {
		this.size = 2;
		this.nizKey = (K[]) new Object[size];
		this.nizValue = (V[]) new Object[size];
	}
	
	private boolean trebaPovecati() {
		return (nizKey[size - 1] != null);
	}
	
	private K[] noviKeyNiz(K[] stariNiz) {
		@SuppressWarnings("unchecked")
		K[] noviNiz = (K[]) new Object[size];
		int i = -1;
		for (K element : stariNiz) {
			i++;
			noviNiz[i] = element;
		}
		return noviNiz;
	}
	
	private V[] noviValueNiz(V[] stariNiz) {
		@SuppressWarnings("unchecked")
		V[] noviNiz = (V[]) new Object[size];
		int i = -1;
		for (V element : stariNiz) {
			i++;
			noviNiz[i] = element;
		}
		return noviNiz;
	}
	
	@Override
	public String toString() {
		String str = "{";
		if(isEmpty()) {
			str += "}";
			return str;
		}
		for (int i = 0; i < size() - 1; i++) {
			str += nizKey[i] + "=" + nizValue[i] + ", ";
		}
		str += nizKey[size() - 1] + "=" + nizValue[size() - 1]	+ "}";	
		return str;
	}
	
	@Override
	public void clear() {
		for (int i = 0; i < size(); i++) {
			nizKey[i] = null;
			nizValue[i] = null;
		}
	}

	@Override
	public boolean containsKey(Object arg0) {
		for (K k : nizKey) {
			if(arg0==null ? k==null : arg0.equals(k))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		for (V v : nizValue) {
			if(arg0==null ? v==null : arg0.equals(v))
				return true;
		}
		return false;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		NikolaSet<Entry<K, V>> set = new NikolaSet<>();
		Entry<K, V> entry = new Entry<K, V>() {

			@Override
			public K getKey() {
				return nizKey[0];
			}

			@Override
			public V getValue() {
				return nizValue[0];
			}

			@Override
			public V setValue(V value) {
				return nizValue[0] = value;
			}
			
		};
		set.add(entry);
		return set;
	}

	@Override
	public V get(Object arg0) {
		if(containsKey(arg0)) {
			for (int i = 0; i < size(); i++) {
				if(nizKey[i].equals(arg0))
					return nizValue[i];
			}
		}
		else {
			return null;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if(size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new NikolaSet<>();
		for (K k : nizKey) {
			set.add(k);
		}
		return set;
	}

	@Override
	public V put(K arg0, V arg1) {
		if(trebaPovecati()) {
			size *= 2;
			nizKey = noviKeyNiz(nizKey);
			nizValue = noviValueNiz(nizValue);
		}
		V result = null;
		if(containsKey(arg0)) {
			for (int i = 0; i < size(); i++) {
				if(nizKey[i].equals(arg0)) {
					result = nizValue[i];
					nizValue[i] = arg1;
					break;
				}
			}
			return result;
		} 
		else {
			int index = size();
			nizKey[index] = arg0;
			nizValue[index] = arg1;
			return result;
		}
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> arg0) {
		Set<? extends K> setKey = arg0.keySet();
		int j = size();
		for (K k : setKey) {
			if(trebaPovecati()) {
				size *= 2;
				nizKey = noviKeyNiz(nizKey);
				nizValue = noviValueNiz(nizValue);
			}
			nizKey[j] = k;
			nizValue[j] = arg0.get(k);
			j++;
		}
	}

	@Override
	public V remove(Object arg0) {
		if(containsKey(arg0)) {
			V returnValue = null;
			for (int i = 0; i < size(); i++) {
				if(arg0==null ? nizKey[i]==null : arg0.equals(nizKey[i])) {
					returnValue = nizValue[i];
					for (int j = i; j < size() - 1; j++) {
						nizKey[j] = nizKey[j + 1];
						nizValue[j] = nizValue[j + 1];
					}
					nizKey[size()-1] = null;
					nizValue[size()] = null;
					break;
				}
			}
			return returnValue;
		}
		else {
			return null;
		}
	}

	@Override
	public int size() {
		if(nizKey.length <= 2) {
			if (nizKey[0] == null)
				return 0;
			else
				return 1;
		}
		for (int i = nizKey.length - 1; i >= 0; i--) {
			if(nizKey[i] != null)
				return i + 1;
		}
		return 0;
	}

	@Override
	public Collection<V> values() {
		Collection<V> kolekcija = new NikolaLista<V>();
		for (V v : nizValue) {
			kolekcija.add(v);
		}
		return kolekcija;
	}

}
