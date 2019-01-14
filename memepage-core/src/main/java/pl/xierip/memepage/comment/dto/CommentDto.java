package pl.xierip.memepage.comment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class CommentDto {

  private String id;
  private String author;
  private String content;
  private String memeId;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private Date   publicationDate;

  private CommentDto(String id, String author, String content, String memeId, Date publicationDate) {
    this.author = author;
    this.content = content;
    this.memeId = memeId;
    this.publicationDate = publicationDate;
  }

  public static CommentDtoBuilder builder() {
    return new CommentDtoBuilder();
  }

  public String getId() {
    return id;
  }

  public String getAuthor() {
    return author;
  }

  public String getContent() {
    return content;
  }

  public String getMemeId() {
    return memeId;
  }

  public Date getPublicationDate() {
    return publicationDate;
  }

  public static final class CommentDtoBuilder {

    private String id;
    private String author;
    private String content;
    private String memeId;
    private Date   publicationDate;

    private CommentDtoBuilder() {
    }

    public static CommentDtoBuilder aCommentDto() {
      return new CommentDtoBuilder();
    }

    public CommentDtoBuilder withId(String id) {
      this.id = id;
      return this;
    }

    public CommentDtoBuilder withAuthor(String author) {
      this.author = author;
      return this;
    }

    public CommentDtoBuilder withContent(String content) {
      this.content = content;
      return this;
    }

    public CommentDtoBuilder withMemeId(String memeId) {
      this.memeId = memeId;
      return this;
    }

    public CommentDtoBuilder withPublicationDate(Date publicationDate) {
      this.publicationDate = publicationDate;
      return this;
    }

    public CommentDto build() {
      return new CommentDto(id, author, content, memeId, publicationDate);
    }
  }
}
