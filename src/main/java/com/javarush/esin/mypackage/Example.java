package com.javarush.esin.mypackage;

public class Example {
    public static void main(String[] args) {
        char[] cells = {'А', 'Б', 'В', 'Г', 'Д'};

        rotate(cells, 2); // сдвиг на 1 вправо

        for (int i = 0; i < cells.length; i++) {
            System.out.println((i + 1) + " - " + cells[i]);
        }
    }

    public static void rotate(char[] arr, int k) {
        int n = arr.length;
        k = k % n; // если k больше длины массива

        char[] copy = arr.clone();

        for (int i = 0; i < n; i++) {
            arr[(i + k) % n] = copy[i];
        }
    }
}
