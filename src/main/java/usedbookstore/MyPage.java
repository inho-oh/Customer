package usedbookstore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="MyPage_table")
public class MyPage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long customerid;
        private Long purchaseid;
        private Integer purchaseqty;
        private Date purchasedate;
        private Date canceldate;
        private Long deliveryid;
        private String status;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getCustomerid() {
        return customerid;
    }

        public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }
        public Long getPurchaseid() {
            return purchaseid;
        }

        public void setPurchaseid(Long purchaseid) {
            this.purchaseid = purchaseid;
        }
        public Integer getPurchaseqty() {
            return purchaseqty;
        }

        public void setPurchaseqty(Integer purchaseqty) {
            this.purchaseqty = purchaseqty;
        }
        public Date getPurchasedate() {
            return purchasedate;
        }

        public void setPurchasedate(Date purchasedate) {
            this.purchasedate = purchasedate;
        }
        public Date getCanceldate() {
            return canceldate;
        }

        public void setCanceldate(Date canceldate) {
            this.canceldate = canceldate;
        }
        public Long getDeliveryid() {
            return deliveryid;
        }

        public void setDeliveryid(Long deliveryid) {
            this.deliveryid = deliveryid;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

}
