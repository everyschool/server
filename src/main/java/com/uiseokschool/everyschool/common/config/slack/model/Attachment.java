package com.uiseokschool.everyschool.common.config.slack.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Attachment {

    private String title;
    private String text;

}
