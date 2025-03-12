package br.com.result;

import br.com.result.models.Result;
import br.com.result.models.Success;

public class Main {
    public static void main(String[] args) {
        Boolean teste = testResult().value;
        System.out.println(teste);
    }

    public static Result<Boolean> testResult() {
        return new Success<Boolean>(true);
    }
}