package flab.skencar.controller;

import flab.skencar.dto.TermsDto;
import flab.skencar.service.TermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/terms")
public class TermsController {

    private final TermsService termsService;

    @Autowired
    public TermsController(TermsService termsService) {
        this.termsService = termsService;
    }

    /**
     * GET /api/v1/terms
     * 모든 약관 조회
     * @return
     */
    @GetMapping
    public ResponseEntity<List<TermsDto>> getTerms() {
        return ResponseEntity.ok(termsService.getAllTerms());
    }

    /**
     * POST /api/v1/terms
     * 약관 생성
     * @param termsDto
     * @return
     */
    @PostMapping
    public ResponseEntity<TermsDto> createTerms(@RequestBody TermsDto termsDto) {
        return ResponseEntity.ok(termsService.createTerms(termsDto));
    }
}
