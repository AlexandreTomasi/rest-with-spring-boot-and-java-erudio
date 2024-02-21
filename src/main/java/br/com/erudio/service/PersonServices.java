package br.com.erudio.service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper personMapper;

    public List<PersonVO> findAll() throws Exception {
        logger.info("Finding all person");
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){
        logger.info("Finding one person");
        var entity =  repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO PersonVO) {
        logger.info("Create one person");
        var entity = DozerMapper.parseObject(PersonVO, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOV2 createv2(PersonVOV2 PersonVO) {
        logger.info("Create one person v2");
        var entity = personMapper.convertVoToEntity(PersonVO);
        var vo = personMapper.convertEntityToVo(repository.save(entity));
        return vo;
    }

    public PersonVO update(PersonVO personVO) {
        logger.info("Update one person");
        var entity =  repository.findById(personVO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setAddress(personVO.getAddress());
        entity.setGender(personVO.getGender());
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {
        logger.info("Deletando one person");
        var entity =  repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        repository.delete(entity);
    }
}
