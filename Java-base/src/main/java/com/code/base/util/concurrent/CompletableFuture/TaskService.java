package com.code.base.util.concurrent.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public interface TaskService {
    String findUser();

    default CompletableFuture<String> findUser(boolean async){

        return CompletableFuture.completedFuture(findUser());

    }

}
