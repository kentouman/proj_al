package problem;

public class MyHashTable
{
    private HashTableEntry[] table;
    private int size;

    public MyHashTable(int num, double load)
    {
        if(load > 1 || load <= 0)
        {
            System.out.println("hi");
        }

        size = (int) ((double)num / load);
        table = new HashTableEntry[size];
    }
    
    public void print()
    {
        HashTableEntry node = null;
        for(int i = 0 ; i < size; i++)
        {
            System.out.printf("Entry # %02d :", i);
            node = table[i];
            while(node != null)
            {
                System.out.printf(" %d(%s) -> ", node.key, node.value);
                node = node.next;
            }
            System.out.println();

        }
    }

    public boolean containsKey(int key)
    {
        int ind = getIndex(key);

        if(table[ind] == null)
        {
            return false;
        }
        else
        {
            HashTableEntry node = table[ind];
            while(node != null)
            {
                if(node.key == key)
                {
                    return true;
                }
                node = node.next;
            }
            return false;
        }
    }

    public String get(int key)
    {
        HashTableEntry node = findEntry(key);
        if(node != null)
        {
            return node.value;
        }
        else
        {
            return null;
        }
    }

    public void remove(int key)
    {
        return;
    }

    public void put(int key, String value)
    {
        int ind = getIndex(key);

        if(containsKey(key))
        {
            HashTableEntry node = findEntry(key);
            node.setValue(value);
        }    
        else
        {
            HashTableEntry node = new HashTableEntry(key, value);
            node.next = table[ind];
            table[ind] = node;
        }

    }

    private int getIndex(int key)
    {
        return hash(key) % size;
    
    }

    private int hash(int key)
    {
        return key;
    }

    private HashTableEntry findEntry(int key)
    {
        int ind = getIndex(key);
        HashTableEntry node = table[ind];

        while(node != null)
        {
            if(node.key == key)
            {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args)
    {
        MyHashTable ht = new MyHashTable(10,0.5);
        ht.put(1,"a");
        ht.put(1,"aa");
        ht.put(41,"aaa");
        ht.put(5,"e");
        ht.print();
    }
}

class HashTableEntry
{
    int key;
    String value;
    HashTableEntry next;

    public HashTableEntry(int key, String value)
    {
        this.key = key;
        this.value = value;
        next = null;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
