package com.br.srv.saudeconnect.entrypoint.rest.mapper;

import com.br.srv.saudeconnect.domain.entity.Student;
import com.br.srv.saudeconnect.entrypoint.rest.dto.student.response.StudentDetailResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.student.response.StudentResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestStudentMapper {
    StudentDetailResponseDTO domainToDto(Student domain);

    List<StudentResponseDTO> domainListToDtoList(List<Student> domain);
}
