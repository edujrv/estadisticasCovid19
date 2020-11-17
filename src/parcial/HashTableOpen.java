package parcial;

interface HashFunc<TypeKey extends Comparable>{
    int operate(TypeKey k);
}

public class HashTableOpen<TypeKey extends Comparable, TypeValue> {
    AvlTree<HashEntry<TypeKey, TypeValue>>[] table;
     HashFunc<TypeKey> hf;


    public HashTableOpen(int size, HashFunc<TypeKey> f) {
        this.table = new AvlTree[size];
        this.hf = f;
        for (int i = 0; i < table.length; i++) {
            table[i] = new AvlTree<>();
        }
    }

    private int hashFunc(TypeKey key) {
       // return (int) key % table.length;
       return this.hf.operate(key) %  table.length;
    }

    public void insert(TypeKey clave, TypeValue value) throws Exception {
        try{
            int pos = hashFunc(clave);
        //    System.out.println(pos); // posicion de la tabla
        table[pos].insert(new HashEntry<>(clave, value));
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    public TypeValue get(TypeKey clave) throws Exception {
        int pos = hashFunc(clave);
        return table[pos].get(new HashEntry<>(clave, null)).value;
    }

    // creada por el uno
    public void printTree(TypeKey clave) throws Exception {
        int pos = hashFunc(clave);
         table[pos].printTree();
    }

    public void remove(TypeKey clave) throws Exception {
        int pos = hashFunc(clave);
        table[pos].remove(new HashEntry<>(clave, null));
    }

    private static class HashEntry<TypeKey extends Comparable, TypeValue> implements Comparable<HashEntry> {
        TypeKey key;
        TypeValue value;

        public HashEntry(TypeKey key, TypeValue value) {
            this.key = key;
            this.value = value;
        }

        public TypeKey getKey() {
            return key;
        }

        public void setKey(TypeKey key) {
            this.key = key;
        }

        public TypeValue getValue() {
            return value;
        }

        public void setValue(TypeValue value) {
            this.value = value;
        }

        @Override
        public int compareTo(HashEntry hashEntry) {
            return key.compareTo(hashEntry.getKey());
        }
    }

 /*   public static void main(String[] args) {
        HashTableOpen<Integer, String> miTable = new HashTableOpen<>(7);

        try {
            miTable.insert(0, "HOLA");
            miTable.insert(1, "CHAU");
            miTable.insert(7, "COLI");
            miTable.insert(8, "COLI2");

            System.out.println(miTable.get(1));
            miTable.remove(1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(miTable.get(1));
        } catch (Exception e) {
            System.out.println("Se removió correctamente");
        }
    }*/
}
