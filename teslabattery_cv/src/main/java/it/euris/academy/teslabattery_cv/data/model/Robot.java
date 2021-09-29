package it.euris.academy.teslabattery_cv.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import it.euris.academy.teslabattery_cv.data.archetype.Dto;
import it.euris.academy.teslabattery_cv.data.archetype.Model;
import it.euris.academy.teslabattery_cv.data.dto.AssemblyLineDto;
import it.euris.academy.teslabattery_cv.data.dto.RobotDto;
import it.euris.academy.teslabattery_cv.enums.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name="robot")

public class Robot implements Model{
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "job")
  private Job job;
  
  @Column(name = "order")
  private Long order;

  @ManyToOne
  @JoinColumn(name="assembly_line", nullable = false)
  private AssemblyLine assemblyLine;

  @Override
  public RobotDto toDto() {
    
    return RobotDto.builder()
        .id(id.toString())
        .job(job.toString())
        .order(order.toString()).build(); 
  }
}
