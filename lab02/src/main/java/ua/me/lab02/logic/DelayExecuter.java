package ua.me.lab02.logic;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DelayExecuter {
    //
    // Source:
    // https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ScheduledExecutorService.html
    //
    // To use this class you must give valid link for stage/scene object
    // AND
    // Make sure that program executes in the main javafx thread, not primary
    //
    // Connects to javafx thread --> Platform.runLater(() -> //javafx task)

    /**
     *
     * @param threadAmount Number of threads for this schedule executer
     * @param task Runnable task, which will execute after %delaySeconds% amount of time
     * @param delaySeconds delay time for the execution
     *
     * To make Runnable Task do:
     *
     *         Runnable taskClose = () -> Platform.runLater(() -> {
     *             //code javafx
     *         });
     */
    public static void executeAfterDelay(
            int threadAmount,
            Runnable task,
            int delaySeconds) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(threadAmount);

        executor.schedule(task, delaySeconds, TimeUnit.SECONDS);
        executor.shutdown();
    }

    /**
     * This method closes stage after %delaySeconds% of time.
     * @param threadAmount Number of threads for this schedule executer
     * @param delaySeconds delay time for the execution
     * @param stage stage object on which the task is being performed
     *
     * Task is already initialized in this method. He forces stage to close.
     */
    public static void closeStageAfterDelay(
            int threadAmount,
            int delaySeconds,
            Stage stage) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(threadAmount);

        Runnable taskClose = () -> Platform.runLater(() -> {
            stage.close();
        });

        executor.schedule(taskClose, delaySeconds, TimeUnit.SECONDS);
        executor.shutdown();

    }
}
