package com.mcb.creditfactory.model.assessment;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CarAssessment {

    private BigDecimal value;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "assess_date")
    private LocalDate assessDate;

}
