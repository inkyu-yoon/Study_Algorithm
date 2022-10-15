package Tree;


import java.util.Comparator;

//2진 트리 구현
public class BinTree<K, V> {

    static class Node<K,V>{

        K key; //임의의 자료형 K 타입의 키
        V data; // 임의의 자료형 V 타입의 데이터
        Node<K,V> left; // 왼쪽 노드 객체
        Node<K,V> right; //오른쪽 노드 객체

        //1. 노드 생성 시 , 생성자를 사용해서 정보 입력.
        public Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        //노드의 주소 값 반환, 노드 검색 시 사용됨
        public K getKey() {
            return key;
        }

        //노드가 가진 데이터 반환
        public V getValue() {
            return data;
        }

        //노드가 가진 데이터 출력
        void print() {
            System.out.println(data);
        }
    }

    private Node<K,V> root; //트리의 제일 상단에 있는 노드 객체
    private Comparator<? super K> comparator = null; //비교자를 명시적으로 설정하지 않으면 null값


    public BinTree(){ //비교자를 null(default) 값으로 받는 기본 생성자
        root = null;
    }

    // 비교자를 매개변수로 받는 생성자, customComparator를 받을 수 있다.
    public BinTree(Comparator<? super K> c){
        this();
        comparator = c;
    }

    //키 값의 대소비교
    private int comp(K key1, K key2){
        return (comparator == null)?((Comparable<K>)key1).compareTo(key2):comparator.compare(key1,key2);
    }

    // K key 를 기준으로 V data를 반환하는 메서드
    public V search(K key){
        Node<K,V> p = root; //루트(최상단 노드)

        while(true){
            if(p == null) { //최상단 노드가 null이라면 검색할 것이 없음.
                return null;
            }
            int cond = comp(key,p.getKey());
            if(cond == 0){ //comp() 결과가 0이라는 뜻은, 해당 key에 해당하는 노드라는 것
                return p.getValue();
            }
            else if(cond < 0){
                p = p.left; //0보다 작다는 뜻은 비교한 키의 왼쪽 자식 노드 방향으로 가야한다는 의미
            }
            else{
                p = p.right; //0보다 크다는 뜻은 비교한 키의 오른쪽 자식 노드 방향으로 가야한다는 의미
            }
        }
    }

    //적절한 위치에 Node 객체를 생성하는 메서드
    private void addNode(Node<K,V> node, K key , V data){
        int cond = comp(key,node.getKey());
        if(cond == 0){ //매개변수로 넣은 key값 과의 대소비교에서 0이라는 의미는 이미 존재한다는 뜻
            return;
        }
        else if(cond <0){// 왼쪽 자식 노드로 이동
            if(node.left == null){ //아직 왼쪽 자식 노드가 비어있다면 노드 등록
                node.left = new Node<K,V>(key, data, null, null);
            }
            else{
                addNode(node.left, key, data); //왼쪽 노드 객체를 기준으로 key값 한번 더 key 비교
            }
        }
        else{
            if(node.right == null){ //아직 오른쪽 자식 노드가 비어있다면 노드 등록
                node.right = new Node<K,V>(key, data, null, null);
            }
            else{
                addNode(node.right, key, data); //왼쪽 노드 객체를 기준으로 key값 한번 더 key 비교
            }
        }
    }

    //노드 삽입 메서드
    public void add(K key, V data){
        if(root == null){//아직 최상단 노드인 루트가 비어있다면 생성자로 할당
            root = new Node<K,V>(key, data, null, null);
        }
        else{
            addNode(root, key, data);
        }
    }



