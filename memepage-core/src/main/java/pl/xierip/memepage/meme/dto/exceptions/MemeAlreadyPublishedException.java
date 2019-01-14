package pl.xierip.memepage.meme.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MemeAlreadyPublishedException extends RuntimeException {

  public MemeAlreadyPublishedException(String id) {
    super("Meme of id \"" + id + "\" already published!", null, false, false);
  }
}
