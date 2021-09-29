package it.euris.academy.teslabattery_cv.service;

import java.util.List;
import it.euris.academy.teslabattery_cv.data.dto.ProductiveCycleDto;
import it.euris.academy.teslabattery_cv.data.model.ProductiveCycle;

public interface ProductiveCycleService {
  
  public List<ProductiveCycleDto> getAll();
  
  public ProductiveCycleDto get(Long id);
  
  public ProductiveCycleDto add(ProductiveCycleDto productiveCycleDto);

  public ProductiveCycleDto update(ProductiveCycleDto productiveCycleDto);
  
  public Boolean delete(Long id);
  
  public Iterable<ProductiveCycle> findAll(boolean isDeleted);
}
