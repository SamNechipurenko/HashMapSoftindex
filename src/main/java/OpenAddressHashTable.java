import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OpenAddressHashTable implements HashMapSoftindex{

    Pair[] table = new Pair [10];
    int size=0;

    public OpenAddressHashTable() {
    }

    public void put(int key, Long value) {
        int i = findSlot(key);
        if (table[i] != null) { // We found our key.
            table[i].setValue(value);
            return;
        }
        if (tableIsThreeQuartersFull()) {
            resizeTableToTwiceAsLarge();
            i = findSlot(key);
        }
        table[i] = new Pair(key, value);
        size++;
    }

    public int size() {
        return size;
    }

    public Long get(int key) {
        int i = findSlot(key);
        if (table[i] != null) return table[i].getValue(); // Key is in table.
        else return null;               // Key is not in table
    }

    private int findSlot(int key) {
        int i = hash(key) % table.length;

        // Search until we either find the key, or find an empty slot.

        while ((table[i] != null) && !Objects.equals(table[i].getKey(), key)) {
            i = (i + 1) % table.length;
        }

        return i;
    }

    private int hash(Object key) {
        int hashCode = Objects.hashCode(key)
                & 0x7F_FF_FF_FF; // <- This is like abs,  hash(key) % table.length is never negative.
        return hashCode;
    }

    private boolean tableIsThreeQuartersFull() {
        return ((double) size / (double) table.length) >= 0.75;
    }

    private void resizeTableToTwiceAsLarge() {
        Pair[] old = table;

        table = new Pair[2 * old.length];
        size  = 0;

        for (Pair e : old) {
            if (e != null) put(e.getKey(), e.getValue());
        }
    }

    public Stream<Pair> entries() {
        return Arrays.stream(table).filter(Objects::nonNull);
    }

    @Override
    public String toString() {
        return entries().map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining(", ", "{", "}"));
    }
}
