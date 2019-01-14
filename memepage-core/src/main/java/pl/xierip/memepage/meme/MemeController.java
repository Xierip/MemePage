package pl.xierip.memepage.meme;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.xierip.memepage.meme.domain.MemeFacade;
import pl.xierip.memepage.meme.dto.MemeDto;
import pl.xierip.memepage.meme.dto.NewMemeDto;

@RestController
class MemeController {

  private MemeFacade memeFacade;

  public MemeController(MemeFacade memeFacade) {
    this.memeFacade = memeFacade;
  }

  @GetMapping("memes/{id}")
  MemeDto getMemeById(@PathVariable String id) {
    return this.memeFacade.show(id);
  }

  @PatchMapping("memes/{id}")
  MemeDto publishMeme(@PathVariable String id) {
    return this.memeFacade.publishMeme(id);
  }

  @PostMapping("memes")
  MemeDto createMeme(@RequestBody NewMemeDto meme) {
    return memeFacade.createMeme(meme);
  }

  @GetMapping("memes")
  Page<MemeDto> show(
      @RequestParam int page,
      @RequestParam int size,
      @RequestParam("sort_by") String sortBy,
      @RequestParam String direction,
      @RequestParam Optional<Boolean> published) {
    PageRequest pageRequest = PageRequest.of(page, size, new Sort(Direction.fromString(direction), sortBy));
    if (!published.isPresent()) {
      return memeFacade.showAll(pageRequest);
    } else if (published.get()) {
      return memeFacade.showAllByPublishedIsTrue(pageRequest);
    } else {
      return memeFacade.showAllByPublishedIsFalse(pageRequest);
    }
  }

  @DeleteMapping("memes")
  void delete() {
    memeFacade.deleteAll();
  }

}
