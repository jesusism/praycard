package simflow.praycard.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import simflow.praycard.service.PostsService;
import simflow.praycard.web.dto.PostsResponseDto;
import simflow.praycard.web.dto.PostsSaveRequestDto;
import simflow.praycard.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody
            PostsUpdateRequestDto requestDto) {

        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {

        return postService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postService.delete(id);
        return id;
    }
}
