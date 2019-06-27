package com.uiseokschool.everyschool.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.logging.LogLevel;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorMessage {

    // 공통 에러 메시지
    COMMON_SUCCESS("CM_0000", LogLevel.OFF, "정상 처리", "정상입니다.", false),
    COMMON_SYSTEM_ERROR("CM_0001", LogLevel.ERROR, "시스템 오류", "시스템 오류입니다. 잠시 후 다시 시도바랍니다.", true),
    INCORRECT_APPROACH_ERROR("CM_0002", LogLevel.WARN, "잘못된 접근", "잘못된 접근 입니다. 잠시 후 다시 시도바랍니다.",
        true);

    private final String errorCode;
    private final LogLevel error;
    private final String systemMessage;
    private final String userGuideMessage;
    private final boolean pageReload;

}
