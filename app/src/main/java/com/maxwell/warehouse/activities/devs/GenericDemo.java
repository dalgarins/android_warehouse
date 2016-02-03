package com.maxwell.warehouse.activities.devs;

import com.maxwell.warehouse.interfaces.OnGenericResult;
import com.maxwell.warehouse.models.GitHubUser;

/**
 * Created by Maxwell on 03/02/2016.
 */
public class GenericDemo implements OnGenericResult<GitHubUser> {
    @Override
    public void onSuccess(GitHubUser gitHubUser) {

    }

    @Override
    public void onError(GitHubUser gitHubUser) {

    }
}
