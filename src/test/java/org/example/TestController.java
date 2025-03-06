package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;


@SpringBootTest
class TestController {
    @Autowired
    private OllamaChatModel ollamaChatModel;

    String prompt = "你是一个精通中文和英文的翻译大师。如果我给你英文就翻译成中文，给你中文就翻译成英文。";
    String message =
            """	
                     DeepSeek-V3 achieves a significant breakthrough in inference speed over previous models.
                     It tops the leaderboard among open-source models and rivals the most advanced closed-source models globally.	
                    """;
    /**
     * 普通对话
     */
    @Test
    void testChatModel() {

        String result = this.ollamaChatModel.call(prompt + ":" + message);
        System.out.println(result);
    }

    /**
     * 流式输出
     */
    @Test
    Flux<String> chatStreamOutput() {
         return ollamaChatModel.stream(prompt + ":" + message);
    }


}
