package pl.xierip.memepage.comment.domain;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CommentRepository extends MongoRepository<Comment, String> {

  List<Comment> findAllByMemeId(String memeId, Sort sort);

  Page<Comment> findAllByAuthor(String author, Pageable pageable);
}
