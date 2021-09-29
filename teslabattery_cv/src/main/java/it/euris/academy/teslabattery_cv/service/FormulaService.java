package it.euris.academy.teslabattery_cv.service;

import java.util.List;
import it.euris.academy.teslabattery_cv.data.dto.FormulaDto;
import it.euris.academy.teslabattery_cv.data.model.Formula;


public interface FormulaService {
 public List<FormulaDto> getAll();
  
  public FormulaDto get(Long id);
  
  public FormulaDto add(FormulaDto nationDto);

  public FormulaDto update(FormulaDto formulaDto);
  
  public Boolean delete(Long id);
  
  public Iterable<Formula> findAll(boolean isDeleted);
}
