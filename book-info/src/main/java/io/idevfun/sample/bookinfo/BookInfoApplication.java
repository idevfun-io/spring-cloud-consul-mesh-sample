package io.idevfun.sample.bookinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BookInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookInfoApplication.class, args);
	}

	@RestController
	class BookInfoController {

		@GetMapping("/book/{id}")
		public String info(@PathVariable String id) {
			return "[book-info] >> book info retrieved for " + id;
		}
	}
}
