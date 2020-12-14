package ru.weather;

import java.net.*;
import java.io.*;
import java.net.HttpURLConnection;

public class TestClass {
        public static void main(String[] args) throws Exception {
                URL url = new URL("http://api.weatherstack.com/current?access_key=fbeee5aa924dc0756704d75bcecb3e76&query=New%20York");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int response = connection.getResponseCode();
        }
}
