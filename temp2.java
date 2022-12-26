/** Edge class definition:
class Edge {
    public int source, destination, cost;

    public Edge(int source, int destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }
}

** Graph class definition:
class Graph {
    public int numVertices;
    public Edge[] edges;

    Graph(int numVertices, Edge[] edges) {
        this.numVertices = numVertices;
        this.edges = edges;
    }
}
*/

class Solution {
	int[] res;
	boolean[] vis;
	
    int[] getMinCosts(Graph graph) {
        int n = graph.numVertices;
		Edge[] edges = graph.edges;
		
		res = new int[n];
		Arrays.fill(res, Integer.MAX_VALUE);
		res[0] = 0;
		
		vis = new boolean[n];
		
		Map<Integer, List<Edge>> m = new HashMap<>();
		for(Edge edge: edges){
			int src = edge.source;
			List<Edge> l = m.getOrDefault(src, new ArrayList<Edge>());
			l.add(edge);
			m.put(src, l);
		}
		
		traverse(0, 0, m);
		return res;
    }
	
	void traverse(int ind, int sum, Map<Integer, List<Edge>> m){
		if(vis[ind] || !m.containsKey(ind)) return;
		
		vis[ind] = true;
		for(Edge edge: m.getOrDefault(ind, new ArrayList<>())){
			int curSum = res[edge.source] + edge.cost;
			if(curSum < res[edge.destination]) 
				res[edge.destination] = curSum;
			
			traverse(edge.destination, curSum, m);
		}
		vis[ind] = false;
	}
}