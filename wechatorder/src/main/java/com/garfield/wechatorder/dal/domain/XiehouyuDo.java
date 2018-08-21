package com.garfield.wechatorder.dal.domain;

import javax.persistence.*;

@Table(name = "xiehouyu")
public class XiehouyuDo {
    /**
     * id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     *  出谜
     */
    private String riddle;

    /**
     * 答案
     */
    private String answer;

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
     * 获取 出谜
     *
     * @return riddle -  出谜
     */
    public String getRiddle() {
        return riddle;
    }

    /**
     * 设置 出谜
     *
     * @param riddle  出谜
     */
    public void setRiddle(String riddle) {
        this.riddle = riddle == null ? null : riddle.trim();
    }

    /**
     * 获取答案
     *
     * @return answer - 答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 设置答案
     *
     * @param answer 答案
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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