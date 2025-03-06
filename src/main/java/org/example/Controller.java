package org.example;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class Controller {
    @Autowired
    private OllamaChatModel ollamaChatModel;

    /**
     * 普通对话
     */
    @GetMapping("/chat")
    public String testChatModel(@RequestParam("message") String message) {
        return ollamaChatModel.call(message);
    }

    /**
     * 流式输出
     */
    @GetMapping("/streamChat")
    Flux<String> chatStreamOutput(@RequestParam("message") String message) {
        return ollamaChatModel.stream(message);
    }

}
