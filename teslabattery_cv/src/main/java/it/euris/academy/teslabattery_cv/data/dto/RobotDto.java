package it.euris.academy.teslabattery_cv.data.dto;


import it.euris.academy.teslabattery_cv.data.archetype.Dto;
import it.euris.academy.teslabattery_cv.data.archetype.Model;
import it.euris.academy.teslabattery_cv.data.model.Robot;
import it.euris.academy.teslabattery_cv.enums.Job;
import it.euris.academy.teslabattery_cv.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RobotDto implements Dto{
    private String id;
    private String job;
    private String order;
    
    @Override
    public Robot toModel() {
      return Robot.builder().id(UT.toLong(id))
          .job(Job.valueOf(job))
          .order(UT.toLong(order)).build();
          
      
    }
    
    
}
