package org.example.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Answer {
    private Integer cows;
    private Integer bulls;
    private String userInput;

    public String getAnswer(){
        return String.format("Найдено %d коров и %d быков.",
                getCows(), getBulls());
    }
}
