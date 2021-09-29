package it.euris.academy.teslabattery_cv.data.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_cv.data.archetype.Dto;
import it.euris.academy.teslabattery_cv.data.archetype.Model;
import it.euris.academy.teslabattery_cv.data.model.AssemblyLine;
import it.euris.academy.teslabattery_cv.data.model.Robot;
import it.euris.academy.teslabattery_cv.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AssemblyLineDto implements Dto{
  private String id;
  private String name;
  private String time;
  //private List<Robot> robots;
  
  @Override
  public AssemblyLine toModel() {
  //  List<RobotDto> collect = new ArrayList<RobotDto>();
//    if(robots != null) {
//      collect= robots.stream().map(curRobot -> curRobot.toDto()).collect(Collectors.toList());
//    }
    return AssemblyLine.builder()
        .id(UT.toLong(id))
        .name(name)
        .time(Long.parseLong(time))
        .build();
  }
  
}
