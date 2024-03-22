package com.kamal.gymunity.interfaces;


import com.kamal.gymunity.dto.MessageDto;
import com.kamal.gymunity.dto.MessageResDto;
import com.kamal.gymunity.entities.Message;

import java.util.List;

public interface IMessage extends IData<MessageDto, MessageResDto,Integer>{
    List<Message> findAllMessagesWithUsers();
}
