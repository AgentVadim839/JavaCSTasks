package Services;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class FileServices {
        /**
         * Цей клас надає функціонал для операцій з файловою системою.
         *
         * Перевірити місце на диску для створення папки та файлу.
         * Перевірити наявність каталога.
         * Перевірити наявність файла.
         */


        private String fileName;
        private String filePath;

        public FileServices() {

        }

    public void writeFile(String text) {
        try (FileWriter writer = new FileWriter(filePath + fileName, true)) {
            writer.append(text + "\n");
            writer.close();
            System.out.println("Parameters were successfully written in the file " + filePath);
        } catch (IOException e) {
            System.err.println("Error on writing to file: " + e.getMessage());
        }
    }

        @Override
        public String toString() {
            return "FileServices{" +
                    "fileName='" + fileName + '\'' +
                    ", filePath='" + filePath + '\'' +
                    '}';
        }
        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }
}
