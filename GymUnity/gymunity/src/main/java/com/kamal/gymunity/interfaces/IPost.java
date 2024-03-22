package com.kamal.gymunity.interfaces;

import com.kamal.gymunity.dto.PostDto;
import com.kamal.gymunity.dto.PostResDto;

import java.util.List;

    public interface IPost extends IData<PostDto, PostResDto,Integer>{
    List<PostResDto> findAll();
}
