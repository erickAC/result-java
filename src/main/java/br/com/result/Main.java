package br.com.result;

import br.com.result.models.Result;

public class Main {
    public static void main(String[] args) {

        Result<Boolean> resultSuccess = Result.toSuccess(true);
        Result<Boolean> resultFailure = Result.toFailure(new Exception("vasco"));

        resultSuccess.fold(
                success -> System.out.println("Sucesso " + success),
                        exception -> System.out.println("Erro " + exception.getMessage())
        );

        resultFailure.fold(
                success -> System.out.println("Sucesso " + success),
                exception -> System.out.println("erro " + exception.getMessage())
        );

    }
}