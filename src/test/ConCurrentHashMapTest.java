package test;

/**
 * @Description: conCurrentHashMap测试
 * @author: Arnold
 * @since: 2019/4/1 17:50
 * @version: v1.0.0
 */
public class ConCurrentHashMapTest<K,V> {
}

class HashEntry<K,V>{
    final K key;
    final int hash;
    volatile V value;
    final HashEntry next;

    public HashEntry(K key,  V value, HashEntry next ,int hash) {
        this.key = key;
        this.hash = hash;
        this.value = value;
        this.next = next;
    }
}
