package com.universitycourseregistration.dto;

import lombok.Data;

import java.util.List;

@Data
public class DeleteMultipleEnrollment {

    private List<Long> enrollmentIds;
}
