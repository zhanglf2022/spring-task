package com.lingoace.task.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class LessonPreparationInfo implements Serializable {
    private static final long serialVersionUID = 3462692861004220875L;
    private Integer id;

    private Long tutorUserId;

    private Integer lessonId;

    private Integer times;

    private Long duration;

    private Date startTime;

    private Date endTime;

    private Integer status;

    private Date createTime;

    private Date updateTime;

}