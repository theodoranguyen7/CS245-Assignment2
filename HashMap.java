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
        //System.out.println(Integer.MAX_VALUE/100);

        size = 0;
    }



    public void put(K key, V value){

        int index;
        if(size == 0)
        {
            index = 0;
            keyContainers.add(index, key);
            valueContainers.add(index, value);
            size++;
            System.out.println("First key: "+key);
            System.out.println("First value"+value);
            System.out.println(" I GET CALLED");

            return;
        }
        else
        {
            index = Math.abs(key.hashCode() % keyContainers.size());
        }

        //int index = Math.abs(key.hashCode() % keyContainers.size());

        K currentKey = keyContainers.get(index); //[index];
        V currentValue = valueContainers.get(index);

        //K previousKey = currentKey;
        //V previousValue = currentValue;


        if (currentKey == null && currentValue == null )
        {
            System.out.println("DO I GET CALLED");
            keyContainers.add(index, key);
            valueContainers.add(index, value);
            size++;
            System.out.println("Single key" + key);
            System.out.println("Single Value"+value);
            return;
        }

//        while(currentKey != null && currentValue != null)
//        {
//            if (currentValue == value)
//            {
//                return;
//            }
//            previousKey = currentKey;
//            previousValue = currentValue;
//            currentKey = currentKey.next();
//            currentValue = currentValue.next();
//        }
        //if head is not null and there are no more nodes after
//        previousKey.setNext(key);
//        previousValue.setNext(value);
        System.out.println("This is the current index"+index);
        System.out.println("This is the current key"+key);
        System.out.println("This is the current value"+value);

        System.out.println("DODODO I GET CALLED");

        //index = index+1;
        keyContainers.add(index, key);
        valueContainers.add(index, value);

        size++;
//        System.out.println("keyCONTAINER" + keyContainers.toString());
//        System.out.println("valueCONTAINER" + valueContainers.toString());

        int key_count = 0;
        int val_count = 0;
        for (K k : keyContainers)
        {
            System.out.println(key_count);
            System.out.println(k.toString());
            key_count++;
        }

        for (V v : valueContainers)
        {
            System.out.println(val_count);
            System.out.println(v.toString());
            val_count++;
        }
    }

    public Set<String> keySet()
    {
        if(size > 0)
        {
            return new HashSet(keyContainers);
        }
        return new HashSet();
    }

    public V get(K key)
    {
        int index = Math.abs(key.hashCode()) % keyContainers.size();


        if (getcounter == 0)
        {
            index = 0;
        }
        //System.out.println(index);


        if(containsKey(key))
        {
            getcounter++;
            //System.out.println(keyContainers.indexOf(key));
            //System.out.println(valueContainers.get(keyContainers.indexOf(key)));
            return valueContainers.get(keyContainers.indexOf(key));
        }
        getcounter++;
        return null;
    }

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
//
//        int index = Math.abs(key.hashCode()) % keyContainers.size();
//
//        K currentKey = keyContainers.get(index);
//        //V currentValue = valueContainers.get(index);
//
//        if(currentKey != null)
//        {
//            return true;
//        }
//        return false;
    }

    public V find(K key)
    {
        int index = Math.abs(key.hashCode()) % keyContainers.size();

        K currentKey = keyContainers.get(index);
        V currentValue = valueContainers.get(index);

        if(currentKey == key)
        {
            return currentValue;
        }

//        while (currentKey != null && currentValue!= null)
//        {
//            if(currentKey.getKey().equals(key))
//            {
//                return currentValue.getValue();
//            }
//
//            currentKey = currentKey.next();
//            currentValue = currentValue.next();
//        }

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
            //valloc++;
        }

        return "\n";
    }

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