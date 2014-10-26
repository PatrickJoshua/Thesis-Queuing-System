/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twiliotest;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
import java.util.ArrayList;
import java.util.List;

/**
 * SAGUINSIN, Patrick Joshua B.
 * @author PatrickJoshua
 */
public class TwilioTest
{
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC272a8677986f3b6099825a315efccc71";
    public static final String AUTH_TOKEN = "8acd30d99156835c4131f84a705b8be2";
 
    public static void main(String[] args) throws TwilioRestException {
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        // Build a filter for the MessageList
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Body", "Testssss"));
        params.add(new BasicNameValuePair("To", "+639234026357"));
        params.add(new BasicNameValuePair("From", "+14803761083"));

        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message = messageFactory.create(params);
        System.out.println(message.getSid());
    }
}
