package common;

public class Response
{
    public boolean isSuccessful;
    public String responseString;
    
    public Response()
    {
        
    }
    
    public Response(boolean isSuccessful, String responseString)
    {
        this.isSuccessful = isSuccessful;
        this.responseString = responseString;
    }
}