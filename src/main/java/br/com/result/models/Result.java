package br.com.result.models;

import java.util.function.Consumer;
import java.util.function.Function;

public class Result<T> {

    public T value;
    public Consumer<T> right;
    public Consumer<Exception> left;
    public boolean error;

    public Result<T> toFailure(Exception exception) {
        Result<T> result = new Result<>();
        result.error = true;
        result.left = (x) -> { throw new RuntimeException(x); };
        this.left.accept(exception);
        return result;
    }

    public void toSuccess(T value) {
        Result<T> result = new Result<>();
        result.error = false;
        result.
        result.left = (x) -> { throw new RuntimeException(x); };
        this.left.accept(exception);
        return result;
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
