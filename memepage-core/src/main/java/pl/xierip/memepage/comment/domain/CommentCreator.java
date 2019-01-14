package pl.xierip.memepage.comment.domain;

import pl.xierip.memepage.comment.dto.NewCommentDto;

class CommentCreator {

  Comment from(NewCommentDto newCommentDto, String author) {
    return Comment.builder()
        .withAuthor(author)
        .withContent(newCommentDto.getContent())
        .withMemeId(newCommentDto.getMemeId())
        .build();
  }
}
