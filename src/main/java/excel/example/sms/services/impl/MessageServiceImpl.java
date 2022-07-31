package excel.example.sms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import excel.example.sms.dto.MessageDto;
import excel.example.sms.mapper.MessageMapper;
import excel.example.sms.repositories.MessageRepository;
import excel.example.sms.services.MessageService;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	MessageMapper messageMapper;
	
	@Autowired
	MessageRepository messageRepository;

	@Override
	public boolean creationMessage(MessageDto messageDto) {
		// TODO Auto-generated method stub
		
		messageRepository.save(messageMapper.messageDtoToMessageModel(messageDto));
		return true;
		
	}

	@Override
	public boolean deleteMessage(Long id) {
		// TODO Auto-generated method stub
		
		if(messageRepository.findById(id).isPresent())
		{
			messageRepository.deleteById(id);
			return true;
		}
		return true;
	}

	@Override
	public List<MessageDto> listeMessageDtos() {
		// TODO Auto-generated method stub
		return messageMapper.listmessageModelToMessageDto(messageRepository.findAll());
	}

	@Override
	public boolean updateMessage(MessageDto messageDto) {
		// TODO Auto-generated method stub
		
		if(messageRepository.findById(messageDto.getId()).isPresent())
		{
			messageRepository.save(messageMapper.messageDtoToMessageModel(messageDto));
			return true;
		}
		return false;
	}

	@Override
	public List<MessageDto> messageContact(long user, long contact) {
		// TODO Auto-generated method stub
		return messageMapper.listmessageModelToMessageDto(messageRepository.messageContact(user, contact));
	}

}
