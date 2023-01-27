package dto;

public class historyDto {//요청인자 값
    private int id;
    private  String LAT , LNT ,Date;


    public int getId() {
        return id;
    }
    public void setId() {
        this.id = id;
    }
    public String getLAT() {
        return LAT;
    }
    public void setLAT() {
        this.LAT = LAT;
    }

    public String getLNT() {
        return LNT;
    }
    public void setLNT() {
        this.LNT = LNT;
    }

    public String getDate() {
        return Date;
    }
    public void setDate() {
        this.Date = Date;
    }
}

