package pl.xierip.memepage.meme.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MemeConfiguration {

  final MemeRepository memeRepository;

  @Autowired
  public MemeConfiguration(MemeRepository memeRepository) {
    this.memeRepository = memeRepository;
  }

  @Bean
  MemeFacade memeFacade() {
    MemeCreator memeCreator = new MemeCreator();
    return new MemeFacade(memeRepository, memeCreator);
  }


}
