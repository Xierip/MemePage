package pl.xierip.memepage.comment.dto;

public class NewCommentDto {

  private String content;
  private String memeId;

  private NewCommentDto() {
  }

  public String getContent() {
    return content;
  }

  public String getMemeId() {
    return memeId;
  }
}
