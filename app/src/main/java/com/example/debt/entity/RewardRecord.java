package com.example.debt.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class RewardRecord {
    @Id(autoincrement = true)
    Long id;
    //成员名
    String memberName;
    //粉丝名
    String fanName;
    //手机号
    String phone;
    //身份证
    String idCard;
    //福利等级
    String rewardLevel;
    //年
    String year;
    //月
    String month;
    //备注
    String note;
    //是否已领取
    boolean isPayed;
    @Generated(hash = 1646328278)
    public RewardRecord(Long id, String memberName, String fanName, String phone,
            String idCard, String rewardLevel, String year, String month,
            String note, boolean isPayed) {
        this.id = id;
        this.memberName = memberName;
        this.fanName = fanName;
        this.phone = phone;
        this.idCard = idCard;
        this.rewardLevel = rewardLevel;
        this.year = year;
        this.month = month;
        this.note = note;
        this.isPayed = isPayed;
    }
    @Generated(hash = 533795983)
    public RewardRecord() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMemberName() {
        return this.memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getFanName() {
        return this.fanName;
    }
    public void setFanName(String fanName) {
        this.fanName = fanName;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getIdCard() {
        return this.idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getRewardLevel() {
        return this.rewardLevel;
    }
    public void setRewardLevel(String rewardLevel) {
        this.rewardLevel = rewardLevel;
    }
    public String getYear() {
        return this.year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getMonth() {
        return this.month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public String getNote() {
        return this.note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public boolean getIsPayed() {
        return this.isPayed;
    }
    public void setIsPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }
}
