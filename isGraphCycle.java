import java.util.*;
public class Main{

    static class Graph{
        Map<Integer, List<Integer>> hm;
        int num;
        Graph(int num){
            this.num = num;
            hm = new HashMap<>();
        }

        void addEdge(int a, int b, boolean biDir){

            List<Integer> la = hm.getOrDefault(a, new ArrayList<>());
            // if(!la.contains(b)){
                la.add(b);
                hm.put(a, la);
            // }

            if(biDir){
                List<Integer> lb = hm.getOrDefault(b, new ArrayList<>());
                // if(!lb.contains(a)){
                    lb.add(a);
                    hm.put(b, lb);
                // }
            }

        }

        void display(){
            for(Map.Entry<Integer, List<Integer>> x : hm.entrySet())
                System.out.println(x.getKey() + " -> " + x.getValue());
        }

        boolean isCycle(int x, int parent, Set<Integer> set){

            set.add(x);
            // System.out.println("Parent = " + parent);
            
            List<Integer> l = hm.getOrDefault(x, new ArrayList<>());
            // System.out.println(x + " " + l + "\n");
            for(int xN : l){
                if(!set.contains(xN) ){
                    boolean z =  isCycle(xN, x, set);
                    if(z)
                        return true;
                }

                else if(xN != parent){
                    // System.out.println(xN );
                    return true;
                }
            }

            return false;
        }

        boolean isCycle(){
            
            Set<Integer> set = new HashSet<>();

            for(int x=0; x< num; ++x){
                if(!set.contains(x)){

                    boolean hasCycle = isCycle(x, x,set);
                    if(hasCycle)
                        return true;
                }
            }
            return false;
        }
    }

    public static void main(String...args){
		Scanner sc = new Scanner(System.in);

        Graph gr = new Graph(5);

        int[][] ar = {{2,1}, {2, 4}};
        // int[][] ar = {{1,0},{0,2},{2,1},{0,3},{3,4}};

        for(int[] x : ar)
            gr.addEdge(x[0], x[1], true);

        gr.display();
        System.out.println(gr.isCycle());
    }
}