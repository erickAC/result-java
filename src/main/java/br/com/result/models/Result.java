package br.com.result.models;

import java.util.function.Consumer;
import java.util.function.Function;

public class Result<T> {

    public T value;
    public Consumer<T> right;
    public Consumer<Exception> left;
    public boolean error;

    Result() {
        this.right = t -> {};
        this.left = t -> {};
    }

    public static <T> Result<T> toFailure(Exception exception) {
        Result<T> result = new Result<>();
        result.error = true;
        result.left = (x) -> { throw new RuntimeException(x); };
        return result;
    }

    public static <T> Result<T> toSuccess(T value) {
        Result<T> result = new Result<>();
        result.error = false;
        result.value = value;
        result.right = (x) -> {};
        return result;
    }

    public void fold(Consumer<T> onSuccess, Consumer<Exception> onFailure) {
        if (error) {
            onFailure.accept(new RuntimeException("Erro no processo"));
        } else {
            onSuccess.accept(value);
        }
    }

    @Override
    public String toString() {
        return "Result{" +
                "right=" + right +
                ", left=" + left +
                ", error=" + error +
                '}';
    }
}
