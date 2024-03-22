package com.kamal.gymunity.service;

import com.kamal.gymunity.dto.MessageDto;
import com.kamal.gymunity.dto.MessageResDto;
import com.kamal.gymunity.entities.Message;
import com.kamal.gymunity.interfaces.IMessage;

import java.util.List;

public class MessageService implements IMessage {

    @Override
    public MessageResDto findById(Integer primarykey) {
        return null;
    }

    @Override
    public MessageResDto save(MessageDto DTOreq) {
        return null;
    }

    @Override
    public MessageResDto deleteById(Integer primarykey) {
        return null;
    }

    @Override
    public MessageResDto update(MessageDto DTOreq) {
        return null;
    }

    @Override
    public List<Message> findAllMessagesWithUsers() {
        return null;
    }
}
