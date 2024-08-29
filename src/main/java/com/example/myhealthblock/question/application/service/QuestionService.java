package com.example.myhealthblock.question.application.service;

import com.example.myhealthblock.question.application.port.in.QuestionInputPort;
import com.example.myhealthblock.question.application.port.in.dto.QuestionEnrollInputPortRequest;
import com.example.myhealthblock.question.application.port.out.QuestionOutputPort;
import com.example.myhealthblock.question.application.port.out.dto.QuestionEnrollOutputPortRequest;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.domain.dto.QuestionDTO;
import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;
import com.example.myhealthblock.question.domain.mapper.QuestionMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

/**
 * <b> 역할: 질문 관리 서비스 클래스 </b>
 * <p>
 * - 입력 포트와 출력 포트, 도메인 모델과 상호작용하여 비지니스 로직을 처리 <br>
 * - 질문 등록, 조건별 조회(단건, 카테고리별, 본인 작성 질문, 다건 등), 수정, 삭제 기능 처리 <br>
 * </p>
 */
@Service
@RequiredArgsConstructor
public class QuestionService implements QuestionInputPort {
    private final QuestionOutputPort outputPort;
    private final QuestionMapper mapper = QuestionMapper.INSTANCE;

    /**
     * <b> 역할: 질문 등록 요청 메소드 </b>
     * <p>
     * - 입력 포트로 받은 dto를 출력 포트 형식의 dto로 변경 후 질문 등록 처리<br>
     * - 싱글톤 패턴을 구현<br>
     * </p>
     *
     * @param dto  질문 등록에 필요한 정보를 가진 dto
     * @return 질문이 성공적으로 등록되면 {@code success}, 그렇지 않으면 {@code fail}
     */
    @Override
    public String enroll(QuestionEnrollInputPortRequest dto) {
        QuestionEnrollOutputPortRequest request = mapper.INSTANCE.toOutputPortRequest(dto);
        boolean result = outputPort.create(request);

        return result ? "success" : "fail";
    }

    /**
     * <b> 역할: 단건 질문 조회 요청 메소드 </b>
     * <p>
     * - 출력 포트를 통해 가져온 ID의 질문 정보 조회 <br>
     * </p>
     *
     * @param questionId  질문 조회에 필요한 정보인 질문 Id
     * @return 조회된 질문 정보를 담은 QuestionDTO 객체
     */
    @Override
    public QuestionDTO getQuestion(Integer questionId) {
        return outputPort.getQuestion(questionId);
    }

    /**
     * <b> 역할: 사용자별 질문 제목 목록 조회 요청 메소드 </b>
     * <p>
     * - 출력 포트를 통해 특정 사용자가 작성한 질문 제목 조회 <br>
     * </p>
     *
     * @param userId 조회할 사용자의 Id
     * @return 조회된 질문 제목 목록를 담은 QuestionTitleDTO 배열
     */
    @Override
    public QuestionTitleDTO[] getQuestions(int userId) {
        return outputPort.getQuestions(userId);
    }

    /**
     * <b> 역할: 카테고리별 질문 제목 목록 조회 요청 메소드 </b>
     * <p>
     * - 출력 포트를 통해 특정 카테고리의 질문 제목 조회 <br>
     * </p>
     *
     * @param category 조회할 질문의 카테고리
     * @return 조회된 질문 제목 목록를 담은 QuestionTitleDTO 배열
     */
    @Override
    public QuestionTitleDTO[] getQuestions(Category category) {
        return outputPort.getQuestions(category);
    }

    /**
     * <b> 역할: 전체 질문 제목 목록 조회 요청 메소드 </b>
     * <p>
     * - 출력 포트를 통해 모든 질문 제목 조회 <br>
     * </p>
     *
     * @return 조회된 전체 질문 제목 목록를 담은 QuestionTitleDTO 배열
     */
    @Override
    public QuestionTitleDTO[] getQuestions() {
        return outputPort.getQuestions();
    }

    /**
     * <b> 역할: 질문 수정 요청 메소드 </b>
     * <p>
     * - 출력 포트를 통해 질문 정보 업데이트 작업 수행 <br>
     * - 수정 성공 여부에 따라 결과 반환 <br>
     * </p>
     *
     * @param questionId  수정할 질문의 Id
     * @param title  수정할 질문의 제목
     * @param symptom  수정할 질문의 증상
     * @param content  수정할 질문의 내용
     * @return 성공하면 {@code "success"}, 실패하면 {@code "fail"}
     */
    @Override
    public String update(Integer questionId, String title, String symptom, String content) {
        boolean result = outputPort.update(questionId, title, symptom, content);
        return result ? "success" : "fail";
    }

    /**
     * <b> 역할: 질문 삭제 요청 메소드 </b>
     * <p>
     * - 출력 포트를 통해 특정 질문 Id에 대한 삭제 작업 수행 <br>
     * - 삭제 성공 여부에 따라 결과 반환 <br>
     * </p>
     *
     * @param questionId  삭제할 질문 Id
     * @return 성공하면 {@code "success"}, 실패하면 {@code "fail"}
     */
    @Override
    public String delete(Integer questionId) {
        boolean result = outputPort.delete(questionId);
        return result ? "success" : "fail";
    }
}
