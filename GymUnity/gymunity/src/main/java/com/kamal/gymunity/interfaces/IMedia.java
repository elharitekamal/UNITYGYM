package com.kamal.gymunity.interfaces;

import com.kamal.gymunity.dto.CommentaireResDto;
import com.kamal.gymunity.dto.MediaDto;
import com.kamal.gymunity.dto.MediaResDto;
import com.kamal.gymunity.entities.Media;

import java.util.List;

public interface IMedia extends IData<MediaDto, MediaResDto, Integer>{
    List<MediaResDto> findByPostId(Integer postId);
    List<MediaResDto> getall();


}
