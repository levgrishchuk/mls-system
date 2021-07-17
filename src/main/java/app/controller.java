package app;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import mls.Brokerage;

/**
 * Controls CRUD functionality
 */
public class controller {
    // Reading demo
    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputstream = new FileInputStream("E:\\personal_programming_projects\\York schoolwork\\S2021\\EECS2030\\A3\\src\\main\\resources\\data.json");
        JsonReader reader = new JsonReader(new InputStreamReader(inputstream));

        Gson g = new Gson();
        Brokerage brokerage = g.fromJson(reader, Brokerage.class);
        System.out.println(brokerage);
    }
}


