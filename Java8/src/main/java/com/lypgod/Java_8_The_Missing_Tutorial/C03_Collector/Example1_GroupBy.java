package com.lypgod.Java_8_The_Missing_Tutorial.C03_Collector;

import com.lypgod.Java_8_The_Missing_Tutorial.domain.Task;
import com.lypgod.Java_8_The_Missing_Tutorial.domain.TaskType;

import java.util.*;
import java.util.stream.Collectors;

import static com.lypgod.Java_8_The_Missing_Tutorial.util.DataUtils.getTasks;
import static java.util.function.Function.identity;

public class Example1_GroupBy {

    public List<String> allTitles(List<Task> tasks) {
        return tasks.stream().map(Task::getTitle).collect(Collectors.toList());
    }

    public Set<String> uniqueTitles(List<Task> tasks) {
        return tasks.stream().map(Task::getTitle).collect(Collectors.toSet());
    }

    private static Map<String, Task> taskMap(List<Task> tasks) {
        return tasks.stream().collect(Collectors.toMap(Task::getTitle, task -> task));
    }

    private static Map<String, Task> taskMap2(List<Task> tasks) {
        return tasks.stream().collect(Collectors.toMap(Task::getTitle, identity()));
    }

    private static Map<String, Task> taskMap3(List<Task> tasks) {
        return tasks.stream().collect(Collectors.toMap(Task::getTitle, identity(), (t1, t2) -> t2));
    }

    public Map<String, Task> collectToMap(List<Task> tasks) {
        return tasks.stream().collect(Collectors.toMap(Task::getTitle, identity(), (t1, t2) -> t2, LinkedHashMap::new));
    }

    private static LinkedHashSet<Task> collectToLinkedHaskSet(List<Task> tasks) {
        return tasks.stream().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static Map<TaskType, List<Task>> groupTasksByType(List<Task> tasks) {
        return tasks.stream().collect(Collectors.groupingBy(Task::getType));
    }

    public static void main(String[] args) {
        List<Task> tasks = getTasks();
        Map<TaskType, List<Task>> allTasksByType = new HashMap<>(16);
        for (Task task : tasks) {
            List<Task> existingTasksByType = allTasksByType.get(task.getType());
            if (existingTasksByType == null) {
                List<Task> tasksByType = new ArrayList<>();
                tasksByType.add(task);
                allTasksByType.put(task.getType(), tasksByType);
            } else {
                existingTasksByType.add(task);
            }
        }
        for (Map.Entry<TaskType, List<Task>> entry : allTasksByType.entrySet()) {
            System.out.println(String.format("%s =>> %s", entry.getKey(), entry.getValue()));
        }

        System.out.println("---------------------------");

        groupTasksByType(tasks).forEach((key, value) -> System.out.println(String.format("%s =>> %s", key, value)));
    }
}
