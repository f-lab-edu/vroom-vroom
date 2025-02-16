package flab.skencar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TermsDto {
    private String title;
    private String content;
    private boolean mandatoryTerms;
    private int version;

}
