package com.example.myhealthblock.question.application.port.in;

import com.example.myhealthblock.question.application.port.in.dto.QuestionEnrollInputPortRequest;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.domain.dto.QuestionDTO;
import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;

/**
 * <b>역할: 질문 관리 입력 포트 인터페이스</b>
 * <p>
 * - 입력 어댑터 계층에서 도메인 계층으로 데이터를 전달하는 인터페이스 <br>
 * - 질문 등록, 조회, 수정, 삭제 등의 기능 정의 <br>
 * </p>
 */
public interface QuestionInputPort {

    /**
     * <b>역할: 질문 등록 요청 메소드</b>
     * <p>
     * @param dto 질문 등록에 필요한 정보를 가진 dto
     * @return 성공하면 {@code "success"}, 실패하면 {@code "fail"}
     * </p>
     */
    String enroll(QuestionEnrollInputPortRequest dto);

    /**
     * <b>역할: 특정 질문 조회 요청 메소드</b>
     * <p>
     * @param questionId 조회할 질문의 ID
     * @return 조회된 질문에 해당하는 내용을 담은 dto
     * </p>
     */
    QuestionDTO getQuestion(Integer questionId);

    /**
     * <b>역할: 특정 사용자의 질문 목록 조회 요청 메소드</b>
     * <p>
     * @param userId 조회할 사용자의 ID
     * @return 해당 사용자가 작성한 질문들의 제목 배열
     * </p>
     */
    QuestionTitleDTO[] getQuestions(int userId);

    /**
     * <b>역할: 특정 카테고리의 질문 목록 조회 요청 메소드</b>
     * <p>
     * @param category 조회할 질문들의 카테고리
     * @return 해당 카테고리에 속한 질문들의 제목 배열
     * </p>
     */
    QuestionTitleDTO[] getQuestions(Category category);

    /**
     * <b>역할: 전체 질문 목록 조회 요청 메소드</b>
     * <p>
     * @return 모든 질문들의 제목 배열
     * </p>
     */
    QuestionTitleDTO[] getQuestions();

    /**
     * <b>역할: 질문 수정 요청 메소드</b>
     * <p>
     * @param questionId 수정할 질문의 ID
     * @param title 수정할 질문의 제목
     * @param symptom 수정할 질문의 증상
     * @param content 수정할 질문의 내용
     * @return 성공하면 {@code "success"}, 실패하면 {@code "fail"}
     * </p>
     */
    String update(Integer questionId, String title, String symptom, String content);

    /**
     * <b>역할: 질문 삭제 요청 메소드</b>
     * <p>
     * @param questionId 삭제할 질문의 ID
     * @return 성공하면 {@code "success"}, 실패하면 {@code "fail"}
     * </p>
     */
    String delete(Integer questionId);
}
