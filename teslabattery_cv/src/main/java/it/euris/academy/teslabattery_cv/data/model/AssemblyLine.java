package it.euris.academy.teslabattery_cv.data.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import it.euris.academy.teslabattery_cv.data.archetype.Dto;
import it.euris.academy.teslabattery_cv.data.archetype.Model;
import it.euris.academy.teslabattery_cv.data.dto.AssemblyLineDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name = "assembly_line")
public class AssemblyLine implements Model{
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "time")
  private Long time;

  @OneToMany(mappedBy = "assembly_line")
  private List<Robot> robots;

  public AssemblyLine(String assemblyLineId) {
    if (assemblyLineId != null) {
      this.id = Long.parseLong(assemblyLineId);
    }
  }
    
  @Override
  public AssemblyLineDto toDto() {
    return AssemblyLineDto.builder().id(id.toString())
        .name(name).time(time.toString()).robots(robots).build();
  }
}
