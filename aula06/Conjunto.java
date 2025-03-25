package aula06;

import java.util.ArrayList;
import java.util.List;

public class Conjunto {
    private List<Integer> conjunto = new ArrayList<>();

    public Conjunto() {}

    public boolean insert(int num) {
        if (conjunto.contains(num)) {
            return false;
        }
        conjunto.add(num);
        return true;
    }

    public boolean contains(int num) {
        return conjunto.contains(num);
    }

    public boolean remove(int num) {
        return conjunto.remove(Integer.valueOf(num));
    }

    public void empty() {
        while (!conjunto.isEmpty()) {
            conjunto.remove(0);
        }
    }

    public int size() {
        return conjunto.size();
    }

    public boolean isEmpty() {
        return conjunto.isEmpty();
    }

    public Conjunto combine(Conjunto add) {
        Conjunto uniao = new Conjunto();
        uniao.conjunto.addAll(this.conjunto);
        for (int num : add.conjunto) {
            if (!uniao.contains(num)) {
                uniao.conjunto.add(num);
            }
        }
        return uniao;
    }

    public Conjunto subtract(Conjunto diff) {
        Conjunto diferenca = new Conjunto();
        for (int num : this.conjunto) {
            if (!diff.contains(num)) {
                diferenca.conjunto.add(num);
            }
        }
        return diferenca;
    }

    public Conjunto intersect(Conjunto inter) {
        Conjunto intersecao = new Conjunto();
        for (int num : this.conjunto) {
            if (inter.contains(num)) {
                intersecao.conjunto.add(num);
            }
        }
        return intersecao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : conjunto) {
            sb.append(integer).append(" ");
        }
        return sb.toString().trim();
    }

}