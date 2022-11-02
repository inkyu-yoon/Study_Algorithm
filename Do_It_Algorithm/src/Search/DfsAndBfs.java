package Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph{
    class Node{
        int data;

        //인접한 노드들 과의 관계
        LinkedList<Node> neighbor;

        //방문했는지 마킹
        boolean marked;

        //생성자로 데이터를 채우고, 방문 마크를 false, 그리고 링크드 리스트를 준비시킨다.
        Node(int data) {
            this.data = data;
            this.marked = false;
            neighbor = new LinkedList<>();
        }
    }

    Node[] nodes;

    //노드 객체로 이루어진 배열을 생성자를 통해서 초기화
    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    //두 노드의 관계를 저장하는 함수
    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        //인접한 관계에 있는 노드들을 서로 추가해준다.
        if (!n1.neighbor.contains(n2)) {
            n1.neighbor.add(n2);
        }
        if (!n2.neighbor.contains(n1)) {
            n2.neighbor.add(n1);
        }

    }

    //dfs 탐색을 index부터 시작
    void dfs(int index){

        //시작 인덱스에 해당하는 노드를 가져온다.
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();

        //시작 노드를 스택에 추가
        stack.push(root);
        // 스택에 들어갔으니 마킹해준다.
        root.marked = true;

        //스택이 완전히 비게될 때 까지 수행
        while (!stack.isEmpty()) {
            //스택에 있는 노드를 출력한다.
            Node r = stack.pop();

            //출력한 노드와 인접한 노드를 살펴본다.
            for (Node n : r.neighbor) {
                //만약 인접한 노드에 방문을 아직 안한 상황이라면, 마킹 표시를 하고 스택에 넣는다.
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            System.out.print(r.data+" ");

        }
    }

    //재귀함수 dfs, index가 아닌 node를 받아야함
    void dfsR(Node r) {
        //null인 경우 처리
        if (r == null) {
            return;
        }
        //방문 처리 후 출력
        r.marked = true;
        System.out.print(r.data+" ");

        for (Node n : r.neighbor) {
            if (n.marked == false) {
                dfsR(n);
            }
        }
    }

    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }



    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.marked = true;

        //큐가 완전히 비게될 때 까지 수행
        while (!queue.isEmpty()) {
            Node r = queue.poll();
            for (Node n : r.neighbor) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.add(n);
                }
            }
            System.out.print(r.data+" ");
        }
    }
}

public class DfsAndBfs {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
//        g.dfs(1);
        System.out.println();
//        g.dfsR(0);
//        System.out.println();
        g.bfs(1);
    }

}
