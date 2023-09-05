package 자료구조.해시;

public class ChainHash<K, V> {

    class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        public int hashCode() {
            return key.hashCode();
        }
    }

    private int size;
    private Node<K, V>[] table;

    public ChainHash(int size) {
        try {
            table = new Node[size];
            this.size = size;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    public V search(K key) {
        // 키 값에 해당하는 해시 값으로 접근
        int hash = hashValue(key);
        Node<K, V> node = table[hash];

        // 해시값에 해당하는 연결리스트에 일치하는 키값을 가진 노드가 나타날 때까지 탐색
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.next;
        }

        // 검색 실패
        return null;
    }

    public int add(K key, V value) {
        int hash = hashValue(key);

        // 해시값에 해당하는 연결리스트 접근
        Node<K, V> node = table[hash];

        // 빈 노드로 접근
        while (node != null) {
            // 만약 입력하려는 키 값에 해당하는 노드가 이미 존재한다면
            if (node.getKey().equals(key)) {
                return 1;
            }

            node = node.next;
        }

        // 노드 생성 후 입력
        Node<K, V> temp = new Node<K, V>(key, value, table[hash]);
        table[hash] = temp;
        return 0;
    }
}


