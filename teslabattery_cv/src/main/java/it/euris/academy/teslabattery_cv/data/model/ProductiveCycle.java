package it.euris.academy.teslabattery_cv.data.model;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import it.euris.academy.teslabattery_cv.data.archetype.Dto;
import it.euris.academy.teslabattery_cv.data.archetype.Model;
import it.euris.academy.teslabattery_cv.data.dto.ProductiveCycleDto;
import it.euris.academy.teslabattery_cv.enums.StatusPC;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Table(name = "productive_cycle")
@Entity
public class ProductiveCycle implements Model{
  
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @OneToOne
  @JoinColumn(name="assemblyId", nullable= false)
  private AssemblyLine  assemblyLine;
  
  @Column(name = "start_date")
  private Instant startDate;
  
  @Column(name = "status")
  private StatusPC status;
  
  @Column(name="status_date_change")
  private Instant statusDateChange;
  
  @Column(name="end_date")
  private Instant endDate;

  @Override
  public ProductiveCycleDto toDto() {
    return ProductiveCycleDto.builder()
        .id(id.toString())
    .startDate(startDate.toString())
    .statusDateChange(statusDateChange.toString())
    .endDate(endDate.toString())
    .build();
  }
}
