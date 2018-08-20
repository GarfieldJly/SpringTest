package com.garfield.wechatorder.dal.domain;

public class ScenicSpotDo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot.id
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot.division_id
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private Long divisionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot.name
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot.play_time
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private Long playTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot.longitude
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private double longitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot.latitude
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private double latitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot.level
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot.created_at
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private Long createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot.updated_at
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private Long updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot.is_deleted
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    private Integer isDeleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot.id
     *
     * @return the value of scenic_spot.id
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot.id
     *
     * @param id the value for scenic_spot.id
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot.division_id
     *
     * @return the value of scenic_spot.division_id
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public Long getDivisionId() {
        return divisionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot.division_id
     *
     * @param divisionId the value for scenic_spot.division_id
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot.name
     *
     * @return the value of scenic_spot.name
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot.name
     *
     * @param name the value for scenic_spot.name
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot.play_time
     *
     * @return the value of scenic_spot.play_time
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public Long getPlayTime() {
        return playTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot.play_time
     *
     * @param playTime the value for scenic_spot.play_time
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setPlayTime(Long playTime) {
        this.playTime = playTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot.longitude
     *
     * @return the value of scenic_spot.longitude
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot.longitude
     *
     * @param longitude the value for scenic_spot.longitude
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot.latitude
     *
     * @return the value of scenic_spot.latitude
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot.latitude
     *
     * @param latitude the value for scenic_spot.latitude
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot.level
     *
     * @return the value of scenic_spot.level
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot.level
     *
     * @param level the value for scenic_spot.level
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot.created_at
     *
     * @return the value of scenic_spot.created_at
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot.created_at
     *
     * @param createdAt the value for scenic_spot.created_at
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot.updated_at
     *
     * @return the value of scenic_spot.updated_at
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot.updated_at
     *
     * @param updatedAt the value for scenic_spot.updated_at
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot.is_deleted
     *
     * @return the value of scenic_spot.is_deleted
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot.is_deleted
     *
     * @param isDeleted the value for scenic_spot.is_deleted
     *
     * @mbg.generated Mon Aug 20 15:30:30 CST 2018
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}