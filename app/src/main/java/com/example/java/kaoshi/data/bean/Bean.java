package com.example.java.kaoshi.data.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by java on 2018/5/11.
 */
@Entity
public class Bean {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "content")
    private String content;
    @Property(nameInDb = "img")
    private String img;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bean(String content, String img) {

        this.content = content;
        this.img = img;
    }

    @Generated(hash = 1878680875)
    public Bean(Long id, String content, String img) {
        this.id = id;
        this.content = content;
        this.img = img;
    }

    @Generated(hash = 80546095)
    public Bean() {
    }
}

