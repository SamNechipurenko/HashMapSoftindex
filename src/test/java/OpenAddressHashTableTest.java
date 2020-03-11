import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.*;

public class OpenAddressHashTableTest {

    @Test
    public void size() {
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
        assertEquals(9, table.size());
    }

    @Test
    public void get() {
        OpenAddressHashTable table = new OpenAddressHashTable();
        table.put(1, new Long(4));
        table.put(17, new Long(289));
        table.put(8, new Long(5));
        table.put(4, new Long(678));
        table.put(5, new Long(4));
        table.put(2, new Long(289));
        table.put(3, new Long(4));
        table.put(13, new Long(75));
        table.put(9, new Long(4));
        assertEquals(new Long(75), table.get(13));
        assertEquals(new Long(4), table.get(5));
        assertEquals(new Long(289), table.get(2));
    }
}