import java.util.*;

class HM{
    public static void main(String...args){

        Map<String, Integer> hm = new HashMap<>();
        hm.put("A", 12);
        hm.put("C", 45);
        hm.put("B", 68);

        System.out.println(hm);
        System.out.println(hm.entrySet());
        System.out.println(hm.get("A") + "\n");

        System.out.println(hm.get("DD"));
        // if no key present then return default value
        System.out.println( hm.getOrDefault("D", 0) + "\n");
        hm.putIfAbsent("D", 56);

        for(Map.Entry<String, Integer> x : hm.entrySet())
            System.out.println(x + " " + x.getKey() + " " + x.getValue());

        System.out.println();

        for(var entry : hm.entrySet())
            System.out.println(entry + " " + entry.getKey() + " " + entry.getValue());

        System.out.println("\n" + hm.keySet());
        System.out.println(hm.values());
        for(int x : hm.values())
            System.out.print(x + " ");

        hm.remove("D");
        System.out.println("\n" + hm.containsKey("D"));
    }
}