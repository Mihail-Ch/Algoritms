package org.example;

public class Main {
    public static void main(String[] args) {

        HashMap<String, String> hashMap1 = new HashMap<>(4);

        String ret = hashMap1.put("+79001112233", "Андрей");
        ret = hashMap1.put("+79001112232", "Василий");
        ret = hashMap1.put("+79001112234", "Александр1");
        ret = hashMap1.put("+79001112235", "Александр2");
        ret = hashMap1.put("+79001112236", "Александр3");
        ret = hashMap1.put("+79001112237", "Александр4");
        ret = hashMap1.put("+79001112212", "Александр4");
        ret = hashMap1.put("+79001112213", "Александр4");
        ret = hashMap1.put("+79001112214", "Александр4");

        hashMap1.forEach(entity -> System.out.println(entity));
    }
}