    //key 값에 해당하는 노드 삭제
    public boolean remove(K key) {
        Node<K, V> p = root; //최상단 root 노드에서 시작
        Node<K, V> parent = null; // 최상단 root 노드의 부모 노드는 없다.
        boolean isLeftChild = true; //찾으려는 노드가 왼쪽에 있는지 확인하는 boolean

        while (true) {
            if (p == null) { //데이터가 존재하지 않는 곳까지 이동하면 매개변수로 입력한 key 값이 없다는 의미이므로 false 반환
                return false;
            }
            int cond = comp(key, p.getKey()); //찾으려는 키(key)와 지금 위치(p.getKey())의 키를 비교
            if (cond == 0) {
                break; // 찾았으면 p 가 삭제하려는 키를 가리키고 있을 것 그러므로 루프 종료
            } else { //못찾은 경우
                parent = p; //부모 노드로 지금 위치를 지정
                if (cond < 0) { //찾으려는 키(p.getKey())가 지금 키(key)보다 작은 경우, 왼쪽으로 가야함
                    isLeftChild = true; //왼쪽 자식 노드로 가야하므로 true;
                    p = p.left; //비교 대상 노드를 p의 왼쪽 자식 노드로 갱신
                } else { //찾으려는 데이터가 지금 위치보다 큰 경우
                    isLeftChild = false; //오른쪽 노드로 가야하므로 false;
                    p = p.right; //비교 대상 노드를 오른쪽 자식 노드로 갱신
                }
            }
        }
        // 위 루프를 통해서 결과적으로, 찾으려는 키의 객체를 갖고옴



        if (p.left == null) { //찾은 객체의 왼쪽 자식 노드가 없는 경우
            if (p == root) { //찾은 객체가 최상단 노드인 root인 경우
                root = p.right;
                //그리고 그 최상단 루트가 왼쪽 자식이 없다면, 
                //최상단 노드인 root를 오른쪽 자식 주소로 갱신만 해주면 됨

            }
            else if (isLeftChild) { //위 루프를 통해 찾은 키의 객체, 즉 지우려고 하는 객체가 부모의 왼쪽 자식 노드인 경우
                parent.left = p.right;
                // 검색한 p의 노드는 지워야 하기때문에 그리고 p는 왼쪽 노드가 없기 때문에, 
                // 부모의 왼쪽 자식 노드를 p의 오른쪽 자식 노드 값으로 갱신만 해주면 성립된다. (그림 그려보면 이해 잘됨)
            }
            else {
                parent.right = p.right;
                // 만약 부모의 오른쪽 자식 노드라면
                // 검색한 p의 위치는 지워야 하기때문에 그리고 p는 왼쪽 노드가 없기 때문에, 
                // 부모의 오른쪽 노드를 p의 오른쪽 노드 값으로 갱신만 해주면 됨
            }
        }
        else if (p.right == null) {
            //만약 검색한 노드의 오른쪽 자식이 없다면? 위 과정과 비슷하다.
            if (p == root) {
                root = p.left;
            }
            else if (isLeftChild) {
                parent.left = p.left;
            }
            else {
                parent.right = p.left;
            }
        }
        else {//검색한 노드가 왼쪽 오른쪽 자식 둘다 있는 경우, 제거하기 위해서
            //키보다 작은 키들 중 가장 최댓값 키를 찾아서 집어넣고, 그 최댓값 키의 부모 노드에는
            //찾은 최댓값 키의 자식 노드를 넘겨주고 가야함
            //최댓값이라 하면 검색한 노드의 왼쪽에서 출발하여 가장 오른쪽 가지에 있는 것
            parent = p;
            Node<K, V> left = p.left; //제거하려는 p의 왼쪽 자식 노드 객체 생성
            isLeftChild = true;
            while (left.right != null) { //자식 노드의 오른쪽 자식이 없을 때 까지의 의미는, 왼쪽 노드 중 최댓값을 의미
                parent = left;
                left = left.right;
                //오른쪽 자식 노드가 없을 때까지 오른쪽 자식 노드로 이동
                isLeftChild = false;
            }
            //위 루프를 통해, 가장 오른쪽 자식이 없는 노드를 검색 완료 
            // (left에 삭제할 노드 다음으로 큰 값이 저장될 것)

            p.key = left.key; //삭제할 p 객체의 맴버를 위 루프를 통해 구한 left 객체의 맴버로 전부 변환
            p.data = left.data;
            if (isLeftChild) { //
                parent.left = left.left;
                //왼쪽 자식으로 최댓값이 검색된 경우, 떠나기 전에 왼쪽 자식을 부모의 왼쪽 자식 에 넘겨주면 됨.
            } else {
                parent.right = left.left;
                //오른쪽 자식으로 최댓값이 검색된 경우, 왼쪽 자식만 존재하므로 왼쪽 자식 객체만 연결시켜주고 떠나면 됨
            }
        }
        return true;

    }


    //트리 출력하는 메서드
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