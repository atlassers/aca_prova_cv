package it.euris.academy.teslabattery_cv.service;

import java.util.List;
import it.euris.academy.teslabattery_cv.data.dto.ComponentDto;
import it.euris.academy.teslabattery_cv.data.model.Component;

public interface ComponentService {
 public List<ComponentDto> getAll();
  
  public ComponentDto get(Long id);
  
  public ComponentDto add(ComponentDto componentDto);

  public ComponentDto update(ComponentDto componentDto);
  
  public Boolean delete(Long id);
  
  public Iterable<Component> findAll(boolean isDeleted);
  
}
