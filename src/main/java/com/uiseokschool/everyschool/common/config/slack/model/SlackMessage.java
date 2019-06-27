package com.uiseokschool.everyschool.common.config.slack.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SlackMessage {

    private String text;
    private List<Attachment> attachments;

}
