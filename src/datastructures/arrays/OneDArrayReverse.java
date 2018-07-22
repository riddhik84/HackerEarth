package datastructures.arrays;

import java.util.Scanner;

public class OneDArrayReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr_count = sc.nextInt();
        int[] array = new int[arr_count];
        for (int i = 0; i < arr_count; i++) {
            array[i] = sc.nextInt();
        }
        for (int i = arr_count - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}
