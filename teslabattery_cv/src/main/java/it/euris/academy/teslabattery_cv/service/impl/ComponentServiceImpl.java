package it.euris.academy.teslabattery_cv.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.teslabattery_cv.data.dto.ComponentDto;
import it.euris.academy.teslabattery_cv.data.model.Component;
import it.euris.academy.teslabattery_cv.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_cv.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_cv.repository.ComponentRepository;
import it.euris.academy.teslabattery_cv.service.ComponentService;

@Service
public class ComponentServiceImpl implements ComponentService{
  @Autowired
  private ComponentRepository componentRepository;
  
  @Override
   public List<ComponentDto> getAll(){
    return componentRepository.findAll().stream().map(curComponent -> curComponent.toDto()).collect(Collectors.toList());
  }

  @Autowired
  private EntityManager entityManager;
  
  @Override
  public ComponentDto get(Long id) {
    Optional<Component> component = componentRepository.findById(id);
    if(component.isPresent()) {
        return component.get().toDto();
    }
    return null;
  }

  @Override
  public ComponentDto add(ComponentDto componentDto) {
    if(componentDto.getId() != null) {
      throw new IdMustBeNullException();
  }
  return componentRepository.save(componentDto.toModel()).toDto();
}
  

  @Override
  public ComponentDto update(ComponentDto componentDto) {
    if(componentDto.getId() == null) {
      throw new IdMustNotBeNullException();
  }
  return componentRepository.save(componentDto.toModel()).toDto();
}

  @Override
  public Boolean delete(Long id) {
    componentRepository.deleteById(id);
    return componentRepository.findById(id).isEmpty();
 }
  
  @Override
  public Iterable<Component> findAll(boolean isDeleted){
     Session session = entityManager.unwrap(Session.class);
     Filter filter = session.enableFilter("deletedComponentFilter");
     filter.setParameter("isDeleted", isDeleted);
     Iterable<Component> components =  componentRepository.findAll();
     session.disableFilter("deletedComponentFilter");
     return components;
 }

}
