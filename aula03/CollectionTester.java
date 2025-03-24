package aula03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionTester {

    public static void main(String[] args) {
        // Tamanhos das coleções a serem testadas
        int[] dimensions = {1000, 5000, 10000, 20000, 40000, 100000};

        // Testar ArrayList
        System.out.println("ArrayList");
        System.out.println("Collection\tAdd (ms)\tSearch (ms)\tRemove (ms)");
        for (int dim : dimensions) {
            Collection<Integer> arrayList = new ArrayList<>();
            testCollectionPerformance(arrayList, dim);
        }

        // Testar LinkedList
        System.out.println("\nLinkedList");
        System.out.println("Collection\tAdd (ms)\tSearch (ms)\tRemove (ms)");
        for (int dim : dimensions) {
            Collection<Integer> linkedList = new LinkedList<>();
            testCollectionPerformance(linkedList, dim);
        }
    }

    private static void testCollectionPerformance(Collection<Integer> col, int dim) {
        double start, stop, delta;

        // Add
        start = System.nanoTime();
        for (int i = 0; i < dim; i++) {
            col.add(i);
        }
        stop = System.nanoTime();
        delta = (stop - start) / 1e6; // Converter para milissegundos
        double addTime = delta;

        // Search
        start = System.nanoTime();
        for (int i = 0; i < dim; i++) {
            int n = (int) (Math.random() * dim);
            if (!col.contains(n)) {
                System.out.println("Not found??? " + n);
            }
        }
        stop = System.nanoTime();
        delta = (stop - start) / 1e6; // Converter para milissegundos
        double searchTime = delta;

        // Remove
        start = System.nanoTime();
        Iterator<Integer> iterator = col.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        stop = System.nanoTime();
        delta = (stop - start) / 1e6; // Converter para milissegundos
        double removeTime = delta;

        // Exibir resultados
        System.out.printf("%d\t\t%.1f\t\t%.1f\t\t%.1f%n", dim, addTime, searchTime, removeTime);
    }
}