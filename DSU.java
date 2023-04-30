// Take "find cycle in graph" for as testcase

class DSU {

    int findParent(int n, int[] parent) {
        if (n == parent[n]) return parent[n];
        return parent[n] = findParent(parent[n], parent);
    }

    boolean isCyclic(int n, int edges[][]) {
        int[] parent = new int[n];

        for (int[] edge : edges) {
            int aParent = findParent(edge[0], parent);
            int bParent = findParent(edge[1], parent);

            if (aParent == bParent)
                return true;
            parent[aParent] = bParent;
        }

        return false;
    }
}

// Optimize DSU (union find) by rank based union

class DSU_optimize {
    int[] parent, rank;

    int findParent(int n) {
        if (n == parent[n]) return parent[n];
        return parent[n] = findParent(parent[n]);
    }

    boolean union(int x, int y) {
        int xset = findParent(x);
        int yset = findParent(y);

        if (xset != yset) {
            if (rank[xset] < rank[yset]) {
                parent[xset] = yset;
            } else {
                parent[yset] = xset;
            }

            if (rank[xset] == rank[yset]) {
                ++rank[xset];
                // can increase rank of any, xset/yset
            }

            return false;
        }

        return true;
    }

    boolean isCyclic(int n, int edges[][]) {
        rank = new int[n];

        parent = new int[n];
        for(int i = 0; i < n; ++i){
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if(union(edge[0], edge[1]))
                return true;
        }

        return false;
    }
}
