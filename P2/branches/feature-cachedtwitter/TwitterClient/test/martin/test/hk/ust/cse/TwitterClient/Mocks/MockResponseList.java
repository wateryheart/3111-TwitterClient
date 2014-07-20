package martin.test.hk.ust.cse.TwitterClient.Mocks;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import twitter4j.RateLimitStatus;
import twitter4j.ResponseList;

public class MockResponseList<T> implements ResponseList<T> {

	List<T> lists;
	public MockResponseList(){
		lists = new ArrayList<T>();
	}
	
	@Override
	public int getAccessLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return lists.add(e);
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		lists.add(index, element);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return lists.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return lists.addAll(index, c);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		lists.clear();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return lists.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return lists.containsAll(c);
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return lists.get(index);
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return lists.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return lists.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return lists.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return lists.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return lists.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return lists.listIterator(index);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return lists.remove(o);
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return lists.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return lists.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return lists.retainAll(c);
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return lists.set(index, element);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return lists.size();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return lists.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return lists.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return lists.toArray(a);
	}

	@Override
	public RateLimitStatus getRateLimitStatus() {
		// TODO Auto-generated method stub
		return null;
	}


}
