/**
 * Theodora Nguyen
 * Professor David-Guy Brizan
 * CS 245-01
 * 4 May 2020
 *
 *  @file
 *  Implementation of a hashmap.
 * */

import java.lang.Math;
import java.util.*;
import java.util.ArrayList;

public class HashMap<K, V> {
    private int size;
    private List<K> keyContainers;
    private List<V> valueContainers;

    private int getcounter;


    public HashMap(){
        keyContainers = new ArrayList<K>(Integer.MAX_VALUE/100);
        valueContainers = new ArrayList<V>(Integer.MAX_VALUE/100);

        size = 0;
    }

    /**
     * Appends key at a specific index in the list. Appends the value at the same number index except in a seperate
     * list.
     * */
    public void put(K key, V value){

        int index;
        if(size == 0)
        {
            index = 0;
            keyContainers.add(index, key);
            valueContainers.add(index, value);
            size++;
            return;
        }
        else
        {
            index = Math.abs(key.hashCode() % keyContainers.size());
        }

        K currentKey = keyContainers.get(index); //[index];
        V currentValue = valueContainers.get(index);

        if (currentKey == null && currentValue == null )
        {
            keyContainers.add(index, key);
            valueContainers.add(index, value);
            size++;
            return;
        }

        keyContainers.add(index, key);
        valueContainers.add(index, value);

        size++;

        int key_count = 0;
        int val_count = 0;
        for (K k : keyContainers)
        {
            key_count++;
        }

        for (V v : valueContainers)
        {
            val_count++;
        }
    }

    /**
     * Returns back a set that belongs to the key values.
     * */
    public Set<String> keySet()
    {
        if(size > 0)
        {
            return new HashSet(keyContainers);
        }
        return new HashSet();
    }

    /**
     * Returns back a value based on the key.
     *
     * @param key is the key that will have it's value returned
     * */
    public V get(K key)
    {
        int index = Math.abs(key.hashCode()) % keyContainers.size();

        if (getcounter == 0)
        {
            index = 0;
        }

        if(containsKey(key))
        {
            getcounter++;
            return valueContainers.get(keyContainers.indexOf(key));
        }
        getcounter++;
        return null;
    }


    /**
     * Checks if the key exists in the list
     *
     * @param key is the key that is being checked if it exists
     * */
    public boolean containsKey(K key)
    {
        if(size == 0)
        {
            return false;
        }
        if(keyContainers.contains(key))
        {
            return true;
        }
        return false;
    }


    /**
     * Returns the value of the specified key
     *
     * @param key will have it's value returned
     * */
    public V find(K key)
    {
        int index = Math.abs(key.hashCode()) % keyContainers.size();

        K currentKey = keyContainers.get(index);
        V currentValue = valueContainers.get(index);

        if(currentKey == key)
        {
            return currentValue;
        }

        return null;
    }


    public String toString()
    {
        for(K key : keyContainers)
        {
            System.out.print(key + " ");
        }
        System.out.println();
        for(V value : valueContainers)
        {
            System.out.print(value + " \n");
        }

        return "\n";
    }


    /**
     * Removes all keys and values for stores that have been eliminated.
     *
     * @param key is the key that will be deleted along with it's value
     * */
    public void remove(K key){

        if(containsKey(key))
        {
            int index = keyContainers.indexOf(key);
            keyContainers.remove(index);
            valueContainers.remove(index);
            size--;
        }
        return;
    }
}