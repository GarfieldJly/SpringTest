package com.garfield.wechatorder.bean;

/**
 * Created by Jingly on 2018/8/21.
 */
public class IdiomBo {
    private String derivation;
    private String example;
    private String explanation;
    private String pinyin;
    private String word;
    private String abbreviation;

    public String getDerivation() {
        return derivation;
    }

    public void setDerivation(String derivation) {
        this.derivation = derivation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "IdiomBo{" +
                "derivation='" + derivation + '\'' +
                ", example='" + example + '\'' +
                ", explanation='" + explanation + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", word='" + word + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }
}