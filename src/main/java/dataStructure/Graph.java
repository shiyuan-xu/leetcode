package dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    // 深度优先非递归算法
    void depth() {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < number; i++) {
            if (visited[i] == 0) {
                // 访问顶点并入栈
                s.add(i);
                visited[i] = 1;
                while (!s.isEmpty()) {
                    int j = s.pop();// 栈顶元素出栈
                    System.out.print(vertexs[j] + " ");
                    for (int k = 0; k < number; k++) {
                        // 栈顶元素的邻接点（未被访问的）
                        if (edges[j][k] == 1 && visited[k] == 0) {
                            // 访问此邻接点并入栈
                            s.add(k);
                            visited[k] = 1;
                        }
                    }
                }
            }
        }
    }


    // 广度优先算法
    void BFSTraverse() {
        visited = new int[number];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < number; i++) {
            if (visited[i] == 0) {
                // 访问顶点并入队
                visited[i] = 1;
                System.out.print(vertexs[i] + " ");
                queue.add(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();// 队头元素出队
                    for (int k = 0; k < number; k++) {
                        // 队头元素的邻接点（未被访问）
                        if (edges[j][k] == 1 && visited[k] == 0) {
                            // 访问此邻接点并入队
                            visited[k] = 1;
                            System.out.print(vertexs[k] + " ");
                            queue.add(k);
                        }
                    }
                }
            }
        }
    }
}
