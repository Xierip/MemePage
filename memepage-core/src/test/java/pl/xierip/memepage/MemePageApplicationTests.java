package pl.xierip.memepage;

import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemePageApplicationTests {

  public static void main(String[] args) {
    Optional<String> lol = Optional.empty();
    System.out.println(lol.orElse(null));
  }

  @Test
  public void contextLoads() {
  }
}

