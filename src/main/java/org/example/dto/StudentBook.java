package org.example.dto;

public class StudentBook {
    private Integer sId;
    private String sName;
    private String bName;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    @Override
    public String toString() {
        return "StudentBook{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", bName='" + bName + '\'' +
                '}';
    }
}
