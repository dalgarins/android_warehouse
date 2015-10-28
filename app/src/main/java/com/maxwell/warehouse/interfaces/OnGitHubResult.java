package com.maxwell.warehouse.interfaces;

import com.maxwell.warehouse.models.GitHubUser;

public interface OnGitHubResult {

    void onSuccess(GitHubUser gitHubUser);
    void onNetworkError();
    void onError();
}
