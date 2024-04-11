package ua.me.lab02.logic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Duration;
import java.time.Instant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FileMonitoring {
    private static final Logger logger = LogManager.getLogger("SecondLogger");

    /**
     *
     */
    public static void deleteFileIfOlderThan() {
        String directoryPath = "logs/";
        // отримуємо об'єкт директорії за вказаним шляхом
        File directory = new File(directoryPath);

        // перевіряємо, чи дійсно вказано директорію
        if (directory.isDirectory()) {
            // отримуємо список файлів у директорії, та переміщаємо його у масив
            File[] files = directory.listFiles();

            // перевіряємо, чи список файлів не порожній
            if (files != null) {
                for (File file : files) {
                    try {
                        // отримуємо шлях до файлу та його атрибути
                        Path filePath = file.toPath();
                        BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
                        // отримуємо час створення файлу
                        Instant creationTime = attrs.creationTime().toInstant();
                        Instant now = Instant.now();
                        // рахуємо кількість днів, що пройшли з моменту створення файлу
                        long daysDifference = Duration.between(creationTime, now).toMinutes();

                        // якщо файл старше 7 днів, видаляємо його
                        if (daysDifference > 1) {
                            Files.delete(filePath);
                            logger.info("File " + filePath + " was deleted.");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            logger.error("This file path is not a correct directory.");
        }
    }

}