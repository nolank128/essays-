package Logger;

import java.io.FileWriter;
import java.io.IOException;

public class File implements Logger {
    private String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(String message) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(message + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}