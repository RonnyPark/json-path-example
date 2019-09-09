package com.example.jsonpath;

import com.jayway.jsonpath.JsonPath;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    File jsonFile = new File("json", "steve_file.json");

	    String jsonString = new String(Files.readAllBytes(jsonFile.toPath()), StandardCharsets.UTF_8);

	    Object dataObject = JsonPath.parse(jsonString).read("$['Trigger']['IntervalType']");

	    System.out.println(dataObject.toString());
	}
}
