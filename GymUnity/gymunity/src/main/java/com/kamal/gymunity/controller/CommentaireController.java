package com.kamal.gymunity.controller;

import com.kamal.gymunity.dto.CommentaireDto;
import com.kamal.gymunity.dto.CommentaireResDto;
import com.kamal.gymunity.interfaces.ICommentaire;
import com.kamal.gymunity.service.CommentaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentaire")
@RequiredArgsConstructor
public class CommentaireController {

    private final ICommentaire commentaireService;

    @GetMapping("/{id}")
    public ResponseEntity<CommentaireResDto> findById(@PathVariable("id") Integer id) {
        CommentaireResDto commentaire = commentaireService.findById(id);
        return ResponseEntity.ok(commentaire);
    }

    @PostMapping("/save")
    public ResponseEntity<CommentaireResDto> save(@RequestBody CommentaireDto DTOreq) {
        CommentaireResDto savedCommentaire = commentaireService.save(DTOreq);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCommentaire);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentaireResDto> deleteById(@PathVariable("id") Integer id) {
        CommentaireResDto deletedCommentaire = commentaireService.deleteById(id);
        return ResponseEntity.ok(deletedCommentaire);
    }

    @PutMapping("/update")
    public ResponseEntity<CommentaireResDto> update(@RequestBody CommentaireDto DTOreq) {
        CommentaireResDto updatedCommentaire = commentaireService.update(DTOreq);
        return ResponseEntity.ok(updatedCommentaire);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentaireResDto>> findByPostId(@PathVariable("postId") Integer postId) {
        List<CommentaireResDto> commentaires = commentaireService.findByPostId(postId);
        return ResponseEntity.ok(commentaires);
    }

}

