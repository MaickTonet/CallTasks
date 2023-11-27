package br.com.calltasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author Maick Tonet e Eduardo Ghiel
 * @version 1.0
 * @since 2023-11-12
 */

@EntityScan(basePackages = "br.com.calltasks.model")
@SpringBootApplication
public class CalltasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalltasksApplication.class, args);
	}

}
