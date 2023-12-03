package com.br.srv.saudeconnect.domain.mapper;

import com.br.srv.saudeconnect.dataprovider.entity.StudentEntity;
import com.br.srv.saudeconnect.domain.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    //    @Mapping(target = "studentId", source = "account.accountId")
    Student entityToDomain(StudentEntity entity);

    List<Student> entityListToDomainList(List<StudentEntity> entity);
}
