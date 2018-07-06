package io.idevfun.sample.bookapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@SpringBootApplication
public class BookApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApiApplication.class, args);
	}

  @RestController
  class Controller {

	  @Autowired
    private BookClient bookClient;

    @GetMapping("/api/book/{id}")
    public String info(@PathVariable String id) {
      return "[blog.idevfun.io: book-api] >> " + bookClient.getInfo(id);
    }
  }

	@FeignClient(name = "book-info", url = "http://localhost:8088")
	public interface BookClient {

	  @RequestMapping(method = RequestMethod.GET, path = "/book/{id}")
	  String getInfo(@PathVariable("id") String id);
  }
}
