package com.gusty.ensiklopedianegaradunia3.Question;

/**
 * Created by gusty on 30/05/2017.
 */

public class Question {

    public String mQuestion [] = {
            "Bali merupakan destinasi wisata negara?",
            "Menara Piza berasal dari negara?",
            "Neraga yang di juluki matahari terbit adalah?",
            "Negara yang masih menganut sistem monarki adalah?",
            "Olah raga matador berasal dari negara?",
            "Negara dengan populasi terbesar di dunia adalah?",
            "salah satu negara kepulauan adalah?",
            "Berasalah dari negara manakah tembok berlin?",
            "Negara kincir angin sebutan untuk negara?"
    };
    private String mChoice[][] = {
            {"Jepang","Indonesia","Brazil","Itali"},
            {"Italia","Argentina","Amerika","Arab"},
            {"Kanada","Cina","Prancis","Jepang"},
            {"Inggris","India","Cina","Jepang"},
            {"Spanyol","Turki","Cina","Australia"},
            {"Cina","Indonesia","Turki","Selandia Baru"},
            {"Amerika","Cina","Selandia Baru","India"},
            {"Indonesia","India","Selandia Baru","Jerman"},
            {"Australia","Rusia","Belanda","Turki"}


    };
    private String mCorrectAnswer []=
            {"Indonesia","Italia","Jepang", "Inggris","Spayol","Cina","Selandia Baru","Jerman","Belanda"};

    public String getQuestion(int a){
        String question = mQuestion[a];
        return question;
    }
    public String getChoice1(int a) {
        String choice = mChoice[a] [0];
        return choice;
    }
    public String getChoice2(int a) {
        String choice = mChoice[a] [1];
        return choice;
    }
    public String getChoice3(int a) {
        String choice = mChoice[a] [2];
        return choice;
    }
    public String getChoice4(int a) {
        String choice = mChoice[a] [3];
        return choice;
    }
    public String getCorrectAnswer (int a){
        String answer = mCorrectAnswer[a];
        return answer;

    }
}
