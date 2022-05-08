package com.at.internship.schedule.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime time;
    @Column(nullable = false)
    private String subject;
    //We should use a relation
    @Column(nullable = false)
    private Integer contactId;
    @Transient
    private Contact contact;

    @Column(insertable = false, updatable = false)
    private LocalDateTime createDate;
    @Column(insertable = false)
    private LocalDateTime lastUpdateDate;

    public Appointment(Appointment source) {
        if(source == null)
            return;
        this.id = source.id;
        this.contactId = source.contactId;
        this.time = source.time;
        this.subject = source.subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return String.format("%s. %s -- %s : %s", id, time, contact, subject);
    }

}
