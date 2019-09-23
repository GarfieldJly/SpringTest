package com.garfield.testmybatisplus.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "call_task")
@Data
public class CallTaskDO {

  /**
   * 呼叫任务主键
   */
  @Id
  @Column(name = "call_task_id")
  private Long callTaskId;

  /**
   * 任务类型（AI：正常呼叫；PERSIST：TTS任务；GROUP:坐席组外呼任务; TTS_AI :真人加TTS）
   */
  @Column(name = "call_task_type")
  private String callTaskType;

  /**
   * 任务支持永久有效 "YES":持久有效 "NO":有时间限制
   */
  private String persistent;

  /**
   * 呼叫任务名称
   */
  private String name;

  /**
   * 话术模板code
   */
  @Column(name = "template_code")
  private String templateCode;

  /**
   * 话术模板名称
   */
  @Column(name = "template_name")
  private String templateName;

  /**
   * 主叫号码多个以逗号分隔
   */
  @Column(name = "call_phones")
  private String callPhones;

  /**
   * 主叫号码信息
   */
  @Column(name = "call_phone_params")
  private String callPhoneParams;

  /**
   * 人工外呼任务，接入的坐席组
   */
  @Column(name = "call_group_params")
  private String callGroupParams;

  /**
   * 坐席组ids
   */
  @Column(name = "call_group_ids")
  private String callGroupIds;

  /**
   * 座席组类型 SYSTEM:系统内人工坐席组;THIRD:第三方坐席
   */
  @Column(name = "agent_type")
  private String agentType;

  /**
   * 任务开始时间
   */
  @Column(name = "start_time")
  private Date startTime;

  /**
   * 任务完成时间
   */
  @Column(name = "complete_time")
  private Date completeTime;

  /**
   * 任务结束时间
   */
  @Column(name = "end_time")
  private Date endTime;

  /**
   * 并发比率
   */
  @Column(name = "concurrent_rate")
  private double concurrentRate;

  /**
   * AI数量
   */
  @Column(name = "ai_count")
  private Long aiCount;

  /**
   * 任务状态：1未启动，2进行中，3已停止，4已完成
   */
  private Integer status;

  /**
   * 任务描述
   */
  private String remark;

  /**
   * 企业ID
   */
  @Column(name = "enterprise_id")
  private Long enterpriseId;

  /**
   * 任务创建者ID
   */
  @Column(name = "user_id")
  private Long userId;

  /**
   * 是否开启自动重启 "YES":开启 “NO”:不开启
   */
  @Column(name = "is_reboot")
  private String isReboot;

  /**
   * 需要重新拨打的状态
   */
  @Column(name = "reboot_status")
  private String rebootStatus;

  /**
   * 需要重新拨打的次数
   */
  @Column(name = "reboot_num")
  private Long rebootNum;

  /**
   * 重新拨打的时间间隔
   */
  @Column(name = "reboot_period")
  private Long rebootPeriod;

  /**
   * 已经拨打的次数
   */
  @Column(name = "already_reboot_num")
  private Long alreadyRebootNum;

  /**
   * 最后一次重新拨打的时间
   */
  @Column(name = "last_reboot_time")
  private Date lastRebootTime;

  /**
   * 是否等待重拨
   */
  @Column(name = "is_wait_reboot")
  private String isWaitReboot;

  /**
   * 重呼次数
   */
  @Column(name = "again_call_times")
  private Long againCallTimes;

  /**
   * 重呼间隔时间，单位分钟
   */
  @Column(name = "again_call_interval")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long againCallInterval;

  /**
   * 挂机短信模板ID
   */
  @Column(name = "sms_template_id")
  private Long smsTemplateId;

  /**
   * 挂机短信模板名称
   */
  @Column(name = "sms_template_name")
  private String smsTemplateName;

  /**
   * 任务状态描述
   */
  @Column(name = "status_info")
  private String statusInfo;

  /**
   * 空号开关
   */
  @Column(name = "empty_number_switch")
  private Integer emptyNumberSwitch;

  /**
   * 单通电话上传开关
   */
  @Column(name = "single_record_switch")
  private Integer singleRecordSwitch;

  /**
   * 创建时间
   */
  @Column(name = "create_time")
  private Date createTime;

  /**
   * 更新时间
   */
  @Column(name = "update_time")
  private Date updateTime;

  /**
   * 是否删除
   */
  @Column(name = "is_delete")
  private Integer isDelete;

}
