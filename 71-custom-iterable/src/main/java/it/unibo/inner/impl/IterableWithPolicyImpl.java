package it.unibo.inner.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{
    private T[] array;
    private Predicate<T> filter;

    public IterableWithPolicyImpl(T[] array){
        this(array, new Predicate<T>(){
            public boolean test(T elem){
                return true;
            }
        }
        );
        }

    public IterableWithPolicyImpl(T[] array, Predicate<T> predicate) {
        this.array = array;
        this.filter = predicate;
    }

    public Iterator<T> iterator(){
        return new IteratorImpl();
    }
    
    private class IteratorImpl implements Iterator<T>{
        int counter = 0;

        @Override
        public boolean hasNext() {
            while (counter < array.length && !filter.test(array[counter])){
                counter++;
            }
            return counter < array.length;
        }

        @Override
        public T next() {
            if(hasNext()){
                    T currentE = array[counter];
                    counter++;
                    return currentE;
            }
            throw new NoSuchElementException();
        }
        
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.filter = filter;
    }
    
}
