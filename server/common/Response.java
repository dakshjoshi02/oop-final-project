package common;

public class Response
{
    public boolean isSuccessful;
    public String responseMessage;
    
    public Response(boolean isSuccessful, String responseMessage)
    {
        this.isSuccessful = isSuccessful;
        this.responseMessage = responseMessage;
    }
}