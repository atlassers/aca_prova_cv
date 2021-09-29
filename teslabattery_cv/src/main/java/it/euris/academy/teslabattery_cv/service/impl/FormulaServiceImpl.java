package it.euris.academy.teslabattery_cv.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.teslabattery_cv.data.dto.FormulaDto;
import it.euris.academy.teslabattery_cv.data.model.Formula;
import it.euris.academy.teslabattery_cv.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_cv.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_cv.repository.FormulaRepository;
import it.euris.academy.teslabattery_cv.service.FormulaService;

@Service
public class FormulaServiceImpl implements FormulaService{
  @Autowired
  private FormulaRepository formulaRepository;
  
  @Override
   public List<FormulaDto> getAll(){
    return formulaRepository.findAll().stream().map(curFormula -> curFormula.toDto()).collect(Collectors.toList());
  }

  @Autowired
  private EntityManager entityManager;
  
  @Override
  public FormulaDto get(Long id) {
    Optional<Formula> formula = formulaRepository.findById(id);
    if(formula.isPresent()) {
        return formula.get().toDto();
    }
    return null;
  }

  @Override
  public FormulaDto add(FormulaDto formulaDto) {
    if(formulaDto.getId() != null) {
      throw new IdMustBeNullException();
  }
  return formulaRepository.save(formulaDto.toModel()).toDto();
}
  

  @Override
  public FormulaDto update(FormulaDto formulaDto) {
    if(formulaDto.getId() == null) {
      throw new IdMustNotBeNullException();
  }
  return formulaRepository.save(formulaDto.toModel()).toDto();
}

  @Override
  public Boolean delete(Long id) {
    formulaRepository.deleteById(id);
    return formulaRepository.findById(id).isEmpty();
 }
  
  @Override
  public Iterable<Formula> findAll(boolean isDeleted){
     Session session = entityManager.unwrap(Session.class);
     Filter filter = session.enableFilter("deletedFormulaFilter");
     filter.setParameter("isDeleted", isDeleted);
     Iterable<Formula> formulas =  formulaRepository.findAll();
     session.disableFilter("deletedFormulaFilter");
     return formulas;
 }
}
