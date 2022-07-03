package sda.travelagency.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ServiceResponse<T> {
    protected boolean success;
    protected T result;
    protected List<String> messages = new ArrayList<>();

    public static <T> ServiceResponse success(T data) {
        return ServiceResponse.builder()
                .success(true)
                .result(data)
                .build();
    }

    public static <T> ServiceResponse success() {
        return ServiceResponse.builder()
                .success(true)
                .build();
    }

    public static <T> ServiceResponse success(String message) {
        return ServiceResponse.builder()
                .success(true)
                .messages(List.of(message))
                .build();
    }

    public static <T> ServiceResponse error(String message) {
        return ServiceResponse.builder()
                .success(false)
                .messages(List.of(message))
                .build();
    }
}
