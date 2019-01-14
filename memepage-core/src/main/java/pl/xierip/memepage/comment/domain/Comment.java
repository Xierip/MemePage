package pl.xierip.memepage.comment.domain;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.xierip.memepage.comment.dto.CommentDto;

@Document
class Comment {

  @Id
  private String id;
  private String author;
  private String content;
  private String memeId;
  private int    plus;
  private int    minus;
  private Date   publicationDate;

  private Comment(String author, String content, String memeId) {
    this.author = author;
    this.content = content;
    this.memeId = memeId;
    this.publicationDate = new Date();
  }

  static CommentBuilder builder() {
    return new CommentBuilder();
  }

  public int getPlus() {
    return plus;
  }

  public int getMinus() {
    return minus;
  }

  String getId() {
    return id;
  }

  String getAuthor() {
    return author;
  }

  void setAuthor(String author) {
    this.author = author;
  }

  String getContent() {
    return content;
  }

  void setContent(String content) {
    this.content = content;
  }

  String getMemeId() {
    return memeId;
  }

  void setMemeId(String memeId) {
    this.memeId = memeId;
  }

  CommentDto dto() {
    return CommentDto.builder()
        .withId(this.id)
        .withAuthor(this.author)
        .withContent(this.content)
        .withMemeId(this.memeId)
        .withPublicationDate(this.publicationDate)
        .build();
  }

  public Date getPublicationDate() {
    return publicationDate;
  }

  public static final class CommentBuilder {

    private String id;
    private String author;
    private String content;
    private String memeId;

    private CommentBuilder() {
    }

    public static CommentBuilder aComment() {
      return new CommentBuilder();
    }

    public CommentBuilder withId(String id) {
      this.id = id;
      return this;
    }

    public CommentBuilder withAuthor(String author) {
      this.author = author;
      return this;
    }

    public CommentBuilder withContent(String content) {
      this.content = content;
      return this;
    }

    public CommentBuilder withMemeId(String memeId) {
      this.memeId = memeId;
      return this;
    }

    public Comment build() {
      Comment comment = new Comment(author, content, memeId);
      return comment;
    }
  }
}
