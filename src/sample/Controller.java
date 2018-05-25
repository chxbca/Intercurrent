package sample;

import javafx.fxml.FXML;


public class Controller {

    @FXML
    private void useStart() {
        if (PrintRunner.isEmpty() || !PrintRunner.isAlive())
            PrintRunner.threadFactory().start();
    }

    @FXML
    private void useContinue() {
        synchronized (PrintRunner.class) {
            PrintRunner.setPause(false);
            PrintRunner.class.notify();
        }
    }

    @FXML
    private void usePause() {
        PrintRunner.setPause(true);
    }

    @FXML
    private void useEnd() {
        PrintRunner.destroy();
    }

}
