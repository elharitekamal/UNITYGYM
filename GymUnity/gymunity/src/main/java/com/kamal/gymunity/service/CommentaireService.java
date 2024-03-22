package com.kamal.gymunity.service;

import com.kamal.gymunity.dto.CommentaireDto;
import com.kamal.gymunity.dto.CommentaireResDto;
import com.kamal.gymunity.dto.MessageDto;
import com.kamal.gymunity.dto.MessageResDto;
import com.kamal.gymunity.entities.Commentaire;
import com.kamal.gymunity.exception.ResourceNotFoundException;
import com.kamal.gymunity.interfaces.ICommentaire;
import com.kamal.gymunity.repositories.CommentaireRepository;
import com.kamal.gymunity.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentaireService implements ICommentaire {

    private final CommentaireRepository commentaireRepository;
    private final ModelMapper modelMapper;

    public CommentaireService(CommentaireRepository commentaireRepository, ModelMapper modelMapper) {
        this.commentaireRepository = commentaireRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentaireResDto findById(Integer primarykey) {
        Optional<Commentaire> optionalCommentaire = commentaireRepository.findById(primarykey);
        Commentaire commentaire = optionalCommentaire.orElseThrow(() -> new ResourceNotFoundException("Commentaire not found with id: " + primarykey));
        return modelMapper.map(commentaire, CommentaireResDto.class);
    }

    @Override
    public CommentaireResDto save(CommentaireDto DTOreq) {
        Commentaire commentaire = modelMapper.map(DTOreq, Commentaire.class);
        commentaire = commentaireRepository.save(commentaire);
        return modelMapper.map(commentaire, CommentaireResDto.class);
    }

    @Override
    public CommentaireResDto deleteById(Integer primarykey) {
        Optional<Commentaire> optionalCommentaire = commentaireRepository.findById(primarykey);
        Commentaire commentaire = optionalCommentaire.orElseThrow(() -> new ResourceNotFoundException("Commentaire not found with id: " + primarykey));
        commentaireRepository.deleteById(primarykey);
        return modelMapper.map(commentaire, CommentaireResDto.class);
    }

    @Override
    public CommentaireResDto update(CommentaireDto DTOreq) {
        Optional<Commentaire> optionalCommentaire = commentaireRepository.findById(DTOreq.getId());
        Commentaire commentaire = optionalCommentaire.orElseThrow(() -> new ResourceNotFoundException("Commentaire not found with id: " + DTOreq.getId()));

        // Update commentaire properties based on DTOreq
        // For example:
        commentaire.setContenu(DTOreq.getContenu());

        commentaire = commentaireRepository.save(commentaire);
        return modelMapper.map(commentaire, CommentaireResDto.class);
    }


    @Override
    public List<CommentaireResDto> findByPostId(Integer postId) {
        List<Commentaire> commentaires = commentaireRepository.findByPostId(postId);
        return commentaires.stream()
                .map(commentaire -> modelMapper.map(commentaire, CommentaireResDto.class))
                .collect(Collectors.toList());    }
}
