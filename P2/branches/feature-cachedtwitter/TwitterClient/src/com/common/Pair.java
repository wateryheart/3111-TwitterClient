package com.common;

public class Pair<TKey, TValue> implements IPair<TKey,TValue> {
    private TKey key; //key member of pair
    private TValue value; //value member of pair

    public Pair(TKey key, TValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void setKey(TKey key) {
        this.key = key;
    }

    @Override
    public void setValue(TValue value) {
        this.value = value;
    }

    @Override
    public TKey getKey() {
        return key;
    }

    @Override
    public TValue getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
        if (value != null ? !value.equals(pair.value) : pair.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
