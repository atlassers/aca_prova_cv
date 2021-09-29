package it.euris.academy.teslabattery_cv.data.dto;

import it.euris.academy.teslabattery_cv.data.archetype.Dto;
import it.euris.academy.teslabattery_cv.data.model.ProductiveCycle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductiveCycleDto implements Dto{
 
  private String id;
  private String assemblyLineId;
  private String start_date;
  private String status;
  private String statusDateChange;
  private String endDate;
  
  @Override
  public ProductiveCycle toModel() {
    
    return null;
  }
}
