import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class OperatorTest {

    @Test
    void flatMapMany() {
        Mono.just(3)
                .flatMap(i -> Flux.range(1, i))
                .subscribe(System.out::println);
    }

    @Test
    void concat() throws InterruptedException {
        Flux<Integer> oneToFive = Flux.range(1, 5)
                .delay(Duration.ofMillis(200));
        Flux<Integer> sixToTen = Flux.range(6, 10)
                .delay(Duration.ofMillis(400));

        Flux.concat(oneToFive, sixToTen)
                .subscribe(System.out::println);

        Thread.sleep(4000);
    }

    
}
