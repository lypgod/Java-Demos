package com.lypgod.test.g04.j2ee.patterns.p30.front.controller.pattern;

/**
 * @author richard
 */
class FrontController {
    private Dispatcher dispatcher;

    FrontController() {
        this.dispatcher = new Dispatcher();
    }

    private boolean isAuthenticUser() {
        System.out.println("User is authenticated successfully.");
        return true;
    }

    private void trackRequest(String request) {
        System.out.println("Page requested: " + request);
    }

    void dispatchRequest(String request) {
        //记录每一个请求
        trackRequest(request);
        //对用户进行身份验证
        if (isAuthenticUser()) {
            dispatcher.dispatch(request);
        }
    }
}