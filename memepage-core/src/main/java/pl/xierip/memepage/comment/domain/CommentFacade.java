package pl.xierip.memepage.comment.domain;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pl.xierip.memepage.comment.dto.CommentDto;
import pl.xierip.memepage.comment.dto.NewCommentDto;

public class CommentFacade {

  private CommentRepository commentRepository;
  private CommentCreator    commentCreator;

  public CommentFacade(CommentRepository commentRepository, CommentCreator commentCreator) {
    this.commentRepository = commentRepository;
    this.commentCreator = commentCreator;
  }

  public List<CommentDto> showAllForMeme(String memeId, Sort sort) {
    return commentRepository.findAllByMemeId(memeId, sort).stream().map(Comment::dto).collect(Collectors.toList());
  }

  public Page<CommentDto> showAllForUser(String author, Pageable pageable) {
    Page<Comment> all = commentRepository.findAllByAuthor(author, pageable);
    return new PageImpl<>(all.stream().map(Comment::dto).collect(Collectors.toList()), pageable, all.getTotalElements());
  }

  public CommentDto createComment(NewCommentDto dto) {
    Comment comment = this.commentCreator.from(dto, "jakis_autoreu");
    this.commentRepository.insert(comment);
    return comment.dto();
  }
}
