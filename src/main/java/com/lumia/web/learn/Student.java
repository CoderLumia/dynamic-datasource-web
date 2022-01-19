package com.lumia.web.learn;

public class Student {

    private String name;

    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(this.name + "被回收了");
    }


    public static int eratosthenes(int n) {
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = i * i; j < n; j += i) {
                        isPrime[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int eratosthenes = eratosthenes(100);
        System.out.println(eratosthenes);
    }
}
