import java.util.*;
public class Main {
    
    static class Temp{
        String data;

        Temp(String data){
            this.data = data;
        }

    }
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        // String[] arr = new String[n];
        // for(int i=0; i<n; ++i)  
        //     arr[i] = sc.nextLine();

        // Arrays.sort(arr);

        // for(String ss : arr)
        //     System.out.println(ss);
        List<Temp> l = new ArrayList<>();
        for(int i=0; i<n; ++i){
            String s = sc.nextLine();
            l.add(new Temp(s));
        }
        // Collections.sort(l, new Comparator<Temp>(){
        //    public int compare(Temp ob1, Temp ob2){
        //         String s1 = ob1.data;
        //         String s2 = ob2.data;
        //         int len1 = s1.length();
        //         int len2 = s2.length();

        //         if(len1 > len2 && s1.contains(s2))
        //             return -1;

        //         if(len2 > len1 && s2.contains(s1))
        //             return -1;

        //         return s1.compareTo(s2);
        //    } 
        // });

        Collections.sort(l, (ob1, ob2) -> {
            String s1 = ob1.data;
                String s2 = ob2.data;
                int len1 = s1.length();
                int len2 = s2.length();

                if(len1 > len2 && s1.contains(s2))
                    return -1;

                if(len2 > len1 && s2.contains(s1))
                    return -1;

                return s1.compareTo(s2);
        });

        for(Temp x : l)
            System.out.println(x.data);
    }
}