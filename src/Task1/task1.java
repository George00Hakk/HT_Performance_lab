package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(way(n, m));
    }



    public static String way(int n,int m) {
        List<Integer> array= new ArrayList<>();
        List<Integer> way= new ArrayList<>();

        array.add(1);


        int count = 1;
        while(true) {
            int[] arr = step(count,n,m);
            way.add(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                array.add(arr[i]);
            }
            if (arr[arr.length-1] == 1) break;
            count = arr[arr.length-1];

        }

        return way.stream().map(String::valueOf).collect(Collectors.joining(""));

    }

    public static int[] step(int start,int n, int m) {
        int[] array= new int[m];
        for (int i = 0; i < m; i++) {
            array[i]=start;
            if (start == n ) start = 1;
            else start++;
        }
        return array;

    }
}