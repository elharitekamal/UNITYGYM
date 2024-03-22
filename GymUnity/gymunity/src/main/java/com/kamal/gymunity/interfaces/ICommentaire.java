package com.kamal.gymunity.interfaces;

import com.kamal.gymunity.dto.CommentaireDto;
import com.kamal.gymunity.dto.CommentaireResDto;

import java.util.List;


public interface ICommentaire extends IData<CommentaireDto, CommentaireResDto, Integer> {
    List<CommentaireResDto> findByPostId(Integer postId);

}
