package com.example.myhealthblock.question.application.port.out;

import com.example.myhealthblock.question.application.port.out.dto.QuestionEnrollOutputPortRequest;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.domain.dto.QuestionDTO;
import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;


/**
 * <b> 역할: 질문 출력 포트 인터페이스 </b>
 * <p>
 * - 도메인 계층에서 어댑터 계층으로 데이터를 전달하는 인터페이스 <br>
 * - 질문 등록, 조회, 수정, 삭제 등의 기능 정의 <br>
 * </p>
 */
public interface QuestionOutputPort {

    /**
     * <b> 역할: 질문 등록 메소드 </b>
     * <p>
     * - 질문 등록에 필요한 내용을 담은 dto로 질문을 등록 <br>
     * </p>
     *
     * @param dto  질문 등록시 필요한 내용이 담긴 dto
     * @return 질문이 성공적으로 등록되면 {@code true}, 그렇지 않으면 {@code false}
     */
    boolean create(QuestionEnrollOutputPortRequest dto);

    /**
     * <b> 역할: 특정 질문 조회 메소드 </b>
     * <p>
     * - 질문 Id로 질문을 조회 <br>
     * </p>
     *
     * @param id 특정 질문 조회 시 필요한 질문 Id
     * @return 주어진 Id와 일치하는 {@link QuestionDTO} 객체, 없으면 {@code null}
     */
    QuestionDTO getQuestion(int id);

    /**
     * <b> 역할: 특정 질문 삭제 메소드 </b>
     * <p>
     * - 질문 Id로 질문을 삭제 <br>
     * </p>
     *
     * @param id 특정 질문 삭제 시 필요한 질문 Id
     * @return 성공적으로 질문이 삭제되면 {@code true}, 그렇지 않으면 {@code false}
     */
    boolean delete(int id);

    /**
     * <b> 역할: 사용자별 질문 조회 메소드 </b>
     * <p>
     * - 사용자 Id로 해당 사용자가 작성한 질문 제목 목록 조회 <br>
     * </p>
     *
     * @param userId 특정 사용자 조회 시 필요한 사용자 Id
     * @return 성공적으로 질문이 조회되면 {@link QuestionTitleDTO} 배열, 없으면 {@code null}
     */
    QuestionTitleDTO[] getQuestions(int userId);

    /**
     * <b> 역할: 카테고리별 질문 조회 메소드 </b>
     * <p>
     * - 특정 카테고리에 해당하는 질문 제목 목록 조회 <br>
     * </p>
     *
     * @param category 특정 카테고리 조회 시 필요한 카테고리
     * @return 성공적으로 질문이 조회되면 {@link QuestionTitleDTO} 배열, 없으면 {@code null}
     */
    QuestionTitleDTO[] getQuestions(Category category);

    /**
     * <b> 역할: 전체 질문 조회 메소드 </b>
     * <p>
     * - 전체 질문 제목 목록 조회 <br>
     * </p>
     *
     * @return 성공적으로 질문이 조회되면 {@link QuestionTitleDTO} 배열, 없으면 {@code null}
     */
    QuestionTitleDTO[] getQuestions();

    /**
     * <b> 역할: 질문 수정 메소드 </b>
     * <p>
     * - 질문 Id를 통해 질문에 대한 내용을 수정 <br>
     * </p>
     * @param questionId 질문 Id
     * @param title 질문 제목
     * @param symptom 질문 증상
     * @param content 질문 내용
     * @return 성공적으로 질문이 수정 {@code true}, 그렇지 않으면 {@code false}
     */
    boolean update(Integer questionId, String title, String symptom, String content);
}
