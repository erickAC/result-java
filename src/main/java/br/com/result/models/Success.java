package br.com.result.models;

public class Success<T> extends Result {
    private Result<T> result;

    public Success(T value) {
        result = new Result<T>();

        if (value == null) throw new RuntimeException("O valor não pode ser nulo");

        result.toSuccess(value);
    }

}
