package com.lypgod.Java_8_The_Missing_Tutorial.C01_Lambdas;

import com.lypgod.Java_8_The_Missing_Tutorial.domain.Task;
import com.lypgod.Java_8_The_Missing_Tutorial.domain.TaskType;
import com.lypgod.Java_8_The_Missing_Tutorial.util.DataUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lypgo
 */
public class Exercise_Lambdas {
    public static void main(String[] args) {
//        List<Task> tasks = DataUtils.getTasks();
//        List<String> titles = taskTitles(tasks);
//        for (String title : titles) {
//            System.out.println(title);
//        }

        DataUtils.getTasks()
                .stream()
                .filter(e -> e.getType() == TaskType.READING)
                .map(Task::getTitle)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static List<String> taskTitles(List<Task> tasks) {
        List<String> readingTitles = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getType() == TaskType.READING) {
                readingTitles.add(task.getTitle());
            }
        }
        return readingTitles;
    }
}