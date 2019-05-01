package com.example.whowroteit;

import android.net.Uri;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class FetchBook extends AsyncTask<String, Void, String>{
    private WeakReference<TextView> titleResult;
    private WeakReference<TextView> authorResult;

    //API URL variables
    private static final String BOOK_BASE_URL =
            "https://www.googleapis.com/books/v1/volumes?";
    // Parameter for the search string.
    private static final String QUERY_PARAM = "q";
    // Parameter that limits search results.
    private static final String MAX_RESULTS = "maxResults";
    // Parameter to filter by print type.
    private static final String PRINT_TYPE = "Books";
    FetchBook(TextView titleResult, TextView authorResult) {
        this.titleResult = new WeakReference<>(titleResult);
    }
    @Override
    protected String doInBackground(String... strings) {
        String bookQuery = strings[0];
        HttpURLConnection urlConnection;
        BufferedReader reader;
        String jsonResponse;

        Uri buildURL = Uri.parse(BOOK_BASE_URL).buildUpon().
                appendQueryParameter(QUERY_PARAM, bookQuery).
                appendQueryParameter(MAX_RESULTS, "10").
                appendQueryParameter(PRINT_TYPE, "books").build();
        try {
            URL apiURL = new URL(buildURL.toString());
            urlConnection = (HttpURLConnection)apiURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
