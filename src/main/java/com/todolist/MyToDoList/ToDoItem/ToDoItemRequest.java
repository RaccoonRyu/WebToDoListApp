package com.todolist.MyToDoList.ToDoItem;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDoItemRequest {
    private String id;
    private String title;
    private boolean isDone;
}