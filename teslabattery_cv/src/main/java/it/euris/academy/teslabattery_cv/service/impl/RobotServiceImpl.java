package it.euris.academy.teslabattery_cv.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.teslabattery_cv.data.dto.RobotDto;
import it.euris.academy.teslabattery_cv.data.model.Robot;
import it.euris.academy.teslabattery_cv.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_cv.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_cv.repository.RobotRepository;
import it.euris.academy.teslabattery_cv.service.RobotService;

@Service
public class RobotServiceImpl implements RobotService{
  @Autowired
  private RobotRepository robotRepository;
  
  @Override
   public List<RobotDto> getAll(){
    return robotRepository.findAll().stream().map(curRobot -> curRobot.toDto()).collect(Collectors.toList());
  }

  @Autowired
  private EntityManager entityManager;
  
  @Override
  public RobotDto get(Long id) {
    Optional<Robot> robot = robotRepository.findById(id);
    if(robot.isPresent()) {
        return robot.get().toDto();
    }
    return null;
  }

  @Override
  public RobotDto add(RobotDto robotDto) {
    if(robotDto.getId() != null) {
      throw new IdMustBeNullException();
  }
  return robotRepository.save(robotDto.toModel()).toDto();
}
  

  @Override
  public RobotDto update(RobotDto robotDto) {
    if(robotDto.getId() == null) {
      throw new IdMustNotBeNullException();
  }
  return robotRepository.save(robotDto.toModel()).toDto();
}

  @Override
  public Boolean delete(Long id) {
    robotRepository.deleteById(id);
    return robotRepository.findById(id).isEmpty();
 }
  
  @Override
  public Iterable<Robot> findAll(boolean isDeleted){
     Session session = entityManager.unwrap(Session.class);
     Filter filter = session.enableFilter("deletedRobotFilter");
     filter.setParameter("isDeleted", isDeleted);
     Iterable<Robot> robots =  robotRepository.findAll();
     session.disableFilter("deletedRobotFilter");
     return robots;
 }

}
