package Tree;

import java.util.Comparator;

public class BinTree<K, V> {
    static class Node<K, V> {
        private K key;
        // 키값 , 타입은 임의의 자료형 K
        private V data;
        // 데이터 , 타입은 임의의 자료형 V
        private Node<K, V> left;
        // 왼쪽 포인터
        private Node<K, V> right;
        // 오른쪽 포인터

        public Node(K key, V data, Node<K, V> left, Node<K, V> right) { //생성자
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public K getKey() {  //키 값 반환
            return key;
        }

        public V getValue() {  //데이터 반환
            return data;
        }

        void print() { //데이터 출력
            System.out.println(data);
        }
    }

    private Node<K, V> root; //루트(시작점) 주소
    private Comparator<? super K> comparator = null;//비교자;

    public BinTree() {
        root = null; //root의 초기값을 null 로 지정하여 노드가 하나도 없는 이진 검색 트리 생성
    }

    public BinTree(Comparator<? super K> c) { //키 값의 대소 관계를 판단한다.
        this();
        comparator = c;
    }

    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
    }

    public V search(K key) { // value 값이 V 타입이기 때문에 리턴 타입은 V
        Node<K, V> p = root;

        while (true) {
            if (p == null) {
                return null; //null이면 검색안함..
            }
            int cond = comp(key, p.getKey());
            if (cond == 0) {
                return p.getValue();
            } else if (cond > 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
    }

    private void addNode(Node<K, V> node, K key, V data) {
        int cond = comp(key, node.getKey());
        if (cond == 0) {
            return; //cond가 0 이라는 의미는 이미 데이터가 있다는 의미
        } else if (cond < 0) {
            if (node.left == null) {
                node.left = new Node<K, V>(key, data, null, null);
            } else {
                addNode(node.left, key, data);
            }
        } else if (cond > 0) {
            if (node.right == null) {
                node.right = new Node<K, V>(key, data, null, null);
            } else {
                addNode(node.right, key, data);
            }
        }
    }

    public void add(K key, V data) {
        if (root == null) {
            root = new Node<K, V>(key, data, null, null);
        } else {
            addNode(root, key, data);
        }
    }

    public boolean remove(K key) {
        Node<K, V> p = root;
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        while (true) {
            if (p == null) { //데이터가 존재하지 않는 곳까지 이동하면
                return false;
            }
            int cond = comp(key, p.getKey());
            //찾으려는 키와 지금 위치의 키를 비교
            if (cond == 0) {
                break; // 찾았으면 p 가 삭제하려는 데이터를 가리키고 있을 것 그러므로 루프 종료
            } else {
                parent = p; //부모 노드로 지금 위치를 지정
                if (cond < 0) { //찾으려는 데이터가 지금 위치보다 작은 경우, 왼쪽으로 가야함
                    isLeftChild = true;
                    p = p.left;
                } else { //찾으려는 데이터가 지금 위치보다 큰 경우
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }
        // 위 루프를 통해서 찾으려는 데이터의 주소값을 갖고옴

        if (p.left == null) {
            if (p == root) {
                root = p.right;
                //검색한 p가 만약 최상단에 있는 root 라면, 그리고 그 최상단 루트가 왼쪽 자식이 없다면, 오른쪽 자식 주소로 갱신만 해주면 됨

            } else if (isLeftChild) {
                parent.left = p.right;
                // 검색한 p의 위치는 지워야 하기때문에 그리고 p는 왼쪽 노드가 없기 때문에, 부모의 왼쪽 노드를 p의 오른쪽 노드 값으로 갱신만 해주면 됨
            } else {
                parent.right = p.right;
                // 만약 부모의 오른쪽 자식 노드라면
                // 검색한 p의 위치는 지워야 하기때문에 그리고 p는 왼쪽 노드가 없기 때문에, 부모의 오른쪽 노드를 p의 오른쪽 노드 값으로 갱신만 해주면 됨
            }
        } else if (p.right == null) {
            //만약 검색한 노드의 오른쪽 자식이 없다면?
            if (p == root) {
                root = p.left;
            } else if (isLeftChild) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
        } else {//검색한 노드가 왼쪽 오른쪽 자식 둘다 있는 경우
            //최댓값 찾아서 집어넣어야함
            //최댓값이라 하면 검색한 노드의 왼쪽에서 출발하여 가장 오른쪽 가지에 있는 것
            parent = p;
            Node<K, V> left = p.left; //left 노드 객체 생성
            isLeftChild = true;
            while (left.right != null) {
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            //가장 오른쪽 자식이 없는 노드를 검색함 (left에 삭제할 노드 다음으로 큰 값이 저장될 것)
            p.key = left.key;
            p.data = left.data;
            if (isLeftChild) {
                parent.left = left.left;
                //부모의 왼쪽 노드 주소를 검색한 최댓값
            } else {
                parent.right = left.left;
            }
        }
        return true;

    }

    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left);
            System.out.println(node.key + " " + node.data);
            printSubTree(node.right);

        }
    }
    public void print(){
        printSubTree(root);
    }
}
