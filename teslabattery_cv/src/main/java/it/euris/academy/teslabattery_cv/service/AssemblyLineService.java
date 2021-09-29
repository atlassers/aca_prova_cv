package it.euris.academy.teslabattery_cv.service;

import java.util.List;
import it.euris.academy.teslabattery_cv.data.dto.AssemblyLineDto;
import it.euris.academy.teslabattery_cv.data.model.AssemblyLine;

public interface AssemblyLineService {
 public List<AssemblyLineDto> getAll();
  
  public AssemblyLineDto get(Long id);
  
  public AssemblyLineDto add(AssemblyLineDto assemblyLineDto);

  public AssemblyLineDto update(AssemblyLineDto assemblyLineDto);
  
  public Boolean delete(Long id);
  
  public Iterable<AssemblyLine> findAll(boolean isDeleted);
}
