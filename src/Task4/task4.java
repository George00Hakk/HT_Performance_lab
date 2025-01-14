package Task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class task4 {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            return;
        }

        try {
            Path file1 = Path.of(args[0]);
            System.out.println(Void(file1));


        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    public static int Void(Path s) throws IOException {
        List<String> lines = Files.readAllLines(s);
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
