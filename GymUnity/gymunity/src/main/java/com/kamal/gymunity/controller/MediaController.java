package com.kamal.gymunity.controller;

import com.kamal.gymunity.dto.MediaDto;
import com.kamal.gymunity.dto.MediaResDto;
import com.kamal.gymunity.interfaces.IMedia;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
@RequiredArgsConstructor
public class MediaController {

    private final IMedia mediaService;

    @GetMapping("/{id}")
    public ResponseEntity<MediaResDto> findById(@PathVariable("id") Integer id) {
        MediaResDto media = mediaService.findById(id);
        return ResponseEntity.ok(media);
    }

    @GetMapping
    public ResponseEntity<List<MediaResDto>> getAllMedia() {
        List<MediaResDto> allMedia = mediaService.getall();
        return ResponseEntity.ok(allMedia);
    }

    @PostMapping
    public ResponseEntity<MediaResDto> save(@RequestBody MediaDto DTOreq) {
        MediaResDto savedMedia = mediaService.save(DTOreq);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MediaResDto> deleteById(@PathVariable("id") Integer id) {
        MediaResDto deletedMedia = mediaService.deleteById(id);
        return ResponseEntity.ok(deletedMedia);
    }

    @PutMapping("/update")
    public ResponseEntity<MediaResDto> update(@RequestBody MediaDto DTOreq) {
        MediaResDto updatedMedia = mediaService.update(DTOreq);
        return ResponseEntity.ok(updatedMedia);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<MediaResDto>> findByPostId(@PathVariable("postId") Integer postId) {
        List<MediaResDto> mediaList = mediaService.findByPostId(postId);
        return ResponseEntity.ok(mediaList);
    }
}
