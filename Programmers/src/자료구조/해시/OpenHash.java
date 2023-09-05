package 자료구조.해시;

public class OpenHash<K, V> {
    enum Status {OCCUPIED, EMPTY, DELETED}

    static class Bucket<K, V> {
        private K key;
        private V value;
        private Status status;

        public Bucket() {
            this.status = Status.EMPTY;
        }

        void set(K key, V value, Status status) {
            this.key = key;
            this.value = value;
            this.status = status;
        }

        void setStatus(Status status) {
            this.status = status;
        }

        K getKey() {
            return this.key;
        }

        V getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }

    private int size;
    private Bucket<K, V>[] table;

    public OpenHash(int size) {

        try {
            table = new Bucket[size];
            for (int i = 0; i < size; i++) {
                table[i] = new Bucket<>();
            }
            this.size = size;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    public int rehashValue(int hash) {
        return (hash + 1) % size;
    }

    public V search(K key) {
        Bucket<K, V> bucket = searchNode(key);

        return bucket == null ? null : bucket.getValue();
    }

    private Bucket searchNode(K key) {
        int hash = hashValue(key);
        Bucket<K, V> bucket = table[hash];

        for (int i = 0; bucket.status != Status.EMPTY && i < size; i++) {
            if (bucket.status == Status.OCCUPIED && bucket.getKey().equals(key)) {
                return bucket;
            }
            hash = rehashValue(hash);
            bucket = table[hash];
        }

        return null;
    }

    public int add(K key, V value) {
        // 이미 존재하는 경우
        if (search(key) != null) {
            return 1;
        }

        int hash = hashValue(key);
        Bucket<K, V> bucket = table[hash];
        for (int i = 0; i < size; i++) {
            if (bucket.status == Status.EMPTY || bucket.status == Status.DELETED) {
                bucket.set(key, value, Status.OCCUPIED);
                return 0;
            }
            hash = rehashValue(hash);
            bucket = table[hash];
        }

        // 테이블이 가득 찬 경우
        return 2;
    }
}
