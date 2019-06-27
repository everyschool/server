package com.uiseokschool.everyschool.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {

    private ResultCode code;
    private ErrorMessage errorMessage;
    private String message;
    private T result;

    public static <T> CommonResponse.CommonResponseBuilder<T> builder() {
        return new CommonResponse.CommonResponseBuilder();
    }

    public static class CommonResponseBuilder<T> {

        private ResultCode code;
        private ErrorMessage errorMessage;
        private String message;
        private T result;

        CommonResponseBuilder() {
            this.code = ResultCode.SUCCESS;
            this.message = ErrorMessage.COMMON_SUCCESS.getUserGuideMessage();
        }

        public CommonResponse.CommonResponseBuilder<T> code(ResultCode code) {
            this.code = code;
            return this;
        }

        public CommonResponse.CommonResponseBuilder<T> errorMessage(ErrorMessage errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public CommonResponse.CommonResponseBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public CommonResponse.CommonResponseBuilder<T> result(T result) {
            this.result = result;
            return this;
        }

        public CommonResponse<T> build() {
            return new CommonResponse(this.code, this.errorMessage, this.message, this.result);
        }

        public String toString() {
            return "CommonResponse.CommonResponseBuilder(code=" + this.code + ", errorMessage="
                + this.errorMessage + ", message=" + this.message + ", result=" + this.result + ")";
        }
    }
}