package pl.xierip.memepage.meme.dto;

import java.net.URL;

public class NewMemeDto {

  private String   title;
  private URL      mediaURL;
  private String[] tags;
  private boolean  forAdult;


  private NewMemeDto() {

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
}
