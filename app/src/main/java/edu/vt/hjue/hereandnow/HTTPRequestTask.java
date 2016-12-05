package edu.vt.hjue.hereandnow;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Luke on 12/5/2016.
 */

public class HTTPRequestTask extends AsyncTask<Void, Void, List<RestaurantJSON>> {
    @Override
    protected List<RestaurantJSON> doInBackground(Void... params) {
        try {
            final String url = "https://design-of-information.herokuapp.com/report";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<List<RestaurantJSON>> rateResponse =
                    restTemplate.exchange(url,
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<RestaurantJSON>>() {
                            });
            List<RestaurantJSON> restaurants = rateResponse.getBody();
            return restaurants;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }
}
