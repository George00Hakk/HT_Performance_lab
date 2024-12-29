package Task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class task4 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); //src/Task4/File1.txt
        String s = sc.nextLine();
        System.out.println(Void(s));
    }

    public static int Void(String s) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(s));
        int[] nums = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            nums[i] = (Integer.parseInt(lines.get(i).trim()));
        }
        Arrays.sort(nums);
        int Num = nums[nums.length/2];
        int sum = 0;
        for (int num : nums) {
            sum+=Math.abs(num-Num);
        }


        return sum;
    }




}
