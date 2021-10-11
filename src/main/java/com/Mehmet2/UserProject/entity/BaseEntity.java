package com.Mehmet2.UserProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity implements Serializable {
//Serializable nesnemizi networkden tasıma diske yazmaya yarar
    private Date createdDate;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
}
