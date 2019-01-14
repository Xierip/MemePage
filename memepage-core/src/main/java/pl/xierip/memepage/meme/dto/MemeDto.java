package pl.xierip.memepage.meme.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.net.URL;
import java.util.Date;
import java.util.Optional;

public class MemeDto {

  private String   id;
  private String   author;
  private int      plus;
  private int      minus;
  private String   title;
  private URL      mediaURL;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private Date     creationDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  @JsonInclude(Include.NON_EMPTY)
  private Date     publicationDate;
  private String[] tags;
  private boolean  forAdult;

  private MemeDto(String id, String author, int plus, int minus, String title, URL mediaURL, Date creationDate, Date publicationDate, String[] tags,
      boolean
          forAdult) {
    this.id = id;
    this.author = author;
    this.plus = plus;
    this.minus = minus;
    this.title = title;
    this.mediaURL = mediaURL;
    this.creationDate = creationDate;
    this.publicationDate = publicationDate;
    this.tags = tags;
    this.forAdult = forAdult;
  }

  private MemeDto() {

  }

  public static MemeDtoBuilder builder() {
    return new MemeDtoBuilder();
  }

  public boolean isPublished() {
    return publicationDate != null;
  }

  public String getAuthor() {
    return author;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public Optional<Date> getPublicationDate() {
    return Optional.ofNullable(publicationDate);
  }

  public String getId() {
    return id;
  }

  public int getPlus() {
    return plus;
  }

  public int getMinus() {
    return minus;
  }

  public String getTitle() {
    return title;
  }

  public URL getMediaURL() {
    return mediaURL;
  }

  public String[] getTags() {
    return tags;
  }

  public boolean isForAdult() {
    return forAdult;
  }

  public static final class MemeDtoBuilder {

    private String   id;
    private String   author;
    private int      plus;
    private int      minus;
    private String   title;
    private URL      mediaURL;
    private Date     creationDate;
    private Date     publicationDate;
    private String[] tags;
    private boolean  forAdult;

    private MemeDtoBuilder() {
    }

    public static MemeDtoBuilder aMemeDto() {
      return new MemeDtoBuilder();
    }

    public MemeDtoBuilder withId(String id) {
      this.id = id;
      return this;
    }

    public MemeDtoBuilder withAuthor(String author) {
      this.author = author;
      return this;
    }

    public MemeDtoBuilder withPlus(int plus) {
      this.plus = plus;
      return this;
    }

    public MemeDtoBuilder withMinus(int minus) {
      this.minus = minus;
      return this;
    }

    public MemeDtoBuilder withTitle(String title) {
      this.title = title;
      return this;
    }

    public MemeDtoBuilder withMediaURL(URL mediaURL) {
      this.mediaURL = mediaURL;
      return this;
    }

    public MemeDtoBuilder withCreationDate(Date creationDate) {
      this.creationDate = creationDate;
      return this;
    }

    public MemeDtoBuilder withPublicationDate(Date publicationDate) {
      this.publicationDate = publicationDate;
      return this;
    }

    public MemeDtoBuilder withTags(String[] tags) {
      this.tags = tags;
      return this;
    }

    public MemeDtoBuilder withForAdult(boolean forAdult) {
      this.forAdult = forAdult;
      return this;
    }

    public MemeDto build() {
      return new MemeDto(id, author, plus, minus, title, mediaURL, creationDate, publicationDate, tags, forAdult);
    }
  }
}
