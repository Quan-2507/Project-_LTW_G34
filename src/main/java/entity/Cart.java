package entity;

import java.util.Collection;
import java.util.HashMap;

public class Cart {
    private HashMap<Integer, Products> data;

    public Cart(HashMap<Integer, Products> data) {
        this.data = data;
    }

    public Cart() {
        this.data = new HashMap<Integer, Products>();
    }

    public HashMap<Integer, Products> getData() {
        return data;
    }

    public void setData(HashMap<Integer, Products> data) {
        this.data = data;
    }
    public Products get(int id) {
        return data.get(id);
    }
    public int put(Products item) {
        if(data.containsKey(item.getId()))
            data.get(item.getId()).quantityUp();
        else data.put(item.getId(), item);
        return data.get(item.getId()).getQuantity();
    }
    public int put(int id, int quantity) {
        if(data.containsKey(id)) data.get(id).quantityUp(quantity);
        return data.get(id).getQuantity();
    }
    public boolean remove(int id) {
        return data.remove(id) == null;
    }
    public double total() {
        double sum =0;
        for(Products p:data.values())
            sum +=(p.getQuantity()*p.getPrice());
        return sum;
    }
    public Collection<Products> list() {
        return data.values();
    }

}

