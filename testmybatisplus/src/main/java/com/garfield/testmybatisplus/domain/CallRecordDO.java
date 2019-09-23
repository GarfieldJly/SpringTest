package com.garfield.testmybatisplus.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "call_record")
@Data
public class CallRecordDO {

  /**
   * 呼叫记录表主键
   */
  @Id
  @Column(name = "call_record_id")
  private Long callRecordId;

  /**
   * 企业ID
   */
  @Column(name = "enterprise_id")
  private Long enterpriseId;

  /**
   * 呼叫任务ID
   */
  @Column(name = "call_task_id")
  private Long callTaskId;

  /**
   * 客户ID
   */
  @Column(name = "customer_id")
  private Long customerId;

  /**
   * 操作人ID
   */
  @Column(name = "user_id")
  private Long userId;

  /**
   * 外呼类型:0 人工拨打 1 AI拨打 2 呼叫中心
   */
  @Column(name = "call_type")
  private Integer callType;

  /**
   * 客户电话号码
   */
  @Column(name = "customer_phone")
  private String customerPhone;

  /**
   * 主叫号码
   */
  private String phone;

  /**
   * 外呼开始时间
   */
  @Column(name = "call_start_time")
  private Date callStartTime;

  /**
   * 通话时长：精确到秒
   */
  @Column(name = "call_duration")
  private Long callDuration;

  /**
   * 转人工状态：0 未转人工，1 转人工成功，2 转人工失败
   */
  @Column(name = "transfer_status")
  private Integer transferStatus;

  /**
   * 转接失败原因
   */
  @Column(name = "transfer_status_reason")
  private String transferStatusReason;

  /**
   * ai通话时长
   */
  @Column(name = "ai_call_duration")
  private Long aiCallDuration;

  /**
   * 坐席通话时长
   */
  @Column(name = "agent_call_duration")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long agentCallDuration;

  /**
   * 呼叫状态，901-nlp初始化失败，902-dialog delete失败，910-关机，来电提醒，911-占线，通话中，正忙，912-无人接，913-拒接，914-无法接通，915-空号，916-停机
   */
  @Column(name = "call_code")
  private String callCode;

  /**
   * 意向CODE
   */
  @Column(name = "intent_code")
  private String intentCode;

  /**
   * 人工意向
   */
  @Column(name = "artificial_intent_code")
  private String artificialIntentCode;

  /**
   * 通话音频地址
   */
  @Column(name = "dialogue_audio_url")
  private String dialogueAudioUrl;

  /**
   * 呼叫ID
   */
  @Column(name = "call_id")
  private String callId;

  /**
   * 第三方AI接待的场景id
   */
  @Column(name = "scene_id")
  private Long sceneId;

  /**
   * 是否已读 0: 未读；1：已读
   */
  @Column(name = "is_read")
  private Integer isRead;

  /**
   * 是否删除
   */
  @Column(name = "is_delete")
  private Integer isDelete;

  /**
   * 对话次数
   */
  @Column(name = "dialog_count")
  private Long dialogCount;

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
   * 话术模板名称
   */
  @Column(name = "template_name")
  private String templateName;

  /**
   * 外呼任务名称
   */
  @Column(name = "call_task_name")
  private String callTaskName;

  /**
   * 操作人名称
   */
  @Column(name = "user_name")
  private String userName;

  /**
   * 1-已接通，2-用户拒接，3-用户未接，4-用户关机，5-用户占线，6-主叫欠费，7-线路异常，8-其它异常，9-用户停机，10-空号
   */
  @Column(name = "call_code_type")
  private String callCodeType;

  /**
   * 对话标签
   */
  private String tag;

  /**
   * 是否回调完成 0：未回调 1：已回调
   */
  @Column(name = "is_callbacked")
  private Integer isCallbacked;

  /**
   * 是否开启自动重启 "YES":开启 “NO”:不开启
   */
  @Column(name = "is_reboot")
  private String isReboot;

  /**
   * 修改人
   */
  @Column(name = "modify_id")
  private Long modifyId;

  /**
   * 话术模板CODE
   */
  @Column(name = "template_code")
  private String templateCode;

  /**
   * 话术版本号
   */
  @Column(name = "template_version")
  private String templateVersion;

  /**
   * 短信发送结果，-1：发送失败，0-未发送，1-发送成功
   */
  @Column(name = "sms_send_result")
  private Integer smsSendResult;

}
