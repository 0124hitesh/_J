import java.util.*;
class Main{

    static class Graph{
        Map<Integer, List<Integer>> hm;
        int num;
        Graph(int num){
            this.num = num;
            hm = new HashMap<>();
        }

        void addEdge(int a, int b, boolean biDir){

            List<Integer> la = hm.getOrDefault(a, new ArrayList<>());
            la.add(b);
            hm.put(a, la);

            if(biDir){
                List<Integer> lb = hm.getOrDefault(b, new ArrayList<>());
                lb.add(a);
                hm.put(b, lb);
            }

        }

        void display(){
            for(Map.Entry<Integer, List<Integer>> x : hm.entrySet())
                System.out.println(x.getKey() + " -> " + x.getValue());
        }

        int[] degree(){
            int[] ar = new int[this.num];
            // Arrays.fill(ar, -1);

            for(List<Integer> x : hm.values())
                for(int y : x)
                    ar[y]++;

            return ar;
        }

        boolean canVisit(){

            Queue<Integer> qu = new LinkedList<>();
            
            int[] ar = degree();
            System.out.println(Arrays.toString(ar));
            for(int i=0; i<ar.length; ++i){
                if(ar[i] == 0){
                    qu.add(i);
                    System.out.println(ar[i]);
                }
            }

            if(qu.isEmpty())
                return false;

            while(!qu.isEmpty()){

                int first = qu.poll();

                List<Integer> l = hm.getOrDefault(first, new ArrayList<Integer>());
                for(int x : l){
                    // System.out.println(x);
                    ar[x]--;

                    if(ar[x] == 0)
                        qu.add(x);
                }
            }
            System.out.println(Arrays.toString(ar));
            for(int x : ar)
                if(x != 0)
                    return false;
            return true;
        }
        
        void conNodes(int x, Set<Integer> set){

            System.out.print(x + " ");
            set.add(x);
            List<Integer> l = hm.getOrDefault(x, new ArrayList<Integer>());
            for(int z : l){
                if(!set.contains(z))
                    conNodes(z, set);
            }
        }
    }

    public static void main(String...args){
        Graph gr = new Graph(5);

        // int[][] ar = {{0,1}, {1,2}, {1, 3}, {2, 4}, {3, 4}};
        int[][] ar = {{0,1}, {1,2}, {1, 3}, {2, 4}};
        for(int[] x : ar)
            gr.addEdge(x[0], x[1], false);

        gr.display();
        // System.out.println(Arrays.toString(gr.degree()));
        // System.out.println(gr.canVisit());
        // gr.conNodes(1, new HashSet<Integer>());
    }
}