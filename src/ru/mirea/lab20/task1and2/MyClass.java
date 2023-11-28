package ru.mirea.lab20.task1and2;

public class MyClass<T, V, K>{
    private T t;
private V v;
private K k;

public MyClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
        }

public T getT() {
        return t;
        }

public V getV() {
        return v;
        }

public K getK() {
        return k;
        }

public void displayTypes() {
        System.out.println("Type of T: " + t.getClass().getName());
        System.out.println("Type of V: " + v.getClass().getName());
        System.out.println("Type of K: " + k.getClass().getName());
        }

@Override
public String toString() {
        return "MyClass{" +
        "t=" + t +
        ", v=" + v +
        ", k=" + k +
        '}';
        }
        }
