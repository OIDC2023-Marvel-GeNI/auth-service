package marvel.geni.authservice.result;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class ApiResult<T> {
    private final boolean success;
    private final T response;
    private final ApiError error;

    public ApiResult(boolean success, T response, ApiError error) {
        this.success = success;
        this.response = response;
        this.error = error;
    }

    public ApiResult(boolean success, T response) {
        this.success = success;
        this.response = response;
        this.error = null;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResponse() {
        return response;
    }
}