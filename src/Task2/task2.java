package Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class task2 {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            return;
        }

        try {
            Path file1 = Path.of(args[0]);
            Path file2 = Path.of(args[1]);
            circle(file1,file2);


        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
        //Path file1 = Path.of("src/Task2/File1.txt");
        //Path file2 = Path.of("src/Task2/File2.txt");



    }

    public static void circle(Path path1, Path path2) throws IOException {
        List<String> strings1= Files.readAllLines(path1);
        Double[] coordinates = toDouble(strings1.get(0));

        Double x = coordinates[0];
        Double y = coordinates[1];
        Double radius = Double.parseDouble(strings1.get(1));

        List<String> strings2= Files.readAllLines(path2);
        for (int i = 0; i < strings2.size(); i++) {
            Double[] pointXY = toDouble(strings2.get(i));
            Double pointX = pointXY[0];
            Double pointY = pointXY[1];
            System.out.println(check_coordinates(x,y,radius,pointX,pointY));
        }


    }

    public static Double[] toDouble(String str){
        String[] strings = str.split(" ");
        Double[] array = new Double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        return array;
    }

    public static int check_coordinates(Double x, Double y, Double radius, Double pointX,Double pointY ) {
        Double d = Math.sqrt(Math.pow(pointX-x,2)+Math.pow(pointY-y,2));


        if (Double.compare(d,radius) == 0) return 0;
        if (Double.compare(d,radius) < 0) return 1;
        if (Double.compare(d,radius) > 0) return 2;
        return -1;
    }




}
