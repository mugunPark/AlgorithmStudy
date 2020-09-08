/**
 * @author MKPARK
 */
public class MKHashMap<K, V> {
    private Node<K, V>[] nodes;
    public MKHashMap(int capacity) {
        nodes = new Node[capacity];
    }

    void put(K key, V val) {
        int hash = key.hashCode();
        int i = hash % nodes.length;
        if (i < 0) i = -i;
        Node<K, V> node = nodes[i];
        if (node == null) {
            nodes[i] = new Node<K, V>(key, val, hash, null);
        } else if (node.key.equals(key)){
            node.val = val;
        }else {
            Node<K, V> next = node.next;
            if(next == null) {
                nodes[i] = new Node<K, V>(key, val, hash, node);
            } else {
                while (next != null) {
                    if(next.key.equals(key)) {
                        next.val = val;
                        break;
                    } else if (next.next == null) {
                        nodes[i] = new Node<K, V>(key, val, hash, node);
                    }

                    next = next.next;
                }
            }
        }
    }

    V get(K key) {
        int hash = key.hashCode();
        int i = hash % nodes.length;
        if (i < 0) i = -i;

        Node<K, V> node = nodes[i];
        if (node == null) {
            return null;
        } else if(node.key.equals(key)) {
            return node.val;
        } else {
            while (node != null) {
                node = node.next;
                if(node == null) {
                    return null;
                } else if(node.key.equals(key)) {
                    return node.val;
                }
            }
        }
        return null;
    }

    static class Node<K, V> {
        K key;
        V val;
        int hash;
        Node<K, V> next;

        public Node(K key, V val, int hash, Node<K, V> next) {
            this.key = key;
            this.val = val;
            this.hash = hash;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MKHashMap<String, String> test  = new MKHashMap<String, String>(10);
        test.put("A", "A1");
        test.put("B", "A2");
        test.put("C", "A3");
        test.put("D", "A");
        test.put("Dsdaddasdsa", "A4");
        test.put("sdaddasdsa", "A5");
        System.err.println(test.get("A"));
        System.err.println(test.get("B"));
        System.err.println(test.get("C"));
        System.err.println(test.get("D"));
        System.err.println(test.get("Dsdaddasdsa"));
        System.err.println(test.get("sdaddasdsa"));
        System.err.println(test.get("sdaddasdsaasdasd"));
    }
}
