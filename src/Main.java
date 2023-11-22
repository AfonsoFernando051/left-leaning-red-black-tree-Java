package LLRB.src;

public class Main {
    public static void main(String[] args) {
        LLRB<Integer, String> llrbTree = new LLRB<>(); // Criando uma instância da árvore
    
        // Inserindo alguns valores
        llrbTree.insert(10, "Value1");
        llrbTree.insert(5, "Value2");
        llrbTree.insert(15, "Value3");

        // llrbTree.search(10);
        // // Buscando valores
        System.out.println("Value for key 10: " + llrbTree.search(10));
        System.out.println("Value for key 7: " + llrbTree.search(7));
    }
}
