package test.model;

import java.util.Date;

public class User {
    private Integer id;

    private Integer userId;

    private String userName;

    private String realName;

    private String email;

    private Integer creatorUid;

    private Integer modifierUid;

    private Date createdAt;

    private Date updatedAt;

    private Boolean del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getCreatorUid() {
        return creatorUid;
    }

    public void setCreatorUid(Integer creatorUid) {
        this.creatorUid = creatorUid;
    }

    public Integer getModifierUid() {
        return modifierUid;
    }

    public void setModifierUid(Integer modifierUid) {
        this.modifierUid = modifierUid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", email='" + email + '\'' +
                ", creatorUid=" + creatorUid +
                ", modifierUid=" + modifierUid +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", del=" + del +
                '}';
    }
}