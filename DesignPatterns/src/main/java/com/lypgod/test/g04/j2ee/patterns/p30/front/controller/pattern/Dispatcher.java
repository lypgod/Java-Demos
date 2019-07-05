package com.lypgod.test.g04.j2ee.patterns.p30.front.controller.pattern;

/**
 * @author richard
 */
class Dispatcher {
    public static final String STUDENT = "STUDENT";
    public static final String HOME = "HOME";
    private StudentView studentView;
    private HomeView homeView;

    Dispatcher() {
        studentView = new StudentView();
        homeView = new HomeView();
    }

    void dispatch(String request) {
        if (request.equalsIgnoreCase(STUDENT)) {
            studentView.show();
        }

        if (request.equalsIgnoreCase(HOME)) {
            homeView.show();
        }
    }
}