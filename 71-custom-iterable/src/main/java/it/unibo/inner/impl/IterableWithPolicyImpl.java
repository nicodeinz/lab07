package it.unibo.inner.impl;

import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{
    private T[] array;

    public IterableWithPolicyImpl(T[] array){
        this.array = array;
    }

    public Iterator<T> iterator(){
        return new IteratorImpl();
    }
    
    private class IteratorImpl implements Iterator<T>{
        int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < array.length;
        }

        @Override
        public T next() {
            T currentE = array[counter];
            counter++;
            return currentE;
        }
        
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
    }
    
}
