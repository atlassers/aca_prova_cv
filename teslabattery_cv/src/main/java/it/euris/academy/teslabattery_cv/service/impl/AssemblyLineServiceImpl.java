package it.euris.academy.teslabattery_cv.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.teslabattery_cv.data.dto.AssemblyLineDto;
import it.euris.academy.teslabattery_cv.data.model.AssemblyLine;
import it.euris.academy.teslabattery_cv.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_cv.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_cv.repository.AssemblyLineRepository;
import it.euris.academy.teslabattery_cv.service.AssemblyLineService;

@Service
public class AssemblyLineServiceImpl implements AssemblyLineService{
  @Autowired
  private AssemblyLineRepository assemblyLineRepository;
  
  @Override
   public List<AssemblyLineDto> getAll(){
    return assemblyLineRepository.findAll().stream().map(curAssemblyLine -> curAssemblyLine.toDto()).collect(Collectors.toList());
  }

  @Autowired
  private EntityManager entityManager;
  
  @Override
  public AssemblyLineDto get(Long id) {
    Optional<AssemblyLine> assemblyLine = assemblyLineRepository.findById(id);
    if(assemblyLine.isPresent()) {
        return assemblyLine.get().toDto();
    }
    return null;
  }

  @Override
  public AssemblyLineDto add(AssemblyLineDto assemblyLineDto) {
    if(assemblyLineDto.getId() != null) {
      throw new IdMustBeNullException();
  }
  return assemblyLineRepository.save(assemblyLineDto.toModel()).toDto();
}
  

  @Override
  public AssemblyLineDto update(AssemblyLineDto assemblyLineDto) {
    if(assemblyLineDto.getId() == null) {
      throw new IdMustNotBeNullException();
  }
  return assemblyLineRepository.save(assemblyLineDto.toModel()).toDto();
}

  @Override
  public Boolean delete(Long id) {
    assemblyLineRepository.deleteById(id);
    return assemblyLineRepository.findById(id).isEmpty();
 }
  
  @Override
  public Iterable<AssemblyLine> findAll(boolean isDeleted){
     Session session = entityManager.unwrap(Session.class);
     Filter filter = session.enableFilter("deletedAssemblyLineFilter");
     filter.setParameter("isDeleted", isDeleted);
     Iterable<AssemblyLine> assemblyLines =  assemblyLineRepository.findAll();
     session.disableFilter("deletedAssemblyLineFilter");
     return assemblyLines;
 }
}
