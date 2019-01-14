package pl.xierip.memepage.meme.domain;


import java.util.Date;
import java.util.Objects;
import pl.xierip.memepage.meme.dto.MemeDto;
import pl.xierip.memepage.meme.dto.NewMemeDto;

class MemeCreator {

  Meme from(MemeDto memeDto) {
    Objects.requireNonNull(memeDto);
    return Meme.builder()
        .withPlus(memeDto.getPlus())
        .withMinus(memeDto.getMinus())
        .withTitle(memeDto.getTitle())
        .withMediaURL(memeDto.getMediaURL())
        .withCreationDate(memeDto.getCreationDate())
        .withPublicationDate(memeDto.getPublicationDate().orElse(null))
        .withTags(memeDto.getTags())
        .withForAdult(memeDto.isForAdult())
        .build();
  }

  Meme from(NewMemeDto newMemeDto) {
    Objects.requireNonNull(newMemeDto);
    return Meme.builder()
        .withPlus(0)
        .withMinus(0)
        .withTitle(newMemeDto.getTitle())
        .withMediaURL(newMemeDto.getMediaURL())
        .withCreationDate(new Date())
        .withPublicationDate(null)
        .withTags(newMemeDto.getTags())
        .withForAdult(newMemeDto.isForAdult())
        .build();
  }
}
