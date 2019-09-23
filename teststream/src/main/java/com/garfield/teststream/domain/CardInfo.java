package com.garfield.teststream.domain;

import com.garfield.teststream.annotation.SensitiveInfo;
import com.garfield.teststream.constant.SensitiveType;

/**
 * @author: Jingly
 * @create: 2019-08-12 14:43
 **/

public class CardInfo {
  private String id;
  private String userId;
  private String name;

  private String certId;
  @SensitiveInfo(SensitiveType.ID_CARD)
  private String cardId;
  @SensitiveInfo(SensitiveType.BANK_CARD)
  private String bank;
  private String phone;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCertId() {
    return certId;
  }

  public void setCertId(String certId) {
    this.certId = certId;
  }

  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  public String getBank() {
    return bank;
  }

  public void setBank(String bank) {
    this.bank = bank;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

}

