package com.example.etbel.tentamen_4;

import java.io.Serializable;

/**
 * Created by Etbel on 14-6-2017.
 */

public class Films {
    public class Voorstelling implements Serializable {
        private String movieName;

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getImage_thumb_url() {
            return image_thumb_url;
        }

        public void setImage_thumb_url(String image_thumb_url) {
            this.image_thumb_url = image_thumb_url;
        }

        public String getBeschrijving() {
            return beschrijving;
        }

        public void setBeschrijving(String beschrijving) {
            this.beschrijving = beschrijving;
        }

        private String image_url;
        private String image_thumb_url;
        private String beschrijving;

        @Override
        public String toString() {
            return "Voorstelling{" +
                    "movieName='" + movieName + '\'' +
                    ", image_url='" + image_url + '\'' +
                    ", image_thumb_url='" + image_thumb_url + '\'' +
                    ", beschrijving='" + beschrijving + '\'' +
                    '}';
        }
    }}
