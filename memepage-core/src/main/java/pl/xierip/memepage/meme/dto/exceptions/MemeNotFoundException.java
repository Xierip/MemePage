package pl.xierip.memepage.meme.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MemeNotFoundException extends RuntimeException {

  public MemeNotFoundException(String id) {
    super("No meme of id \"" + id + "\" found!", null, false, false);
  }
}
