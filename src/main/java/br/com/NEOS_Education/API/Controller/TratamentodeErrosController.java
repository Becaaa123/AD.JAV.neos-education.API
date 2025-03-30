package br.com.NEOS_Education.API.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TratamentodeErrosController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> { // Corrigido aqui
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            erros.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }


    //Classe usada internamente para resposta de erros
    public static class ErrorResponse{
        private LocalDateTime timestamp;
        private  int status;
        private String error;
        private String message;

        public ErrorResponse(LocalDateTime timestamp, int status, String error, String message){
            this.timestamp = timestamp;
            this.status = status;
            this.error = error;
            this.message = message;
        }

        public LocalDateTime getTimestamp(){
            return  timestamp;
        }
        public int getStatus(){
            return status;
        }
        public String getError(){
            return error;
        }
        public String getMessage(){
            return message;
        }
    }
}