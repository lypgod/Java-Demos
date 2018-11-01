package com.lypgod.Java_8_The_Missing_Tutorial.C02_Streams;

import com.lypgod.Java_8_The_Missing_Tutorial.domain.Task;
import com.lypgod.Java_8_The_Missing_Tutorial.domain.TaskType;

import java.util.List;
import java.util.stream.Collectors;

import static com.lypgod.Java_8_The_Missing_Tutorial.util.DataUtils.getTasks;


public class Example1_Stream {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();

        List<String> readingTasks = tasks.stream()
                .filter(task -> task.getType() == TaskType.READING)
                .sorted((t1, t2) -> t1.getTitle().length() - t2.getTitle().length())
                .map(Task::getTitle)
                .collect(Collectors.toList());

        readingTasks.forEach(System.out::println);
    }
}