package br.com.mesttra.apipecas.exception;

import br.com.mesttra.apipecas.dto.ErroValidResponseDTO;
import br.com.mesttra.apipecas.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final int POS_ERRO = 0;

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler({ErroDeNegocioException.class})
    public @ResponseBody ResponseDTO handleBusinessErrors(Exception e) {
        return new ResponseDTO(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public @ResponseBody List<ErroValidResponseDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        List<ErroValidResponseDTO> resposta = new ArrayList<ErroValidResponseDTO>();

        for (ObjectError err : e.getBindingResult().getAllErrors()) {

            String erroCompleto = err.getCodes()[POS_ERRO];
            String campoErro = erroCompleto.substring(erroCompleto.lastIndexOf(".") + 1, erroCompleto.length());

            resposta.add(new ErroValidResponseDTO(campoErro, err.getDefaultMessage()));

        }

        return resposta;
    }

}
