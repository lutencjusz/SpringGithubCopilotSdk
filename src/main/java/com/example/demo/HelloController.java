package com.example.demo;

import com.github.copilot.sdk.CopilotClient;
import com.github.copilot.sdk.events.AssistantMessageEvent;
import com.github.copilot.sdk.events.SessionUsageInfoEvent;
import com.github.copilot.sdk.json.MessageOptions;
import com.github.copilot.sdk.json.PermissionHandler;
import com.github.copilot.sdk.json.SessionConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class HelloController {

    String answer = "";
    final String MODEL = "claude-sonnet-4.5";

    @GetMapping("/")
    public String hello(@RequestParam(name = "text", defaultValue = "What is 2+2?") String text)
            throws ExecutionException, InterruptedException {
        try (var client = new CopilotClient()) {
            client.start().get();

            // Create a session
            var session = client.createSession(
                            new SessionConfig()
                                    .setOnPermissionRequest(PermissionHandler.APPROVE_ALL)
                                    .setModel(MODEL))
                    .get();

            // Handle assistant message events
            session.on(AssistantMessageEvent.class, msg -> {
                System.out.println(msg.getData().content());
            });

            // Handle session usage info events
            session.on(SessionUsageInfoEvent.class, usage -> {
                var data = usage.getData();
                System.out.println("\n--- Informacje o sesji ---");
                System.out.println("Użyty model: " + MODEL);
                System.out.println("\n--- Metryki użycia ---");
                System.out.println("Użytych tokenów: " + (int) data.currentTokens());
                System.out.println("Limit tokenów: " + (int) data.tokenLimit());
                System.out.println("Ilość komunikatów: " + (int) data.messagesLength());
                System.out.println("Długość komunikatów: " + (int) data.messagesLength());
                System.out.println("-----------------------------");
            });

            // Send a message
            var completable = session.sendAndWait(new MessageOptions().setPrompt(text));
            // and wait for completion
            answer = completable.get().getData().content();
            System.out.println("\u001B[33mOdpowiedź: " + answer + "\u001B[0m");
            System.out.println("Id interakcji: " + completable.get().getData().interactionId());
            System.out.println("Id komunikatu: " + completable.get().getData().messageId());
            System.out.println("Użyte narzędzia: " + completable.get().getData().toolRequests().toString());
        }
        return "Odpowiedź: " + answer;
    }

}
