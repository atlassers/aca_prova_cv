package it.euris.academy.teslabattery_cv.data.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import it.euris.academy.teslabattery_cv.data.archetype.Model;
import it.euris.academy.teslabattery_cv.data.dto.FormulaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name = "formula")
public class Formula implements Model{
  //join table?
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @OneToMany
  @JoinColumn(name="components")
  private List<Component> components;
  
  @OneToMany(mappedBy="formula")
  private List<AssemblyLine> assemblyLine;
  
  @Column(name="quantity")
  private String quantity;
  
  @Column(name = "unit")
  private String unit;
  
  public Formula(String formulaId) {
    if (formulaId != null) {
      this.id = Long.parseLong(formulaId);
    }
  }

  @Override
  public FormulaDto toDto() {
    return FormulaDto.builder()
        .id(id.toString())
        .quantity(quantity)
        .unit(unit)
        .build();
  }
}

