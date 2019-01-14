package pl.xierip.memepage.meme.domain;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.xierip.memepage.meme.dto.exceptions.MemeNotFoundException;

@Repository
interface MemeRepository extends MongoRepository<Meme, String> {

  default Meme findOneOrThrow(String id) {
    Optional<Meme> meme = findById(id);
    if (!meme.isPresent()) {
      throw new MemeNotFoundException(id);
    }
    return meme.get();
  }

  Page<Meme> findAllByPublishedIsTrue(Pageable pageable);

  Page<Meme> findAllByPublishedIsFalse(Pageable pageable);
}
