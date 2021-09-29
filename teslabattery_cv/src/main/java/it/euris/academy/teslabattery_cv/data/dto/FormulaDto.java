package it.euris.academy.teslabattery_cv.data.dto;

import java.util.List;
import it.euris.academy.teslabattery_cv.data.archetype.Dto;
import it.euris.academy.teslabattery_cv.data.model.Formula;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FormulaDto implements Dto{
  
  private String id;
  private List<ComponentDto> components;
  private String quantity;
  private String unit;
  
  @Override
  public Formula toModel() {
    return Formula.builder()
        .id(id == null ? null : Long.parseLong(id))
        .quantity(quantity)
        .unit(unit)
        .build();
  }
  
  
}
