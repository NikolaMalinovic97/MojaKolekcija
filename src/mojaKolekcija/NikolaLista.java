package mojaKolekcija;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NikolaLista<T> implements List<T> {

	private T[] niz;
	private int size;
	
	@SuppressWarnings("unchecked")
	public NikolaLista() {
		this.size = 2;
		this.niz = (T[]) new Object[size];
	}
	
	private boolean trebaPovecati() {
		T lastElement = niz[size - 1];
		if(lastElement == null)
			return false;
		else
			return true;
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
	public boolean add(T t) {
		if(trebaPovecati()) {
			niz = noviNiz(niz);
		}
		int index = -1;
		for (int i = 0; i < niz.length; i++) {
			if(! niz[i].equals(null)) {
				index = i + 1;
			}
		}
		niz[index] = t;
		if(index > -1)
			return true;
		else
			return false;
	}

	@Override
	public void add(int index, T element) {
		if(trebaPovecati()) {
			niz = noviNiz(niz);
		}
		for (int i = niz.length - 1; i > index; i--) {
			niz[i] = niz[i-1];
		}
		niz[index] = element;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		if(c.isEmpty())
			return false;
		if(trebaPovecati()) {
			niz = noviNiz(niz);
		}
		int index = 0;
		for (int i = 0; i < niz.length; i++) {
			if(! niz[i].equals(null)) {
				index = i + 1;
			}
		}
		for (T element : c) {
			if(trebaPovecati()) {
				niz = noviNiz(niz);
			}
			niz[index] = element;
			index++;
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		if(c.isEmpty())
			return false;
		if(trebaPovecati()) {
			niz = noviNiz(niz);
		}
		int inputIndex = index + c.size();
		for (int i = index; i < c.size() + index; i++) {
			if(trebaPovecati()) {
				niz = noviNiz(niz);
			}
			niz[inputIndex] = niz[i];
			inputIndex++;
		}
		for (T t : c) {
			niz[index] = t;
			index++;
		}
		return true;
	}

	@Override
	public void clear() {
		for (int i = 0; i < niz.length; i++) {
			niz[i] = null;
		}
	}

	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < niz.length; i++) {
			if(o==null ? niz[i]==null : o.equals(niz[i]))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if(! contains(o))
				return false;
		}
		return true;
	}

	@Override
	public T get(int index) {
		return (T) niz[index];
	}

	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < niz.length; i++) {
			if(o==null ? get(i)==null : o.equals(get(i)))
				return i;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		for (Object o : niz) {
			if(! o.equals(null))
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
			if(o==null ? get(i)==null : o.equals(get(i)))
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
			if(o==null ? get(i)==null : o.equals(get(i))) {
				for (int j = i; j < niz.length - 1; j++) {
					niz[j] = niz[j+1];
				}
				for (int j = niz.length - 1; j >= 0; j--) {
					if(niz[j] != null) {
						break;
					}
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public T remove(int index) {
		T removed = (T) niz[index];
		for (int i = index; i < niz.length - 1; i++) {
			niz[i] = niz[i + 1];
		}
		for (int i = niz.length - 1; i >= 0; i--) {
			if(niz[i] != null) {
				break;
			}
		}
		return removed;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if(c.isEmpty())
			return false;
		boolean changed = false;
		for (Object object : c) {
			while(true) {
				if(remove(object))
					changed = true;
				else
					break;
			}
		}
		return changed;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean razliciti = true;
		for (int i = 0; i < size(); i++) {
			for (Object object : c) {
				if(niz[i].equals(object)) {
					break;
				}
				if(i == size() - 1) {
					razliciti = false;
				}
			}
		}
		@SuppressWarnings("unchecked")
		T[] noviNiz = (T[]) new Object[size];
		for (int i = 0, j = 0; i < size(); i++) {
			for (Object object : c) {
				if(niz[i].equals(object)) {
					noviNiz[j] = niz[i];
					j++;
					break;
				}
			}
		}
		niz = noviNiz;
		return razliciti;
	}

	@Override
	public T set(int index, T element) {
		T replaced = (T) niz[index];
		niz[index] = element;
		return replaced;
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
	public List<T> subList(int fromIndex, int toIndex) {
		NikolaLista<T> nl = new NikolaLista<>();
		for (int i = fromIndex; i <= toIndex; i++) {
			nl.add((T) niz[i]);
		}
		return nl;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size()];
		for (int i = 0; i < size(); i++) {
			array[i] = niz[i];
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
