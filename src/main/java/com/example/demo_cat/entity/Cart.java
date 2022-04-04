package com.example.demo_cat.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    private int id;
    private double total;
    private String shipName;
    private String shipPhone;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public void setMapItem(HashMap<Integer, CartItem> mapItem) {
        this.mapItem = mapItem;
    }

    private String shipAddress;

    private HashMap<Integer,CartItem> mapItem;

    public Cart() {
        mapItem=new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, CartItem> getMapItem() {
        return mapItem;
    }
    public ArrayList<CartItem> getListItem() {
        return new ArrayList<>(mapItem.values());
    }

    public void setMapITem(HashMap<Integer, CartItem> mapItem) {
        this.mapItem = mapItem;
    }
    public void addItem(Product obj,int qty){
        CartItem item =null;
        if (mapItem.containsKey(obj.getId())){
            item = mapItem.get(obj.getId());
        }else{
            item = new CartItem();
            item.setProductId(obj.getId());
            item.setProductName(obj.getName());
            item.setThumbnail(obj.getThumbnail());
            item.setUtilPRice(obj.getPrice());
        }
        item.setQty(item.getQty()+qty);
        mapItem.put(obj.getId(), item);
    }
    public void updateItem(Product obj,int qty){
        CartItem item =null;
        if (mapItem.containsKey(obj.getId())){
            item = mapItem.get(obj.getId());
        }else{
            item = new CartItem();
            item.setProductId(obj.getId());
            item.setProductName(obj.getName());
            item.setThumbnail(obj.getThumbnail());
        }
        item.setQty(qty);
        mapItem.put(obj.getId(), item);
    }
    public void removeItem(Product obj){
        mapItem.remove(obj.getId());
    }
    public void clearCart(){
        mapItem.clear();
    }
}
