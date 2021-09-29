package it.euris.academy.teslabattery_cv.data.dto;

import java.time.Instant;
import it.euris.academy.teslabattery_cv.data.archetype.Dto;
import it.euris.academy.teslabattery_cv.data.model.AssemblyLine;
import it.euris.academy.teslabattery_cv.data.model.ProductiveCycle;
import it.euris.academy.teslabattery_cv.utils.UT;
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
  private String startDate;
  private String status;
  private String statusDateChange;
  private String endDate;
  
  @Override
  public ProductiveCycle toModel() {
    
    return ProductiveCycle.builder()
        .id(UT.toLong(id))
        .assemblyLine(new AssemblyLine(assemblyLineId))
        .startDate(Instant.parse(startDate))
        .statusDateChange(Instant.parse(statusDateChange))
        .endDate(Instant.parse(endDate))
        .build();
  }
}
