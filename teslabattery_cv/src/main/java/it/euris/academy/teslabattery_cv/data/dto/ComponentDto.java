package it.euris.academy.teslabattery_cv.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_cv.data.archetype.Dto;
import it.euris.academy.teslabattery_cv.data.archetype.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ComponentDto implements Dto {

  private String id;
  private String element;
  private String dangerType;
  
  @JsonIgnore
  private String formulaId;
  
  @Override
  public Model toModel() {
    // TODO Auto-generated method stub
    return null;
  }

}
