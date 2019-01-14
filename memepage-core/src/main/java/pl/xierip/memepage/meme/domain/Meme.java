package pl.xierip.memepage.meme.domain;

import java.net.URL;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.xierip.memepage.meme.dto.MemeDto;

@Document
class Meme {

  @Id
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
  private boolean  published;

  private Meme(String author, int plus, int minus, String title, URL mediaURL, Date creationDate, Date publicationDate, String[] tags, boolean
      forAdult) {
    this.author = author;
    this.plus = plus;
    this.minus = minus;
    this.title = title;
    this.mediaURL = mediaURL;
    this.creationDate = creationDate;
    this.publicationDate = publicationDate;
    this.tags = tags;
    this.forAdult = forAdult;
    this.published = publicationDate != null;
  }

  static MemeBuilder builder() {
    return new MemeBuilder();
  }

  public String getAuthor() {
    return author;
  }

  String[] getTags() {
    return tags;
  }

  boolean isForAdult() {
    return forAdult;
  }

  String getId() {
    return id;
  }

  int getPlus() {
    return plus;
  }

  int getMinus() {
    return minus;
  }

  String getTitle() {
    return title;
  }

  URL getMediaURL() {
    return mediaURL;
  }

  boolean isPublished() {
    return published;
  }

  MemeDto dto() {
    return MemeDto.builder()
        .withId(this.id)
        .withPlus(this.plus)
        .withMinus(this.minus)
        .withTitle(this.title)
        .withMediaURL(this.mediaURL)
        .withCreationDate(this.creationDate)
        .withPublicationDate(this.publicationDate)
        .withTags(this.tags)
        .withForAdult(this.forAdult)
        .build();
  }

  void publish() {
    this.publicationDate = new Date();
    this.published = true;
  }

  Date getCreationDate() {
    return creationDate;
  }

  Optional<Date> getPublicationDate() {
    return Optional.ofNullable(publicationDate);
  }

  public static final class MemeBuilder {

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
    private boolean  published;

    private MemeBuilder() {
    }

    public static MemeBuilder aMeme() {
      return new MemeBuilder();
    }

    public MemeBuilder withId(String id) {
      this.id = id;
      return this;
    }

    public MemeBuilder withAuthor(String author) {
      this.author = author;
      return this;
    }

    public MemeBuilder withPlus(int plus) {
      this.plus = plus;
      return this;
    }

    public MemeBuilder withMinus(int minus) {
      this.minus = minus;
      return this;
    }

    public MemeBuilder withTitle(String title) {
      this.title = title;
      return this;
    }

    public MemeBuilder withMediaURL(URL mediaURL) {
      this.mediaURL = mediaURL;
      return this;
    }

    public MemeBuilder withCreationDate(Date creationDate) {
      this.creationDate = creationDate;
      return this;
    }

    public MemeBuilder withPublicationDate(Date publicationDate) {
      this.publicationDate = publicationDate;
      return this;
    }

    public MemeBuilder withTags(String[] tags) {
      this.tags = tags;
      return this;
    }

    public MemeBuilder withForAdult(boolean forAdult) {
      this.forAdult = forAdult;
      return this;
    }

    public MemeBuilder withPublished(boolean published) {
      this.published = published;
      return this;
    }

    public Meme build() {
      Meme meme = new Meme(author, plus, minus, title, mediaURL, creationDate, publicationDate, tags, forAdult);
      return meme;
    }
  }
}
