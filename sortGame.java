import java.util.*;
public class Main {
    static class Salary{
        String name;
        int sal;

        Salary(String name, int sal){
            this.name = name;
            this.sal = sal;
        }
    }
    public static void main(String args[]) {
        // Your Code Here

        Scanner sc= new Scanner(System.in);
        int minSal = sc.nextInt();

        List<Salary> l = new ArrayList<>();
        
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; ++i){
            String[] s = sc.nextLine().split(" ");
            int s1 = Integer.valueOf(s[1]);

            if(s1 >= minSal)
                l.add(new Salary(s[0], s1));
        }

        Collections.sort(l, new Comparator<Salary>(){
            public int compare(Salary ob1, Salary ob2){
                if(ob1.sal > ob2.sal)
                    return -1;
                if(ob1.sal == ob2.sal)
                    return ob1.name.compareTo(ob2.name);
                
                    return 1;
            }
        });

        for(Salary x : l)
            System.out.println(x.name + " " + x.sal);
    }
}

// Using Comaparale
/*
import java.util.*;
public class Main implements Comparable<Main>{
	String name;
        int sal;

    Main(String name, int sal){
        this.name = name;
        this.sal = sal;
    }

	@Override
	public int compareTo(Main ob1){
		if(this.sal > ob1.sal)
			return -1;
		if(this.sal == ob1.sal)
			return this.name.compareTo(ob1.name);
		
			return 1;
	}
    public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
        int minSal = sc.nextInt();

        List<Main> l = new ArrayList<>();
        
        int n = sc.nextInt();
        sc.nextLine();
        
        for(int i=0; i<n; ++i){
            String[] s = sc.nextLine().split(" ");
            int s1 = Integer.valueOf(s[1]);

            if(s1 >= minSal)
                l.add(new Main(s[0], s1));
        }

		Collections.sort(l);
		for(Main x : l)
            System.out.println(x.name + " " + x.sal);
	}
}
*/
