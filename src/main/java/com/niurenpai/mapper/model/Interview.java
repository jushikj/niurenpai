package com.niurenpai.mapper.model;

public class Interview {
    private Long id;

    private Long niurenId;

    private String question;

    private String answer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNiurenId() {
        return niurenId;
    }

    public void setNiurenId(Long niurenId) {
        this.niurenId = niurenId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
