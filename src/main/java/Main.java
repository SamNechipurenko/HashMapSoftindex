import java.util.List;

public class Main {

    public static void main(String[] args){

        OpenAddressHashTable table = new OpenAddressHashTable();
        table.put(1, new Long(4));
        table.put(17, new Long(289));
        table.put(8, new Long(4));
        table.put(4, new Long(4));
        table.put(5, new Long(4));
        table.put(2, new Long(289));
        table.put(3, new Long(4));
        table.put(13, new Long(4));
        table.put(9, new Long(4));
        System.out.println("size = " + table.size());
        System.out.println(table);
        System.out.println(table.get(1));
    }
}
