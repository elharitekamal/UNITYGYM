package com.kamal.gymunity.service;

import com.kamal.gymunity.dto.PostDto;
import com.kamal.gymunity.dto.PostResDto;
import com.kamal.gymunity.entities.Post;
import com.kamal.gymunity.exception.ResourceNotFoundException;
import com.kamal.gymunity.interfaces.IPost;
import com.kamal.gymunity.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService implements IPost {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostService(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostResDto findById(Integer primarykey) {
        Post post = postRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + primarykey));
        return modelMapper.map(post, PostResDto.class);
    }

    @Override
    public PostResDto save(PostDto DTOreq) {
        Post post = modelMapper.map(DTOreq, Post.class);
        post.setDate(LocalDate.now());
        postRepository.save(post);
        return modelMapper.map(post, PostResDto.class);
    }


    @Override
    public PostResDto deleteById(Integer primarykey) {
        Post post = postRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + primarykey));
        postRepository.deleteById(primarykey);
        return modelMapper.map(post, PostResDto.class);
    }

    @Override
    public PostResDto update(PostDto DTOreq) {
        Post post = postRepository.findById(DTOreq.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + DTOreq.getId()));

        return modelMapper.map(post, PostResDto.class);
    }

    @Override
    public List<PostResDto> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> modelMapper.map(post, PostResDto.class))
                .collect(Collectors.toList());
    }
}