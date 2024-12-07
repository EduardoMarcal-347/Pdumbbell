package com.marcal.pdumbbell.dto.shared;

import java.time.Instant;

public interface BaseResponse {

    int statusCode( );

    String message( );

    Instant timestamp( );

}
