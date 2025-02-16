package flab.skencar.service;

import flab.skencar.dto.TermsDto;
import flab.skencar.entity.Terms;
import flab.skencar.repository.TermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TermsService {

    private final TermsRepository termsRepository;

    @Autowired
    public TermsService(TermsRepository termsRepository) {
        this.termsRepository = termsRepository;
    }

    public List<TermsDto> getAllTerms() {
        return convertToDtoList(termsRepository.findAll());
    }

    public TermsDto createTerms(TermsDto termsDto) {
        Terms terms = convertToEntity(termsDto);
        terms.setCreatedDate(LocalDateTime.now());
        Terms savedTerms = termsRepository.save(terms);
        return convertToDto(savedTerms);
    }

    // Entity -> DTO 변환
    private TermsDto convertToDto(Terms terms) {
        return new TermsDto(
                terms.getTitle(),
                terms.getContent(),
                terms.isMandatoryTerms(),
                terms.getVersion()
        );
    }

    // DTO -> Entity 변환
    private Terms convertToEntity(TermsDto dto) {
        return new Terms(
                null,
                dto.getTitle(),
                dto.getContent(),
                null,
                dto.isMandatoryTerms(),
                dto.getVersion()
        );
    }

    // List<Entity> -> List<DTO> 변환
    private List<TermsDto> convertToDtoList(List<Terms> termsList) {
        return termsList.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
