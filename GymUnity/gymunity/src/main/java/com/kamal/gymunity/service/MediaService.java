package com.kamal.gymunity.service;

import com.kamal.gymunity.dto.MediaDto;
import com.kamal.gymunity.dto.MediaResDto;
import com.kamal.gymunity.dto.PostResDto;
import com.kamal.gymunity.entities.Media;
import com.kamal.gymunity.entities.Post;
import com.kamal.gymunity.exception.ResourceNotFoundException;
import com.kamal.gymunity.interfaces.IMedia;
import com.kamal.gymunity.repositories.MediaRepository;
import com.kamal.gymunity.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MediaService implements IMedia {

    private final MediaRepository mediaRepository;
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public MediaService(MediaRepository mediaRepository, PostRepository postRepository, ModelMapper modelMapper) {
        this.mediaRepository = mediaRepository;
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MediaResDto findById(Integer primarykey) {
        Media media = mediaRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("Media not found with id: " + primarykey));
        return modelMapper.map(media, MediaResDto.class);
    }

    @Override
    public MediaResDto save(MediaDto DTOreq) {
        Media media = modelMapper.map(DTOreq, Media.class);
        mediaRepository.save(media);
        return modelMapper.map(media, MediaResDto.class);
    }

    @Override
    public MediaResDto deleteById(Integer primarykey) {
        Media media = mediaRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("Media not found with id: " + primarykey));
        mediaRepository.deleteById(primarykey);
        return modelMapper.map(media, MediaResDto.class);
    }

    @Override
    public MediaResDto update(MediaDto DTOreq) {
        Media media = mediaRepository.findById(DTOreq.getPostId())
                .orElseThrow(() -> new ResourceNotFoundException("Media not found with id: " + DTOreq.getPostId()));

        media.setUrl(DTOreq.getUrl());

        media = mediaRepository.save(media);
        return modelMapper.map(media, MediaResDto.class);
    }

    @Override
    public List<MediaResDto> findByPostId(Integer postId) {
        List<Media> mediaList = mediaRepository.findByPostId(postId);
        return mediaList.stream()
                .map(media -> modelMapper.map(media, MediaResDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaResDto> getall() {
     List<Media> mediaList = mediaRepository.findAll();
        return mediaList.stream()
                .map(media -> modelMapper.map(media, MediaResDto.class))
                .collect(Collectors.toList());
    }
}
