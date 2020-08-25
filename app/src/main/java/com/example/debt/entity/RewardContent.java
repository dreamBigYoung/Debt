package com.example.debt.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class RewardContent {
    @Id(autoincrement = true)
    Long id=0L ;

    String level;

    String content;

    @Generated(hash = 624029241)
    public RewardContent(Long id, String level, String content) {
        this.id = id;
        this.level = level;
        this.content = content;
    }

    @Generated(hash = 432962553)
    public RewardContent() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
