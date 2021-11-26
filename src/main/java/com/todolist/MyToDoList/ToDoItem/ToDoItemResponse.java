package com.todolist.MyToDoList.ToDoItem;

import lombok.Builder;
import com.todolist.MyToDoList.ApiResponse.ApiResponse;
import java.util.List;

public class ToDoItemResponse extends ApiResponse<ToDoItem> {

    @Builder
    public ToDoItemResponse(final ToDoItem toDoItem, final List<String> errors) {
        super(toDoItem);
        this.setErrors(errors);
    }
}