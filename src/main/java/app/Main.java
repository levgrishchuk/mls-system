package app;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DBController test = DBController.getInstance();
        test.read();
    }
}
