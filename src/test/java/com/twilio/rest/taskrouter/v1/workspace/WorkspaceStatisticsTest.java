/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class WorkspaceStatisticsTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.TASKROUTER.toString(),
                                          "/v1/Workspaces/WSaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Statistics");
            
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            WorkspaceStatistics.fetch("WSaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"cumulative\": {\"avg_task_acceptance_time\": 0.0,\"end_time\": \"2015-08-18T17:03:13Z\",\"reservations_accepted\": 0,\"reservations_canceled\": 0,\"reservations_created\": 0,\"reservations_rejected\": 0,\"reservations_rescinded\": 0,\"reservations_timed_out\": 0,\"start_time\": \"2015-08-18T16:48:13Z\",\"tasks_canceled\": 0,\"tasks_created\": 0,\"tasks_deleted\": 0,\"tasks_moved\": 0,\"tasks_timed_out_in_workflow\": 0},\"realtime\": {\"activity_statistics\": [{\"friendly_name\": \"Offline\",\"sid\": \"WAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"workers\": 1},{\"friendly_name\": \"Idle\",\"sid\": \"WAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"workers\": 0},{\"friendly_name\": \"80fa2beb-3a05-11e5-8fc8-98e0d9a1eb73\",\"sid\": \"WAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"workers\": 0},{\"friendly_name\": \"Reserved\",\"sid\": \"WAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"workers\": 0},{\"friendly_name\": \"Busy\",\"sid\": \"WAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"workers\": 0},{\"friendly_name\": \"817ca1c5-3a05-11e5-9292-98e0d9a1eb73\",\"sid\": \"WAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"workers\": 0}],\"longest_task_waiting_age\": 0,\"longest_task_waiting_sid\": null,\"tasks_by_status\": {\"assigned\": 0,\"pending\": 0,\"reserved\": 0},\"total_tasks\": 0,\"total_workers\": 1},\"workspace_sid\": \"WSaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(WorkspaceStatistics.fetch("WSaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute());
    }
}