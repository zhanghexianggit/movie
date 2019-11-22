package com.bw.movie.bean;

import android.support.annotation.IntDef;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/15
 * @Description:
 */
@Entity
public class DaoBean {
    @Id
    private Long id;
    private String usserId;
    private String sessionId;
    @Generated(hash = 1793739441)
    public DaoBean(Long id, String usserId, String sessionId) {
        this.id = id;
        this.usserId = usserId;
        this.sessionId = sessionId;
    }
    @Generated(hash = 405743142)
    public DaoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsserId() {
        return this.usserId;
    }
    public void setUsserId(String usserId) {
        this.usserId = usserId;
    }
    public String getSessionId() {
        return this.sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
