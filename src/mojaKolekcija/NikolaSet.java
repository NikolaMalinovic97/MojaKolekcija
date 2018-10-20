package mojaKolekcija;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


public class NikolaSet<T> implements Set<T> {

	private T[] niz;
	private int size;
	
	@SuppressWarnings("unchecked")
	public NikolaSet() {
		this.size = 2;
		this.niz = (T[]) new Object[size];
	}

	private boolean trebaPovecati() {
		return ! (niz[size - 1] == null);
	}
	
	private T[] noviNiz(T[] stariNiz) {
		size *= 2;
		@SuppressWarnings("unchecked")
		T[] noviNiz = (T[]) new Object[size];
		int i = -1;
		for (T element : stariNiz) {
			i++;
			noviNiz[i] = element;
		}
		return noviNiz;
	}
	
	@Override
	public String toString() {
		String str = "[";
		if(isEmpty()) {
			str += "]";
			return str;
		}
		for (int i = 0; i < size() - 1; i++) {
			str += niz[i] + ", ";
		}
		str += niz[size() - 1]	+ "]";	
		return str;
	}
	
	@Override
	public boolean add(T arg0) {
		if(contains(arg0))
			return false;
		else {
			if(trebaPovecati()) {
				niz = noviNiz(niz);
			}
			niz[size()] = arg0;
			return true;
		}
	}

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		boolean result = false;
		for (T t : arg0) {
			if(! contains(t)) {
				add(t);
				result = true;
			}
		}
		return result;
	}

	@Override
	public void clear() {
		for (int i = 0; i < niz.length; i++) {
			niz[i] = null;
		}
	}

	@Override
	public boolean contains(Object arg0) {
		for (T t : niz) {
			if(arg0==null ? t==null : arg0.equals(t))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		for (Object object : arg0) {
			if(! contains(object))
				return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		if(size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new NikolaSetIterator();
		return iterator;
	}

	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < size(); i++) {
			if(o==null ? niz[i]==null : o.equals(niz[i])) {
				for (int j = i + 1; j < size(); j++, i++) {
					niz[i] = niz[j];
				}
				niz[size() - 1] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean result = false;
		for (Object object : c) {
			if(contains(object)) {
				remove(object);
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean result = false;
		for (int i = 0; i < size(); i++) {
			if(! c.contains(niz[i])) {
				remove(niz[i]);
				result = true;
			}
		}
		return result;
	}

	@Override
	public int size() {
		if(niz.length <= 2) {
			if (niz[0] == null)
				return 0;
			else
				return 1;
		}
		for (int i = niz.length - 1; i >= 0; i--) {
			if(! (niz[i] == null))
				return i + 1;
		}
		return 0;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size()];
		for (int i = 0; i < size(); i++) {
			array[i] = niz[i];
		}
		return array;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	@Override
	public <T> T[] toArray(T[] a) {
		for (int i = 0; i < size(); i++) {
			a[i] = (T) niz[i];
		}
		return a;
	}
	
	
	//------------------------ITERATOR--------------------------
	
		private class NikolaSetIterator implements Iterator<T> {
			
			private int index = -1;
			@Override
			public boolean hasNext() {
				return index < size() - 1;
			}

			@Override
			public T next() {	
				return niz[++index];
			}
		}

}
