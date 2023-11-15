package com.controle.de.estoque.view;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VendaDTO {

        @NotNull
        private long id;
        @NotNull
        private int quantidade;
        @NotNull
        private double valorTotal;

}
