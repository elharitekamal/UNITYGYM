package com.kamal.gymunity.controller;


import com.kamal.gymunity.dto.PostDto;
import com.kamal.gymunity.dto.PostResDto;
import com.kamal.gymunity.interfaces.IPost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {


    private final IPost postService;


    @GetMapping("/{id}")
    public ResponseEntity<PostResDto> getPostById(@PathVariable Integer id) {
        PostResDto postResDto = postService.findById(id);
        return ResponseEntity.ok(postResDto);
    }

    @PostMapping
    public ResponseEntity<PostResDto> createPost(@RequestBody PostDto postDto) {
        PostResDto createdPost = postService.save(postDto);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostResDto> deletePost(@PathVariable Integer id) {
        PostResDto deletedPost = postService.deleteById(id);
        return ResponseEntity.ok(deletedPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResDto> updatePost(@PathVariable Integer id, @RequestBody PostDto postDto) {
        postDto.setId(id);
        PostResDto updatedPost = postService.update(postDto);
        return ResponseEntity.ok(updatedPost);
    }

    @GetMapping
    public ResponseEntity<List<PostResDto>> getAllPosts() {
        List<PostResDto> posts = postService.findAll();
        return ResponseEntity.ok(posts);
    }
}
