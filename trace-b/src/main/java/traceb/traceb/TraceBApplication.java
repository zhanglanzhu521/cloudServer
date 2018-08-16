package traceb.traceb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class TraceBApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraceBApplication.class, args);
	}


	@GetMapping("/trace-b")
	public Mono<String> trace() {
		System.out.println("===call trace-b===");

		return Mono.just("Trace");
	}




}
