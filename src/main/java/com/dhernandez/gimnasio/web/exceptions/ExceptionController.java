package com.dhernandez.gimnasio.web.exceptions;

import com.dhernandez.gimnasio.domain.dto.ErrorResponseDto;
import com.dhernandez.gimnasio.domain.dto.ValidationErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({UniqueException.class})
    public ResponseEntity<ErrorResponseDto> uniqueException(HttpServletRequest peticion, UniqueException ex){

        return construirResponse(peticion, HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage(),null);
    }
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ErrorResponseDto> invalidDataException(HttpServletRequest peticion, ConstraintViolationException ex){
        List<ValidationErrorDto> errores = new ArrayList<>();

        for( ConstraintViolation violation :ex.getConstraintViolations() ) {
            ValidationErrorDto err = new ValidationErrorDto(violation.getPropertyPath().toString(),violation.getMessage());
            errores.add(err);
        }
        return construirResponse(peticion, HttpStatus.BAD_REQUEST,"Error de validacion de datos",errores);
    }

    ResponseEntity<ErrorResponseDto> construirResponse(HttpServletRequest peticion,HttpStatus status, String mensaje,List<ValidationErrorDto> errores ){
        ErrorResponseDto errorResponseDTO = new ErrorResponseDto();
        errorResponseDTO.setMensaje(mensaje);
        errorResponseDTO.setCodigoEstado(status.value());
        errorResponseDTO.setPath(peticion.getRequestURI());
        errorResponseDTO.setErrores(errores);
        return new ResponseEntity<>(errorResponseDTO,status);
    }
}
