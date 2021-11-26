package com.todolist.MyToDoList.ApiResponse;

import lombok.*;

import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public abstract class ApiResponse<T> {
    @NonNull private T data;
    private List<String> errors;
}
