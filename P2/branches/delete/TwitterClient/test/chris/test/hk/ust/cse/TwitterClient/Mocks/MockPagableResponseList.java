package chris.test.hk.ust.cse.TwitterClient.Mocks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import twitter4j.PagableResponseList;
import twitter4j.RateLimitStatus;
import twitter4j.User;
public class MockPagableResponseList<T extends User> implements PagableResponseList<T> {
	
	private List<T> list;
	private long _cursor = -1;
	public MockPagableResponseList(long cursor){
		list = new ArrayList<T>();
		_cursor = cursor;
	}
	@Override
	public RateLimitStatus getRateLimitStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAccessLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return list.add(e);
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		list.add(index,element);
		
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return list.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return list.addAll(index, c);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();	
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return list.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return list.containsAll(c);
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub

		return list.get(index);
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return list.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return list.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return list.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return list.listIterator(index);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return list.remove(o);
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return list.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return list.retainAll(c);
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return list.set(index, element);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return list.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		
		return list.toArray(a);
	}

	@Override
	public long getNextCursor() {
		// TODO Auto-generated method stub
	
		return 0;
	}

	@Override
	public long getPreviousCursor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
