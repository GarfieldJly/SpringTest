package com.garfield.testyml.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @author jly
 * @describe 从application.yml中读取初始值
 */
@Component
@ConfigurationProperties(prefix="knowledge.init")
@Slf4j
public class SpeechInfoConfig {
  private List<KnowledgeTitle> knowledgeTitles = new ArrayList<>();

  public static class KnowledgeTitle{

    private String kdTitle;
    private String keyWords;
    private String question;
    private String[] kdInfos;

    public String getKdTitle() {
      return kdTitle;
    }

    public void setKdTitle(String kdTitle) {
      this.kdTitle = kdTitle;
    }

    public String getKeyWords() {
      return keyWords;
    }

    public void setKeyWords(String keyWords) {
      this.keyWords = keyWords;
    }

    public String getQuestion() {
      return question;
    }

    public void setQuestion(String question) {
      this.question = question;
    }

    public String[] getKdInfos() {
      return kdInfos;
    }

    public void setKdInfos(String[] kdInfos) {
      this.kdInfos = kdInfos;
    }

    @Override
    public String toString() {
      return "KnowledgeTitle{" +
          "kdTitle='" + kdTitle + '\'' +
          ", keyWords='" + keyWords + '\'' +
          ", question='" + question + '\'' +
          ", kdInfos=" + Arrays.toString(kdInfos) +
          '}';
    }
  }

  public List<KnowledgeTitle> getKnowledgeTitles() {
    return knowledgeTitles;
  }

  public void setKnowledgeTitles(
      List<KnowledgeTitle> knowledgeTitles) {
    this.knowledgeTitles = knowledgeTitles;
  }

  /**
   * Spring Boot中初始化资源的方式之一
   */
  @PostConstruct
  public void initSpeech(){

    if(!ObjectUtils.isEmpty(knowledgeTitles)){
      for(KnowledgeTitle knowledgeTitle : knowledgeTitles){
        log.info("knowledgeTitle is :{}",knowledgeTitle );
      }
    }

  }
}
