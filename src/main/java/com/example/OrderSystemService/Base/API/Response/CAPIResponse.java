package com.example.OrderSystemService.Base.API.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;


@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@ToString
public class CAPIResponse
{

    private String statusDescription;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String successMessage;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String errorMessage;

    public CAPIResponse setStatus(HttpStatus status)
    {
        this.statusDescription = status.name();
        return this;
    }

    public CAPIResponse setSuccessMessage(String message)
    {
        this.successMessage = message;

        return this;
    }

    public CAPIResponse setErrorMessage(String message)
    {
        this.errorMessage = message;

        return this;
    }

}
