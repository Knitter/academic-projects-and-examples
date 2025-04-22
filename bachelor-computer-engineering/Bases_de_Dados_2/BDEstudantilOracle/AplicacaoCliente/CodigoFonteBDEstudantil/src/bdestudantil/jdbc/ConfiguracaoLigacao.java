package bdestudantil.jdbc;

import java.sql.Connection;

public class ConfiguracaoLigacao {
    private String ip   = new String();
    private String bd   = new String();
    private String user = new String();
    private String pass = new String();
    private String port = new String();
    private Connection con;

    private static final ConfiguracaoLigacao conf=new ConfiguracaoLigacao();

    private ConfiguracaoLigacao() {
        this.ip="localhost";
        this.bd="home";
        this.user="knt";
        this.pass="knt";
        this.port="1521";
    }

    public static ConfiguracaoLigacao getConf() {
      return conf;
    }

    public void reconfigure(String ip, String bd, String user, String pass, String port){
        this.ip=ip;
        this.bd=bd;
        this.user=user;
        this.pass=pass;
        this.port=port;
    }

    public String getBd() {
        return bd;
    }

    public String getIp() {
        return ip;
    }

    public String getPass() {
        return pass;
    }

    public String getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public Connection getCon() {
        return con;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
