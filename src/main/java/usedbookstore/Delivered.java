package usedbookstore;

public class Delivered extends AbstractEvent {

    private Long id;
    private Long purchaseid;
    private String status;

    public Delivered(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(Long purchaseid) {
        this.purchaseid = purchaseid;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
