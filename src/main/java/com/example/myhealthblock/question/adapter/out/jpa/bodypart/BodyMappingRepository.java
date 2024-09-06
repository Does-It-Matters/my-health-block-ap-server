package com.example.myhealthblock.question.adapter.out.jpa.bodypart;

import com.example.myhealthblock.question.adapter.out.jpa.question.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <b> 역할: 신체 부위 매핑 레포지토리 인터페이스 </b>
 * <p>
 * - {@link JpaRepository} 상속하여 기본적인 CRUD 제공 <br>
 * - {@link BodyPartMappingEntity} 엔티티 관리 <br>
 * </p>
 */
public interface BodyMappingRepository extends JpaRepository<BodyPartMappingEntity, Integer> {

    /**
     * <b> 역할: 특정 질문에 해당하는 신체 부위 매핑 조회 </b>
     * <p>
     *
     * @param question 조회할 {@link QuestionEntity} 객체
     * @return 주어진 질문의 {@link BodyPartMappingEntity}리스트, 없으면 빈 리스트를 반환
     */
    @Query("SELECT bpme FROM BodyPartMappingEntity bpme WHERE bpme.question = :question")
    List<BodyPartMappingEntity> findByQuestion(@Param("question") QuestionEntity question);
}
