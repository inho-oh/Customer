package usedbookstore;

public class CustomerUpgraded extends AbstractEvent {

    private Long id;
    private String grade;
    private Long usecnt;
    private Long point;

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
