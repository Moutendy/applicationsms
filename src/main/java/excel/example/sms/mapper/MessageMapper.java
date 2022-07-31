package excel.example.sms.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import excel.example.sms.dto.MessageDto;
import excel.example.sms.model.MessageModel;

@Component
public class MessageMapper {


	@Autowired
    DozerBeanMapper mapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	ContactMapper contactMapper;
	
	
	public MessageDto messageModelToMessageDto(MessageModel message)
	{
		MessageDto messagedto=mapper.map(message, MessageDto.class);
		if(message.getUserid()!=null)
		{
			messagedto.setUserid(userMapper.userToUserdto(message.getUserid()));
		}
		
		if(message.getContactid()!=null)
		{
			messagedto.setContactid(contactMapper.contactModelToContactDto(message.getContactid()));
		}
		
		return messagedto;
	}
	
	public MessageModel messageDtoToMessageModel(MessageDto messagedto)
	{
		MessageModel message=mapper.map(messagedto, MessageModel.class);
		
		if(messagedto.getUserid()!=null)
		{
			message.setUserid(userMapper.userDtoToUser(messagedto.getUserid()));
		}
		
		if(messagedto.getContactid()!=null)
		{
			message.setContactid(contactMapper.contactDtoTocontactModel(messagedto.getContactid()));
		}
		return message;
	}
	
	public List<MessageModel> listmessageDtoToMessageModel(List<MessageDto> messagedto)
	{
		List<MessageModel> messagelist=new ArrayList<MessageModel>();
		
		messagedto.forEach(m-> messagelist.add(messageDtoToMessageModel(m)));
		return messagelist;
	}
	
	
	public List<MessageDto> listmessageModelToMessageDto(List<MessageModel> messages)
	{
		List<MessageDto> messagelist=new ArrayList<MessageDto>();
		
		messages.forEach(m->messagelist.add(messageModelToMessageDto(m)) );
		
		return messagelist;
	}
	
	
}
