package com.lypgod.Java_8_The_Missing_Tutorial.C02_Streams;

import com.lypgod.Java_8_The_Missing_Tutorial.domain.Task;
import com.lypgod.Java_8_The_Missing_Tutorial.domain.TaskType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.lypgod.Java_8_The_Missing_Tutorial.util.DataUtils.getTasks;


public class Example1_Java7 {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();
        List<Task> readingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getType() == TaskType.READING) {
                readingTasks.add(task);
            }
        }
        Collections.sort(readingTasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.getTitle().length() - t2.getTitle().length();
            }
        });
        for (Task readingTask : readingTasks) {
            System.out.println(readingTask.getTitle());
        }

        System.out.println("----------------------------------");

        getTasks().stream()
                .filter(e -> e.getType() == TaskType.READING)
                .sorted(Comparator.comparingInt(e2 -> e2.getTitle().length()))
                .map(Task::getTitle)
                .forEach(System.out::println);
    }
}