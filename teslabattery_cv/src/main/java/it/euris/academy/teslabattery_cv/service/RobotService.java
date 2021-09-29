package it.euris.academy.teslabattery_cv.service;

import java.util.List;
import it.euris.academy.teslabattery_cv.data.dto.RobotDto;
import it.euris.academy.teslabattery_cv.data.model.Robot;

public interface RobotService {
 public List<RobotDto> getAll();
  
  public RobotDto get(Long id);
  
  public RobotDto add(RobotDto robotDto);

  public RobotDto update(RobotDto robotDto);
  
  public Boolean delete(Long id);
  
  public Iterable<Robot> findAll(boolean isDeleted);
}
