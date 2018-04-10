package com.java8;

public class IpUser {
    private String ip;
    private String let;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLet() {
        return let;
    }

    public void setLet(String let) {
        this.let = let;
    }

    @Override
    public String toString() {
        return "IpUser{" +
                "ip='" + ip + '\'' +
                ", let='" + let + '\'' +
                '}';
    }
}
