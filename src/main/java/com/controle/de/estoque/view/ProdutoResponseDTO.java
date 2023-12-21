package com.controle.de.estoque.view;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ProdutoResponseDTO {


    private String message;

    private int status;

    private String errortype;

    private String errorMessage;

    public static ProdutoResponseDTO fromException(Exception exception, HttpStatus status) {
        ProdutoResponseDTO responseDTO = new ProdutoResponseDTO();
        responseDTO.setMessage("Erro ao processar a solicitação");
        responseDTO.setStatus(status.value());

        if (exception instanceof ExceptionDTO.VendasAssociadasException) {
            responseDTO.setErrortype("ProdutoNaoEncontradoException");
            responseDTO.setErrorMessage(exception.getMessage());
        } else if (exception instanceof ExceptionDTO.ProdutoNaoEncontradoException) {
            responseDTO.setErrortype("ProdutoNaoEncontradoException");
            responseDTO.setErrorMessage(exception.getMessage());
        } else {
            responseDTO.setErrortype("RuntimeException");
            responseDTO.setErrorMessage(exception.getMessage());
        }
        return responseDTO;
    }


}
