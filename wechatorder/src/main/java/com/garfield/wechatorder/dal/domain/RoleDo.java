package com.garfield.wechatorder.dal.domain;

public class RoleDo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.id
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.name
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.created_at
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private Long createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.updated_at
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private Long updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.is_deleted
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private Integer isDeleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.id
     *
     * @return the value of role.id
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.id
     *
     * @param id the value for role.id
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.name
     *
     * @return the value of role.name
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.name
     *
     * @param name the value for role.name
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.created_at
     *
     * @return the value of role.created_at
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.created_at
     *
     * @param createdAt the value for role.created_at
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.updated_at
     *
     * @return the value of role.updated_at
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.updated_at
     *
     * @param updatedAt the value for role.updated_at
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.is_deleted
     *
     * @return the value of role.is_deleted
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.is_deleted
     *
     * @param isDeleted the value for role.is_deleted
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}