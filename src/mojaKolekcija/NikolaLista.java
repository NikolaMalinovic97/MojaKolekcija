package mojaKolekcija;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NikolaLista<T> implements List<T> {

	T niz[];

	@Override
	public boolean add(T e) {
		int index = -1;
		for (int i = 0; i < niz.length; i++) {
			if(! niz[i].equals(null)) {
				index = i + 1;
			}
		}
		niz[index] = e;
		if(index > -1)
			return true;
		else
			return false;
	}

	@Override
	public void add(int index, T element) {
		niz[index] = element;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		for (int i = 0; i < niz.length; i++) {
			niz[i] = null;
		}
	}

	@Override
	public boolean contains(Object o) {
		for (T element : niz) {
			if(element.equals(o))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(int index) {
		return niz[index];
	}

	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < niz.length; i++) {
			if(niz[i].equals(o))
				return i;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		for (T element : niz) {
			if(! element.equals(null))
				return false;
		}
		return true;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		for (int i = niz.length - 1; i >= 0 ; i--) {
			if(niz[i].equals(o))
				return i;
		}
		return -1;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < niz.length; i++) {
			if(niz[i].equals(o)) {
				for (int j = i; j < niz.length - 1; j++) {
					niz[j] = niz[j+1];
				}
				niz[niz.length-1] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public T remove(int index) {
		T removed = niz[index];
		for (int i = index; i < niz.length - 1; i++) {
			niz[i] = niz[i+1];
		}	
		niz[niz.length-1] = null;
		return removed;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T set(int index, T element) {
		T replaced = niz[index];
		niz[index] = element;
		return replaced;
	}

	@Override
	public int size() {
		for (int i = niz.length - 1; i >= 0; i--) {
			if(! niz[i].equals(null))
				return i;
		}
		return 0;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		NikolaLista<T> nl = new NikolaLista<>();
		for (int i = fromIndex; i <= toIndex; i++) {
			nl.add(niz[i]);
		}
		return nl;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
