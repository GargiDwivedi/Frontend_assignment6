package com.Gargi.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.garvitrajput.model.Author;
import com.garvitrajput.model.Book;


@Component
public class AuthorService {

	 public List<Author> retrieveAuthors() {

	        String inline = "";

	        try {
	            URL url = new URL("http://localhost:8081/api/authors");
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
	            List<Author> allAuthors = objectMapper.readValue(inline, new TypeReference<List<Author>>(){});

	            return allAuthors ;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }
	
	public Author getAuthorById(int id) {
	    try {
	        URL url = new URL("http://localhost:8081/api/authors/"+id);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.connect();
	        int responsecode = conn.getResponseCode();
	        if (responsecode != 200)
	            throw new RuntimeException("HttpResponseCode: " + responsecode);
	        else {
	            Scanner sc = new Scanner(url.openStream());
	            String inline = "";
	            while (sc.hasNext()) {
	                inline += sc.nextLine();
	            }
	            sc.close();
	            JSONParser parse = new JSONParser();
	            JSONObject jsonobj = (JSONObject) parse.parse(inline);
	            String name = (String) jsonobj.get("authorname");
	            Author author = new Author();
	            author.setAuthorid(id);
	            author.setAuthorname(name);
	            return author;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}


}