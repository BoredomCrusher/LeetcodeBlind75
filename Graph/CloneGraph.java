package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// LeetCode problem 133
class CloneGraph {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node3);
        node2.neighbors.add(node1);

        node3.neighbors = node1.neighbors;
        node4.neighbors = node2.neighbors;

        // structure of the connected graph:
        // 1 __ 2
        // |....|
        // 4 __ 3

        // adjacency list of connected graph:
        // [[2,4], [1,3], [2,4], [1,3]]

        CloneGraph graph = new CloneGraph();

        Node cloned1 = graph.cloneGraph(node1);
        Node cloned2 = graph.cloneGraph(node2);
        Node cloned3 = graph.cloneGraph(node3);
        Node cloned4 = graph.cloneGraph(node4);

        System.out.println("orginal graph");
        System.out.println("[" + node1.neighbors.toString() + ", " + node2.neighbors.toString()
                + ", " + node3.neighbors.toString() + ", " +
                node4.neighbors.toString() + "]");

        System.out.println("\ndeep cloned graph");
        System.out.println("[" + cloned1.neighbors.toString() + ", " + cloned2.neighbors.toString()
                + ", " + cloned3.neighbors.toString() + ", " +
                cloned4.neighbors.toString() + "]");
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        // return iterativeSolution(node);

        return recursiveSolution(node);
    }

    // clones via DFS
    public Node recursiveSolution(Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(recursiveSolution(neighbor));
        }

        return cloneNode;
    }

    // clones via BFS
    public Node iterativeSolution(Node node) {
        if (node == null) {
            return null;
        }

        // map nodes to cloned graph
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        Queue<Node> nodesToVisit = new LinkedList<>();
        nodesToVisit.add(node);

        while (nodesToVisit.size() > 0) {
            Node currentNode = nodesToVisit.poll();
            Node clonedCurrentNode = map.get(currentNode);

            for (Node neighbor : currentNode.neighbors) {
                Node clonedNeighbor;

                if (map.containsKey(neighbor)) {
                    clonedNeighbor = map.get(neighbor);
                } else {
                    clonedNeighbor = new Node(neighbor.val);
                    map.put(neighbor, clonedNeighbor);
                    nodesToVisit.add(neighbor);
                }

                clonedCurrentNode.neighbors.add(clonedNeighbor);
            }
        }

        return map.get(node);
    }
}
