package com.uiseokschool.everyschool.common.config.slack;

import com.uiseokschool.everyschool.common.config.slack.model.Attachment;
import com.uiseokschool.everyschool.common.config.slack.model.SlackMessage;
import com.uiseokschool.everyschool.common.config.util.CommonUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SlackSender {

    @Autowired
    private RestTemplate restTemplate;

    public void sendMessage(Throwable e) {
        List<Attachment> attachments = new ArrayList<>();
        Attachment attachment1 = Attachment.builder()
            .title("Server IP")
            .text(CommonUtils.getServerIp())
            .build();
        Attachment attachment2 = Attachment.builder()
            .title("Message")
            .text(e.getClass().getSimpleName() + " : " + e.getMessage())
            .build();

        attachments.add(attachment1);
        attachments.add(attachment2);

        SlackMessage slackMessage = SlackMessage.builder()
            .text("모두의학교 서버에러 발생")
            .attachments(attachments)
            .build();

        restTemplate.exchange(
            "https://hooks.slack.com/services/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",
            HttpMethod.POST,
            new HttpEntity<>(slackMessage), Void.class);
    }

}
