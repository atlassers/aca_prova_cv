package it.euris.academy.teslabattery_cv.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import it.euris.academy.teslabattery_cv.data.archetype.Model;
import it.euris.academy.teslabattery_cv.data.dto.ComponentDto;
import it.euris.academy.teslabattery_cv.enums.Warnings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name = "component")

public class Component implements Model {
  
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "element")
  private String element;
  
  @Column(name = "danger_type")
  private Warnings dangerType; 
  
  @ManyToOne
  private Formula formula;
  
  public Component(String componentId) {
    if (componentId != null) {
      this.id = Long.parseLong(componentId);
    }
  }
  
  @Override
  public ComponentDto toDto() {
    
    return ComponentDto.builder()
        .id(id.toString())
        .element(element).build();     
  }
}
