package com.todolist.MyToDoList.ToDoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {
    @Autowired
    private ToDoItemRepository toDoItemRepository;

    public ToDoItem get(final String id) {
// do id validation
        return toDoItemRepository.findById(id).orElse(null);
    }

    public ToDoItem create(final ToDoItem toDoItem) {
        if(toDoItem == null) {
            throw new NullPointerException("To Do Item cannot be null.");
        }
        return toDoItemRepository.insert(toDoItem);
    }

    public void delete(final String id) {
        toDoItemRepository.deleteById(id);
    }

    public List<ToDoItem> getAll() {
        return toDoItemRepository.findAll();
    }

    public ToDoItem update(final ToDoItem toDoItem) {
        if (toDoItem == null) {
            throw new NullPointerException("To Do Item cannot be null");
        }
        final ToDoItem original = toDoItemRepository.findById(toDoItem.getId())
                .orElseThrow(() -> new RuntimeException("Entity Not Found"));
        original.setDone(toDoItem.isDone());
        return toDoItemRepository.save(original);
    }
}