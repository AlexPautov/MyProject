import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFirstProject {

    public static void main(String[] args) throws IOException {


        FileReader reader = new FileReader((args[1]));
        int key = Integer.parseInt(args[2]);
        StringBuilder sb = new StringBuilder();

        while(reader.ready()) {
            sb.append((char)reader.read());
        }

        Path path = Paths.get(args[1]);
        String result = path.getFileName().toString();
        String[] nameAndTxt = result.split("\\.");
        result = nameAndTxt[0] + "(" + args[0] + "d)." + nameAndTxt[1];
        result = path.toFile().toString().replaceAll(path.getFileName().toString(), result);
        System.out.println(result);


        File file = new File(result);
        if (file.createNewFile()) {
            System.out.println("Создан файл");
        } else {
            System.out.println("файл уже существует");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(result))) {
            writer.write(Decoder.decode(sb.toString(), key));
        }
    }
}
