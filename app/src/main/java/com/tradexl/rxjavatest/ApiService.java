package com.tradexl.rxjavatest;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Raghav on 03-Nov-17.
 */

public interface ApiService {
    @GET("inbox.json")
    Observable<List<InboxModel>> getInbox();
}
