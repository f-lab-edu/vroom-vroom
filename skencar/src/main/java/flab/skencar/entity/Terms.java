package flab.skencar.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "terms", uniqueConstraints = {@UniqueConstraint(columnNames = {"title", "version"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Terms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;   // 약관 제목

    @Column(nullable = false)
    private String content; // 약관 내용

    @Column(name = "created_date")
    private LocalDateTime createdDate; // 생성일 (일자+시간)

    @Column(name = "mandatory_terms")
    private boolean mandatoryTerms; // 필수 약관 여부

    private int version; // 약관 버전


}
