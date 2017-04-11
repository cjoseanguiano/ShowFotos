package com.devix.www.showfotos;
/*
 *Created by Carlos Anguiano on 11/04/17.
 *For more info contact : c.joseanguiano@gmail.com
 */

import android.net.Uri;

public class Model {
    String name;
    Uri uri;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
