package pl.xierip.memepage.meme.domain;

import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pl.xierip.memepage.meme.dto.MemeDto;
import pl.xierip.memepage.meme.dto.NewMemeDto;
import pl.xierip.memepage.meme.dto.exceptions.MemeAlreadyPublishedException;

public class MemeFacade {

  private MemeRepository memeRepository;
  private MemeCreator    memeCreator;

  public MemeFacade(MemeRepository memeRepository, MemeCreator memeCreator) {
    this.memeRepository = memeRepository;
    this.memeCreator = memeCreator;
  }

  public MemeDto show(String id) {
    Meme meme = memeRepository.findOneOrThrow(id);
    return meme.dto();
  }

  public void deleteById(String id) {
    memeRepository.deleteById(id);
  }

  public MemeDto publishMeme(String id) {
    Meme meme = memeRepository.findOneOrThrow(id);
    if (meme.isPublished()) {
      throw new MemeAlreadyPublishedException(id);
    }
    meme.publish();
    memeRepository.save(meme);
    return meme.dto();
  }

  public MemeDto createMeme(NewMemeDto memeDto) {
    Meme meme = this.memeCreator.from(memeDto);
    memeRepository.insert(meme);
    return meme.dto();
  }

  public Page<MemeDto> showAllByPublishedIsTrue(Pageable pageable) {
    Page<Meme> all = memeRepository.findAllByPublishedIsTrue(pageable);
    return new PageImpl<>(all.stream().map(Meme::dto).collect(Collectors.toList()), pageable, all.getTotalElements());
  }

  public Page<MemeDto> showAllByPublishedIsFalse(Pageable pageable) {
    Page<Meme> all = memeRepository.findAllByPublishedIsFalse(pageable);
    return new PageImpl<>(all.stream().map(Meme::dto).collect(Collectors.toList()), pageable, all.getTotalElements());
  }

  public Page<MemeDto> showAll(Pageable pageable) {
    Page<Meme> all = memeRepository.findAll(pageable);
    return new PageImpl<>(all.stream().map(Meme::dto).collect(Collectors.toList()), pageable, all.getTotalElements());
  }

  public void deleteAll() {
    memeRepository.deleteAll();
  }
}
