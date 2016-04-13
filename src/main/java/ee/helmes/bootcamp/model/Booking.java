package ee.helmes.bootcamp.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@javax.persistence.Table(name = "booking")
public class Booking {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "date_time")
    private Date date;

    @Column(name = "duration")
    private BigDecimal duration;

    @Column(name = "count")
    private int count;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_method")
    private String contactMethod;

    @Column(name = "contact_phone_number")
    private String contactPhoneNumber;

    @Column(name = "comments")
    private String comments;

    @Column(name = "creation_time", updatable = false, insertable = false)
    private Date creationTime;

    @Column(name = "modification_time", updatable = false, insertable = false)
    private Date modificationTime;

    @Column(name = "canceled", insertable = false, updatable = true)
    private int canceled;

    public Booking() {
    }

    public Booking(Restaurant restaurant, Date date, BigDecimal duration, int count, String contactName, String contactMethod, String contactPhoneNumber, String comments) {
        this.restaurant = restaurant;
        this.date = date;
        this.duration = duration;
        this.count = count;
        this.contactName = contactName;
        this.contactMethod = contactMethod;
        this.contactPhoneNumber = contactPhoneNumber;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFormattedDate() {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm").format(date);
    }

    public String getFormattedCreationTime() {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm").format(creationTime);
    }

    public long getDateTimeStamp() {
        return date.getTime();
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public int getCanceled() {
        return canceled;
    }

    public void setCanceled(int canceled) {
        this.canceled = canceled;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", restaurant=" + restaurant +
                ", date=" + date +
                ", duration=" + duration +
                ", count=" + count +
                ", contactName='" + contactName + '\'' +
                ", contactMethod='" + contactMethod + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", comments='" + comments + '\'' +
                ", creationTime=" + creationTime +
                ", modificationTime=" + modificationTime +
                '}';
    }

}
