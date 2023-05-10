package com.Gargi.services;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.garvitrajput.model.Book;

@Component
public class BookService {

    public List<Book> retrieveBooks() {

        String inline = "";

        try {
            URL url = new URL("http://localhost:8081/api/books");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " + responsecode);

            if (responsecode != 200)
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            else {
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                System.out.println("\nJSON Response in String format");
                System.out.println(inline);
                sc.close();
            }

            ObjectMapper objectMapper = new ObjectMapper();
            List<Book> allBook = objectMapper.readValue(inline, new TypeReference<List<Book>>(){});

            return allBook;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteBook(int bookcode) {

        try {
            URL url = new URL("http://localhost:8081/api/books/"+bookcode);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.connect();
            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " + responsecode);

      

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void saveBook(Book book,String method) {

        String query_url = "http://localhost:8081/api/books";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(book);
            URL url = new URL(query_url);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod(method);
            http.setDoOutput(true);
            http.setRequestProperty("Accept", "application/json");
            http.setRequestProperty("Content-Type", "application/json");
           // byte[] out = json.getBytes(StandardCharsets.UTF_8);
            byte[] out = json.getBytes(StandardCharsets.UTF_8);
            String jsonStr = new String(out, StandardCharsets.UTF_8);
            System.out.println("JSON Input is :" + jsonStr);
            System.out.println("JSON Input is :" +out);
            OutputStream stream = http.getOutputStream();
            stream.write(out);
            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
            http.disconnect();
            System.out.println("Created JSON:"+json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
