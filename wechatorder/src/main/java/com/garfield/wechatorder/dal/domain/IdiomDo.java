package com.garfield.wechatorder.dal.domain;

import javax.persistence.*;

@Table(name = "idiom")
public class IdiomDo {
    /**
     * id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 出自
     */
    private String derivation;

    /**
     * 例子
     */
    private String example;

    /**
     * 解释
     */
    private String explanation;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 单词
     */
    private String word;

    /**
     * 简写
     */
    private String abbreviation;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Long createdAt;

    /**
     * 更新时间
     */
    @Column(name = "updated_at")
    private Long updatedAt;

    /**
     * 是否删除 0:正常,1:删除
     */
    @Column(name = "is_deleted")
    private Integer isDeleted;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取出自
     *
     * @return derivation - 出自
     */
    public String getDerivation() {
        return derivation;
    }

    /**
     * 设置出自
     *
     * @param derivation 出自
     */
    public void setDerivation(String derivation) {
        this.derivation = derivation == null ? null : derivation.trim();
    }

    /**
     * 获取例子
     *
     * @return example - 例子
     */
    public String getExample() {
        return example;
    }

    /**
     * 设置例子
     *
     * @param example 例子
     */
    public void setExample(String example) {
        this.example = example == null ? null : example.trim();
    }

    /**
     * 获取解释
     *
     * @return explanation - 解释
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * 设置解释
     *
     * @param explanation 解释
     */
    public void setExplanation(String explanation) {
        this.explanation = explanation == null ? null : explanation.trim();
    }

    /**
     * 获取拼音
     *
     * @return pinyin - 拼音
     */
    public String getPinyin() {
        return pinyin;
    }

    /**
     * 设置拼音
     *
     * @param pinyin 拼音
     */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    /**
     * 获取单词
     *
     * @return word - 单词
     */
    public String getWord() {
        return word;
    }

    /**
     * 设置单词
     *
     * @param word 单词
     */
    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    /**
     * 获取简写
     *
     * @return abbreviation - 简写
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * 设置简写
     *
     * @param abbreviation 简写
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation == null ? null : abbreviation.trim();
    }

    /**
     * 获取创建时间
     *
     * @return created_at - 创建时间
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建时间
     *
     * @param createdAt 创建时间
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取更新时间
     *
     * @return updated_at - 更新时间
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 设置更新时间
     *
     * @param updatedAt 更新时间
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 获取是否删除 0:正常,1:删除
     *
     * @return is_deleted - 是否删除 0:正常,1:删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除 0:正常,1:删除
     *
     * @param isDeleted 是否删除 0:正常,1:删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}