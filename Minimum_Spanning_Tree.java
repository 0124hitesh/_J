import java.util.*;

// numVertices: 7
// numEdges: 8
// Edges: [[0, 1, 2], [0, 3, 3], [0, 6, 4], [1, 2, 3], [1, 4, 2], [3, 4, 5], [4, 5, 7], [4, 6, 6]]
// [0, 1, 2] -- [source, destination, weight]
// Minimum Cost: [0, 2, 5, 3, 4, 11, 4]

class Solution {
	int find(int in, int[] parent){
        if(parent[in] == -1) parent[in] = in;
        else if(parent[in] != in) parent[in] = find(parent[in], parent);

        return parent[in];
    }

    // using Kruskal's Algorithm
    int weightOfMST(Graph graph) {
        int n = graph.numVertices;
		Edge[] edges = graph.edges;
		
		Arrays.sort(edges, (a, b) -> a.weight - b.weight);

        int res = 0;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
		
		for(Edge edge: edges){
			int a = find(edge.source, parent);
            int b = find(edge.destination, parent);

            if(a != b){
                parent[a] = b;
                res += edge.weight;
            }
		}

        return res;
    }
}

class Edge {
    public int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    public int numVertices;
    public Edge[] edges;

    Graph(int numVertices, Edge[] edges) {
        this.numVertices = numVertices;
        this.edges = edges;
    }
}