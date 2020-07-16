package usedbookstore;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Customer_table")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String grade;
    private Long usecnt;
    private Long point;

    @PostPersist
    public void onPostPersist(){
        CustomerRegistered customerRegistered = new CustomerRegistered();
        BeanUtils.copyProperties(this, customerRegistered);
        customerRegistered.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        PointSaved pointSaved = new PointSaved();
        BeanUtils.copyProperties(this, pointSaved);
        pointSaved.publishAfterCommit();


//        CustomerUpgraded customerUpgraded = new CustomerUpgraded();
//        BeanUtils.copyProperties(this, customerUpgraded);
//        customerUpgraded.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public Long getUsecnt() {
        return usecnt;
    }

    public void setUsecnt(Long usecnt) {
        this.usecnt = usecnt;
    }
    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }




}
